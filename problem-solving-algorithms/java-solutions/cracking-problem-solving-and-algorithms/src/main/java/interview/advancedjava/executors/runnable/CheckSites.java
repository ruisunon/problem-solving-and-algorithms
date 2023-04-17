package interview.advancedjava.executors.runnable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* There are some cases in which performing tasks in parallel can be useful. This option is especially attractive when: 
 * the tasks are independent of each other, but do essentially the same thing 
 * the tasks are limited by slow operations - typically, network access or disk access 
 * A good example of this comes from web site administration. 
 * Administrators need to monitor a set of N web sites, so they might send a 'ping' of some sort to each site,
 * to see if a healthy response is returned in each case. Note that these pings fit the above criteria 
 * - each ping is independent of the others, and yet is essentially the same task. 
 * Below is an example implementation of this idea. For purposes of comparison, 
 * this example actually has 3 different implementations: 
 * execute tasks in parallel, and report the result of each task as soon as it completes. 
 * execute tasks in parallel, but report the results of all tasks only at the end, after they have all completed. 
 * execute tasks serially, one after the other, and all within a single thread; report each task as it completes. 
 *
 * Ping N web sites in parallel. The ping simply does a GET, and looks at the
 * first header line. This example could be applied to many sorts of similar
 * tasks.
 * <P>
 * No time-out is used here. As usual, be wary of warm-up of the just-in-time
 * compiler. You might want to use -Xint.
 */
public class CheckSites {

	/** Run this tool. */
	public static final void main(String... args) {
		CheckSites checker = new CheckSites();
		try {
			log("Parallel, report each as it completes:");
			checker.pingAndReportEachWhenKnown();

			log("Parallel, report all at end:");
			checker.pingAndReportAllAtEnd();

			log("Sequential, report each as it completes:");
			checker.pingAndReportSequentially();
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		} catch (ExecutionException ex) {
			log("Problem executing worker: " + ex.getCause());
		} catch (MalformedURLException ex) {
			log("Bad URL: " + ex.getCause());
		}
		log("Done.");
	}

	/**
	 * Check N sites, in parallel, using up to 4 threads. Report the result of each
	 * 'ping' as it comes in. (This is likely the style most would prefer.)
	 */
	void pingAndReportEachWhenKnown() throws InterruptedException, ExecutionException {
		int numThreads = URLs.size() > 4 ? 4 : URLs.size(); // max 4 threads
		ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		CompletionService<PingResult> compService = new ExecutorCompletionService<>(executor);
		for (String url : URLs) {
			Task task = new Task(url);
			compService.submit(task);
		}
		for (String url : URLs) {
			Future<PingResult> future = compService.take();
			log(future.get());
		}
		executor.shutdown(); // always reclaim resources
	}

	/**
	 * Check N sites, in parallel, using up to 4 threads. Report the results only
	 * when all have completed.
	 */
	void pingAndReportAllAtEnd() throws InterruptedException, ExecutionException {
		Collection<Callable<PingResult>> tasks = new ArrayList<>();
		for (String url : URLs) {
			tasks.add(new Task(url));
		}
		int numThreads = URLs.size() > 4 ? 4 : URLs.size(); // max 4 threads
		ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		List<Future<PingResult>> results = executor.invokeAll(tasks);
		for (Future<PingResult> result : results) {
			PingResult pingResult = result.get();
			log(pingResult);
		}
		executor.shutdown(); // always reclaim resources
	}

	/**
	 * Check N sites, but sequentially, not in parallel. Does not use multiple
	 * threads at all.
	 */
	void pingAndReportSequentially() throws MalformedURLException {
		for (String url : URLs) {
			PingResult pingResult = pingAndReportStatus(url);
			log(pingResult);
		}
	}

	// PRIVATE

	private static final List<String> URLs = Arrays.asList("http://www.youtube.com/", "http://www.google.ca/",
			"http://www.date4j.net", "http://www.web4j.com");

	private static void log(Object msg) {
		System.out.println(Objects.toString(msg));
	}

	/** Try to ping a URL. Return true only if successful. */
	private final class Task implements Callable<PingResult> {
		Task(String url) {
			this.url = url;
		}

		/** Access a URL, and see if you get a healthy response. */
		@Override
		public PingResult call() throws Exception {
			return pingAndReportStatus(url);
		}

		private final String url;
	}

	private PingResult pingAndReportStatus(String URL) throws MalformedURLException {
		PingResult result = new PingResult();
		result.URL = URL;
		long start = System.currentTimeMillis();
		URL url = new URL(URL);
		try {
			URLConnection connection = url.openConnection();
			result.SUCCESS = true;
			long end = System.currentTimeMillis();
			result.TIMING = end - start;
		} catch (IOException ex) {
			// ignore - fails
		}
		return result;
	}

	/** Simple struct to hold all the data related to a ping. */
	private static final class PingResult {
		String URL;
		Boolean SUCCESS;
		Long TIMING;

		@Override
		public String toString() {
			return "Result:" + SUCCESS + " " + TIMING + " msecs " + URL;
		}
	}
}