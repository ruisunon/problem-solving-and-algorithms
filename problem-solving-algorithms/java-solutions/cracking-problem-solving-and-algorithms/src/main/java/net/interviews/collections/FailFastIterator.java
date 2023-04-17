package net.interviews.collections;

import java.util.ArrayList;
import java.util.Iterator;
//https://javaconceptoftheday.com/collection-framework-class-hierarchy/
// All Collection types maintain an internal array of objects ( Object[] ) 
// to store the elements. Fail-Fast iterators directly fetch the elements from this array.
// They always consider that this internal array is not modified while iterating over //
//its elements. To know whether the collection is modified or not, 
//they use an internal flag called modCount which is updated each time a collection is modified. 
//Every time when an Iterator calls the next() method, it checks the modCount. 
//If it finds the modCount has been updated after this Iterator has been created, it throws ConcurrentModificationException
import java.util.concurrent.ConcurrentHashMap;

public class FailFastIterator {

	public static void main(String[] args) {
		// Creating an ArrayList of integers

		ArrayList<Integer> list = new ArrayList<Integer>();

		// Adding elements to list

		list.add(1452);

		list.add(6854);

		list.add(8741);

		list.add(6542);

		list.add(3845);

		// Getting an Iterator from list

		Iterator<Integer> it = list.iterator();

		//while (it.hasNext()) {
			//Integer integer = (Integer) it.next();

		//	list.add(2222); // This will throw ConcurrentModificationException
		//}
		
		failSafeIteratorExample();

	}

	// Fail-Safe iterators don’t throw any exceptions if the collection is modified
	// while iterating over it. Because, they iterate on the clone of the collection
	// not on the actual collection. So, any structural modifications done on the
	// actual collection goes unnoticed by these iterators. But, these iterators
	// have some drawbacks. One of them is that it is not always guaranteed that you
	// will get up-to-date data while iterating. Because any modifications to
	// collection after the iterator has been created is not updated in the
	// iterator. One more disadvantage of these iterators is that there will be
	// additional overhead of creating the copy of the collection in terms of both
	// time and memory.
	static void failSafeIteratorExample ()
	{       
	        //Creating a ConcurrentHashMap
	         
	        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
	         
	        //Adding elements to map
	         
	        map.put("ONE", 1);
	         
	        map.put("TWO", 2);
	 
	        map.put("THREE", 3);
	         
	        map.put("FOUR", 4);
	         
	        //Getting an Iterator from map
	         
	        Iterator<String> it = map.keySet().iterator();
	         
	        int k=7;
	        while (it.hasNext() && k>1)
	        {
	        	k--;
	        	
	            String key = (String) it.next();
	             
	            System.out.println(key+" : "+map.get(key));
	             
	            map.put("FIVE", 5);  
	            //This will not be reflected in the Iterator
	            
	        }
	        System.out.println(map);
	    }
}
