package threading;

public class MainMultiThreading {

	public static void main(String[] args) throws InterruptedException {
		// Multithreading =		Process of executing multiple threads simultaneously
		//						Helps maximum utilization of CPU
		//						Threads are independent, they don't affect the execution of other threads
		//						An exception in one thread will not interrupt other threads
		//						useful for serving multiple clients, multi-player games, or other mutually independent tasks
		
		OurThread thread1 = new OurThread(); //1st Way to create thread, sub-class of thread class
		
		//This is a more common way, since it could extends to another class while the first method cannot.
		OurRunnable runnable1 = new OurRunnable(); //2nd Way to create thread, create with runnable interface. Take this instance
		Thread thread2 = new Thread(runnable1); // Pass it to the constructor of the thread class.
		
		thread1.start();
		
		//This method will wait until thread 1 dies, thread 2 starts
		//thread1.join(); 
		
		//Daemon thread===Background thread
		thread2.setDaemon(true); //It will kill it once all the user threads are done. we won't be able to see thread2 done =(
		
		thread1.join(3000); //calling thread (ex.main) wait until the specified thread dies or for 3000 milliseconds
		
		thread2.start();
		
		//Proof that threads run independently.
		System.out.println(10/0);  
	}
}
