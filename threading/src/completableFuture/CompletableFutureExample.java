package completableFuture;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CompletableFutureExample {
	
	/* What is it used for?
	 * 
	 * Perform possible async computation and trigger dependent computations which could be also async
	 * 
	 * Having this kind of parallelism greatly improves the performance of your programs.
	 * 
	 * 1) CompletableFuture.runAsync() is useful for tasks that don’t return anything.
	 * 2) CompletableFuture.supplyAsync() is useful for tasks that return anything.
	 * 
	 * 
	 */
	
	// Create a thread pool and pass it to one of these methods
	Executor executor = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		
		SupplyAndRunAsync example1 = new SupplyAndRunAsync();
		SupplyAndRunAsyncWithCallback example2 = new SupplyAndRunAsyncWithCallback();
		
		example1.runAndSupplyAsync();
		example2.runAndSupplyAsyncCallback();
		
		
		
		MultipleCompletableFuture example3 = new MultipleCompletableFuture();
		example3.anyFuture();
		
	}



}
