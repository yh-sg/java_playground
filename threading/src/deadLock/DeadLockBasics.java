package deadLock;

public class DeadLockBasics {
	/* What is a DeadLock?
	 * 
	 * Firstly, a lock occurs when multiple processes tries to access the same resource at the same time.
	 * 
	 * A deadlock is occurs when those are waiting process and hold on to a resource until another thread needs to finish it. (One process smust wait for other to finish)
	 * 
	 * Solution: avoid processes cross over and need to lock as much as possible...take the locks in the same order.
	 * Detect at runtime using thread dumps
	 * Consistent ordering of lock acquisition helps avoid deadlock
	 * Timeouts for lock acquisition can also help
	 * 
	 * In layman's term...imagine there are two lovers who loved each other dearly....
	 * However, one day they had their lovers spat with one another   
	 * Both sides are heart-broken and waiting for an I-am_sorry-and-I-missed-you-dearly call
	 * They want to communicate each other only if one of them receives the I-am-sorry call.
	 * But neither sides are willing to start communication...
	 * This situation causes a deadlock situation as both side are waiting in passive state.
	 * 
	 * Parallelism --> Threads/ThreadPool (Doing lot of independent things at once)
	 * Concurrency --> Locks/Synchronized/Concurrent Collections/ CompletableFuture (Dealing with lot of dependent things at once, shared resource is to be accessed/update)
	 * 
	 */
	
	// Simple deadlock example 
	
	   public static Object Lock1 = new Object();
	   public static Object Lock2 = new Object();
	   
	   public static void main(String args[]) {
		   
		 Thread T1 = new Thread(()->{
	         synchronized (Lock1) {
		            System.out.println("Thread 1: Holding lock 1...");
		            
		            try { 
		            	Thread.sleep(2000); 
		            }
		            catch (InterruptedException e) 
		            {}
		            System.out.println("Thread 1: Waiting for lock 2...");
		            
		            synchronized (Lock2) {
		               System.out.println("Thread 1: Holding lock 1 & 2...");
		            }
		            System.out.println("Thread 1: Ends");
		      }
		  });
	      
	      
	      Thread T2 = new Thread(()->{
			// synchronized (Lock2) {
			//	            System.out.println("Thread 2: Holding lock 2...");
				    	  	    	  
			//	 Solution for deadlock
		         synchronized (Lock1) {
			            System.out.println("Thread 2: Holding lock 1...");
		            
		            try { 
		            	Thread.sleep(2000); 
		            }
		            catch (InterruptedException e) {}
		            System.out.println("Thread 2: Waiting for lock 1...");
		            
//		            synchronized (Lock1) {
//		               System.out.println("Thread 2: Holding lock 1 & 2...");
//		            }
		            
		            synchronized (Lock2) {
			               System.out.println("Thread 2: Holding lock 1 & 2...");
			        }
		         }
	      });
	      
	      T1.start();
	      T2.start();
	      
	      try {
			T1.join();
			T2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	      System.out.println("Thread 1&2: Ends");
	   }
	   
}
