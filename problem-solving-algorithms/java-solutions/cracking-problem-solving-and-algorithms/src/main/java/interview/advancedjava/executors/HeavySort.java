package interview.advancedjava.executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HeavySort {

  private static boolean noisy = true;
  public static void main(String [] args){
	    int  problemSize = 200000000;
	    int numThreads = 6;
	    Random random = new Random();
	    Integer[] sortArray = new Integer[problemSize];
	    for (int i=0; i< problemSize ;i++){
	      sortArray[i] = random.nextInt(Integer.MAX_VALUE );
	    }
	    long startTime2 = System.currentTimeMillis();
	    Arrays.sort(sortArray);
	    System.out.println("Single Threaded Sort: time taken " + 
	        (System.currentTimeMillis() - startTime2));
	    Collections.shuffle(Arrays.asList(sortArray));
	    final ExecutorService executor = Executors.newFixedThreadPool(numThreads);
	    long startTime = System.currentTimeMillis();
	    ArrayFactory<Integer> factory = new ArrayFactory<Integer>(){

	      @Override
	      public Integer[] buildArray(int length) {
	        return new Integer[length];
	      }

	    };
	    HeavySort.sort(sortArray,executor,numThreads,factory);
	    System.out.println("Multi-Threaded sort: time taken " + 
	        (System.currentTimeMillis() - startTime));
	    

	    for (int i=0; i<sortArray.length-1; i++){
	      if(sortArray[i] > sortArray[i+1]){
	        System.err.println("Error: element at " + i 
	            + " : " + sortArray[i]  );
	        System.err.println("Error: element at " + 
	            (i+1) + " : " + sortArray[i+1]  );
	      }

	    }
	    executor.shutdown();
	  }


  
  public static <T extends Comparable<T>> void sort(T[] data, 
      ExecutorService service, int numThreads, 
      ArrayFactory<T> arrayFactory){
    if(data.length <= 1){
      return;
    }
    List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
    int[] startingPoints = new int[numThreads];
    for(int i = 0; i < numThreads;i++){
      int lo = data.length*i/numThreads;
      startingPoints[i] = lo;
      int hi = data.length*(i+1)/numThreads;
      tasks.add(new SortSubsequence<T>(data,lo,hi));
    }
    long sortingTime = System.currentTimeMillis();
    try {
      List<Future<Boolean>> results = service.invokeAll(tasks);
      for(Future<Boolean> result: results){
        if(!result.get().booleanValue()){
          throw new RuntimeException();
        }
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    }
    if(noisy){
      System.out.println("Sorting Time " + 
          (System.currentTimeMillis() - sortingTime));
    }
    List<T> dividers = new ArrayList<T>();
    int hi = data.length/numThreads;
    dividers.add(null);
    for(int i = 1; i < numThreads; i++){
      dividers.add(data[(hi*i)/numThreads]);
    }
    dividers.add(null);
    List<Callable<T[]>> merges = new ArrayList<Callable<T[]>>();
    for(int i = 0 ; i < numThreads; i++){
      merges.add(new MergeSubsequences<T>(dividers.get(i),
          dividers.get(i+1),data,startingPoints,arrayFactory));
    }
    List<T[]> resultsCollected = new ArrayList<T[]>();
    long mergingTime = System.currentTimeMillis();
    try {
      List<Future<T[]>> results = service.invokeAll(merges);
      for(Future<T[]> result: results){
        resultsCollected.add(result.get());
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    }
    if(noisy){
      System.out.println("Merging Time " + 
          (System.currentTimeMillis() - mergingTime));
    }
    List<Callable<Boolean>> pastes = new ArrayList<Callable<Boolean>>();
    int startingPoint = 0;
    for(int i = 0 ; i < numThreads; i++){
      pastes.add(new Paste<T>(startingPoint, 
          data,resultsCollected.get(i)));
      startingPoint+= resultsCollected.get(i).length;
    }
    long pastingTime = System.currentTimeMillis();
    try {
      List<Future<Boolean>> pastesResults = service.invokeAll(pastes);
      for(Future<Boolean> result: pastesResults){
        if(!result.get().booleanValue()){
          throw new RuntimeException();
        }
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    }
    if(noisy){
      System.out.println("Pasting Time " + 
          (System.currentTimeMillis() - pastingTime));
    }
  }

  public static interface ArrayFactory<T extends Comparable<T>>{
    public T[] buildArray(int length);
  }

  private static class Paste<T extends Comparable<T>> implements
      Callable<Boolean>{

    private int lo;
    private T[] data;
    private T[] source;

    public Paste(int lo, T[] data, T[] source) {
      super();
      this.lo = lo;
      this.data = data;
      this.source = source;
    }

    @Override
    public Boolean call() throws Exception {
      System.arraycopy(source, 0, data, lo, source.length);
      return Boolean.valueOf(true);
    }
  }

  private static class MergeSubsequences<T extends Comparable<T>> implements
      Callable<T[]>{

    private T lo;
    private T hi;
    private T[] data;
    private int[] startingPoints;
    private int[] endPoints;
    private ArrayFactory<T> arrayFactory;

    public MergeSubsequences(T lo, T hi, T[] data, 
        int[] startingPoints, ArrayFactory<T> arrayFactory) {
      super();
      this.arrayFactory = arrayFactory;
      this.lo = lo;
      this.hi = hi;
      this.data = data;
      this.startingPoints = startingPoints;
      this.endPoints = new int[startingPoints.length];
      for(int i = 0; i < startingPoints.length-1; i++){
        endPoints[i] = startingPoints[i+1];
      }
      endPoints[endPoints.length-1] = data.length;
    }

    @Override
    public T[] call() throws Exception {

      int[] currentLocationBySection = Arrays.copyOf(
          startingPoints, startingPoints.length);
      int[] upperBoundsBySection = Arrays.copyOf(
          endPoints, endPoints.length);

      if(lo != null){
        for(int i = 0; i < currentLocationBySection.length; i++){
          currentLocationBySection[i] = Arrays.binarySearch(
              data, startingPoints[i], endPoints[i], lo);
          if(currentLocationBySection[i] < 0){
            currentLocationBySection[i] = 
              -currentLocationBySection[i] - 1;
          }
        }
      }
      if(hi != null){
        for(int i = 0; i < upperBoundsBySection.length; i++){
          upperBoundsBySection[i] = Arrays.binarySearch(
              data, startingPoints[i], endPoints[i], hi);
          if(upperBoundsBySection[i] < 0){
            upperBoundsBySection[i] = 
              -upperBoundsBySection[i] - 1;
          }
        }
      }
      boolean[] sectionsInBounds = 
        new boolean[currentLocationBySection.length];
      Arrays.fill(sectionsInBounds, true);
      int numSectionsInBounds = sectionsInBounds.length;
      int totalItems = 0;
      for(int i = 0; i < sectionsInBounds.length; i++){
        if(currentLocationBySection[i] >= upperBoundsBySection[i]){
          sectionsInBounds[i] = false;
          numSectionsInBounds--;
        }
        else{
          totalItems += upperBoundsBySection[i] -
          currentLocationBySection[i];
        }    
      }
      T[] ans = arrayFactory.buildArray(totalItems);
      int ansInd = 0;
      while(numSectionsInBounds > 0){
        int bestSection = -1;
        T best = null;
        for(int i = 0; i < sectionsInBounds.length; i++){
          if(sectionsInBounds[i]){
            if(best == null || 
                data[currentLocationBySection[i]].compareTo(best)
                < 0){
              bestSection = i;
              best = data[currentLocationBySection[i]];
            }
          }        
        }        
        ans[ansInd] = best;
        ansInd++;
        currentLocationBySection[bestSection]++;
        if(currentLocationBySection[bestSection] 
                                    >= upperBoundsBySection[bestSection]){
          sectionsInBounds[bestSection] = false;
          numSectionsInBounds--;
        }
      }
      return ans;
    }
  }

  private static class SortSubsequence<T extends Comparable<T>> implements
      Callable<Boolean>{

    private T[] data;
    private int lo;
    private int hi;

    public SortSubsequence(T[] data, int lo, int hi) {
      super();
      this.data = data;
      this.lo = lo;
      this.hi = hi;
    }

    @Override
    public Boolean call() throws Exception {
      Arrays.sort(data,lo,hi);
      return Boolean.valueOf(true);
    }
  }
}