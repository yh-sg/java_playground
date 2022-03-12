package completableFuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultipleCompletableFuture {
	
	//Combining multiple CompletableFutures together
	
	void anyFuture() {
		
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(2);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return "Result of Future 1";
		});

		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return "Result of Future 2";
		});

		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(3);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return "Result of Future 3";
		});

		CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2, future3);

		try {
			System.out.println(anyOfFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} // Result of Future 2
		
	}
	
	void allFuture() {
		
		CompletableFuture<String> future1  = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future2  = CompletableFuture.supplyAsync(() -> "Beautiful");
		CompletableFuture<String> future3  = CompletableFuture.supplyAsync(() -> "World");

		String combinedFuture = Stream.of(future1, future2, future3)
				  .map(CompletableFuture::join) //Equivalent to ------> .map(e -> e.join())
				  .collect(Collectors.joining(" "));
		
		List<String> combinedFuture2 = Stream.of(future1, future2, future3)
				  .map(CompletableFuture::join)
				  .filter(e -> e != "Hello")
				  .collect(Collectors.toList());
		
		System.out.println(assertEquals("Hello Beautiful World", combinedFuture));
		System.out.println(combinedFuture2);
		
	}
	
	private boolean assertEquals(String string1, String string2) {
		return string1.equals(string2) ? true : false;
	}
	

}
