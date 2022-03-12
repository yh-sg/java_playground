package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplyAndRunAsyncWithCallback {
	
	void runAndSupplyAsyncCallback(){
	//	1) thenApply() -> For returning things....
	//	2) thenAccept() -> For non-returning things....	
		try {
			String welcomeText = CompletableFuture.supplyAsync((Supplier<String>) () -> {
				   try {
				       TimeUnit.SECONDS.sleep(3);
				   } catch (InterruptedException e) {
				       throw new IllegalStateException(e);
				   }
				   return "Customer";
//		}).thenAccept(returnedString->System.out.println("Hello, "+returnedString+"!"));
			}).thenApply(returnedString-> "Hello, "+returnedString+"!").get();
			
			System.out.println(welcomeText);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}