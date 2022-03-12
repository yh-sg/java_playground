package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class SupplyAndRunAsync {
	
	void runAndSupplyAsync(){
		try {
			//Running asynchronous computation using runAsync()
			//.get() blocks and get the result of the Future
			CompletableFuture.runAsync(() -> {
			    // Simulate a long-running Job   
			    try {
			        TimeUnit.SECONDS.sleep(5);
			    } catch (InterruptedException e) {
			        throw new IllegalStateException(e);
			    }
			    System.out.println("Result of the runAsync.");
			}).get();
			
			CompletableFuture<String> futureSupply = CompletableFuture.supplyAsync(() -> {
			    try {
			        TimeUnit.SECONDS.sleep(3);
			    } catch (InterruptedException e) {
			        throw new IllegalStateException(e);
			    }
			    return "Result of the supplyAsync";
			});
			
			System.out.println(futureSupply.get());
			
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	void runAndSupplyAsync(Executor executor){
		try {
			//Running asynchronous computation using runAsync()
			//.get() blocks and get the result of the Future
			CompletableFuture.runAsync(() -> {
			    // Simulate a long-running Job   
			    try {
			        TimeUnit.SECONDS.sleep(3);
			    } catch (InterruptedException e) {
			        throw new IllegalStateException(e);
			    }
			    System.out.println("I'll run in a separate thread than the main thread.");
			}, executor).get();
			
			CompletableFuture<String> futureSupply = CompletableFuture.supplyAsync(() -> {
			    try {
			        TimeUnit.SECONDS.sleep(1);
			    } catch (InterruptedException e) {
			        throw new IllegalStateException(e);
			    }
			    return "Result of the asynchronous computation";
			}, executor);
			
			System.out.println(futureSupply.get());
			
			// CompletableFuture.get() method is blocking.
			System.out.println("By right, I'll run first without any care...but due to get()....I cannot =(");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
