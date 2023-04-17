package interview.advancedjava.executors.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureTesting {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFutureTesting cft = new CompletableFutureTesting();
		cft.allOfCompletes();

	}

	private void testCompletableFutureAllof() {

		List<String> langList = Arrays.asList("EN", "ES", "SN", "EX");
		List<CompletableFuture<GreetHolder>> completableFutures =
		        langList.stream().map(lang -> getGreeting(lang)).collect(Collectors.toList());
		// Using the List stream I can process getGreeting() tasks asynchronously
		// and get List<CompletableFuture<GreetHolder>>.
		CompletableFuture<Void> allFutures = CompletableFuture
		        .allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()]));
		
		//Returns a new CompletableFuture that is completed when all of the given CompletableFutures complete.
		CompletableFuture<List<GreetHolder>> allCompletableFuture = allFutures.thenApply(future -> {
		    return completableFutures.stream()
		            .map(completableFuture -> completableFuture.join())
		            .collect(Collectors.toList());
		});
		// Create a combined Future using allOf()
		CompletableFuture<Void> allFutures1 = CompletableFuture
		        .allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()]));
		// The problem with CompletableFuture.allOf() is that it returns
		// CompletableFuture<Void>.
		// But we can get the results of all the wrapped CompletableFutures by writing
		// few additional lines of code -
		// When all the Futures are completed, call `future.join()` to get their results
		// and collect the results in a list -
		CompletableFuture completableFuture = allCompletableFuture
				.thenApply(greets -> {
	                  return greets.stream().map(GreetHolder::getGreet).collect(Collectors.toList());
	         });
	}

	public List<GreetHolder> getToDos(List<String> ids) {

		List<CompletableFuture<GreetHolder>> futures = ids.stream().map(id -> getToDoAsync(id))
				.collect(Collectors.toList());

		List<GreetHolder> result = futures.stream().map(CompletableFuture::join).collect(Collectors.toList());

		return result;
	}

	public CompletableFuture<GreetHolder> getToDoAsync(String id) {
		// @Autowired
		// RestApiClient restApiClient;
		CompletableFuture<GreetHolder> future = CompletableFuture.supplyAsync(new Supplier<GreetHolder>() {
			@Override
			public GreetHolder get() {
				final GreetHolder toDo = new GreetHolder("hello"); // restApiClient.getToDo(id);

				return toDo;
			}
		});

		return future;
	}

	private CompletableFuture<GreetHolder> getGreeting(String lang) {
		List<String> animalList = Arrays.asList("EN", "ES", "SN", "EX");
		ExecutorService executor=Executors.newFixedThreadPool(Math.min(animalList.size(),10));
		return CompletableFuture.supplyAsync(() -> {
			try {
				///log.info("Task execution started.");
				Thread.sleep(2000);
				//log.info("Task execution stopped.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return new GreetHolder("(lang)");
		}, executor).exceptionally(ex -> {
			//log.error("Something went wrong : ", ex);
			return null;
		});
	}

	private CompletableFuture<String> downloadWebPage(String pageLink) {
		return CompletableFuture.supplyAsync(() -> {
			// Code to download and return the web page's content
			return "page";
		});
	}

	private void testCompletableFutureAnyof() throws InterruptedException, ExecutionException {
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

		System.out.println(anyOfFuture.get()); // Result of Future 2
	}

	// Handle exceptions using exceptionally() callback
	//
	// The exceptionally() callback gives you a chance to recover from errors
	// generated from the original Future. You can log the exception here and return
	// a default value.
	private void testExceptionCallback() throws InterruptedException, ExecutionException {
		Integer age = -1;

		CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
			if (age < 0) {
				throw new IllegalArgumentException("Age can not be negative");
			}
			if (age > 18) {
				return "Adult";
			} else {
				return "Child";
			}
		}).exceptionally(ex -> {
			System.out.println("Oops! We have an exception - " + ex.getMessage());
			return "Unknown!";
		});

		System.out.println("Maturity : " + maturityFuture.get());
	}

	/*
	 * Handle exceptions using the generic handle() method
	 * 
	 * The API also provides a more generic method - handle() to recover from
	 * exceptions. It is called whether or not an exception occurs
	 **/
	private void testHandle() throws InterruptedException, ExecutionException {
		Integer age = -1;

		CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
			if (age < 0) {
				throw new IllegalArgumentException("Age can not be negative");
			}
			if (age > 18) {
				return "Adult";
			} else {
				return "Child";
			}
		}).handle((res, ex) -> {
			if (ex != null) {
				System.out.println("Oops! We have an exception - " + ex.getMessage());
				return "Unknown!";
			}
			return res;
		});

		System.out.println("Maturity : " + maturityFuture.get());
	}

	public void allOfCompletes() throws ExecutionException, InterruptedException {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			// Simulate a long-running Job
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}

			return "Hello";
		});
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			// Simulate a long-running Job
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}

			return "Beautiful";
		});
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
			// Simulate a long-running Job
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}

			return "World";
		});
		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

		combinedFuture.get();
		// assertTrue(future3.isDone());
		String combined = Stream.of(future1, future2, future3).map(CompletableFuture::join)
				.collect(Collectors.joining(" "));
		System.out.println(combined);
		combined = Stream.of(future2, future3, future1).map(CompletableFuture::join).collect(Collectors.joining(" "));
		System.out.println(combined);
	}
}
