package concurrentCollections;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main extends Thread{
	
	static HashMap<Integer, String> hashmap = new HashMap<>(); 
    static ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<Integer,String>();
	
	@Override
    public void run()
    {
        // Child add new element in the object
        try
        {
            Thread.sleep(1000);
            hashmap.put(3,"Delta");
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
	
	/*
	 * HashMap is the Class which is under Traditional Collection and ConcurrentHashMap is a Class which is under Concurrent Collections 
	 * Apart from this there are various differences between them which are:
	 * 1) HashMap is non-Synchronized in nature i.e. HashMap is not Thread-safe whereas ConcurrentHashMap is Thread-safe in nature.
	 * 2) HashMap performance is relatively high because it is non-synchronized in nature and any number of threads can perform simultaneously. But ConcurrentHashMap performance is low sometimes because sometimes Threads are required to wait on ConcurrentHashMap.
	 * 3) While one thread is Iterating the HashMap object, if other thread try to add/modify the contents of Object then we will get Run-time exception saying ConcurrentModificationException.Whereas In ConcurrentHashMap we wont get any exception while performing any modification at the time of Iteration.
	 * 4) In HashMap, null values are allowed for key and values, whereas in ConcurrentHashMap null value is not allowed for key and value
	 * 
	 *  Synchronized Collections -> achieve thread-safety through intrinsic locking, and the entire collections are locked
	 *  Assure data consistency/integrity in multi-threaded environments. However, they might come with a penalty in performance, as only one single thread can access the collection at a time
	 *  
	 * 	Concurrent Collections -> achieve thread-safety by dividing their data into segments. Different threads can acquire locks on each segment, so multiple threads can access the Concurrent HashMap at the same time
	 * 	Much more performant than synchronized collections
	 * 
	 */

	public static void main(String[] args) throws InterruptedException {
		
		hashmap.put(0,"Alpha");
		hashmap.put(1,"Beta");
		hashmap.put(2,"Charile");
		Main hashmapthread = new Main();
		hashmapthread.start();
		
        for (Object el : hashmap.entrySet()) 
        {
            System.out.println(el);
            Thread.sleep(1000);
        }
        System.out.println(hashmap);
    }

}
