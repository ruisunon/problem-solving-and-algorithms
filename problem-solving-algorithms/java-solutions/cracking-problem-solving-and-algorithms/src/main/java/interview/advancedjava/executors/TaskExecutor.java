package interview.advancedjava.executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class TaskExecutor {
   public static void main(String[] args) {
	   ExecutorService executor = Executors.newFixedThreadPool(2);
	   ThreadPoolExecutor executor1 = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
	   Future< Long > result = executor.submit(new Callable< Long >() {
		     @Override
		     public Long call() throws Exception {
		        // Some implementation here
		    	 List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		    	 numbers.forEach(System.out::println);
		    	 return Long.valueOf(11);
		     }            
		} );
	   executor.shutdown();
	   testCallalbe();
   }
   
   public static void testCallalbe() 
   {
       ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        
       List<Future<Integer>> resultList = new ArrayList<>();
        
       Random random = new Random();
        
       for (int i=0; i<4; i++)
       {
           Integer number = random.nextInt(10);
           FactorialCalculator calculator  = new FactorialCalculator(number);
           Future<Integer> result = executor.submit(calculator);
           resultList.add(result);
       }
        
       Integer total =0;
       for(Future<Integer> future : resultList)
       {
             try
             {
            	 total+=future.get();
                 System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
                 
             } 
             catch (InterruptedException | ExecutionException e) 
             {
                 e.printStackTrace();
             }
         }
         
         System.out.println("Total result is - " + " - " + total);
       
         //shut down the executor service now
         executor.shutdown();
   }
}
