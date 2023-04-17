package algorithms.advanced.externalsorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class ExternalSort20GB {

	public static final String fPath = "/tmp/data-20gb.in";

	public static final String fdir = "/tmp/";
	public static final String shared = "/tmp/home/";
	public static final String opLog = shared + "Externalsort20GB.log";

	public static void main(String[] args) throws Exception {
		long startTime = System.nanoTime();
		int threadCount = 10; // Number of threads
		int totalLines = 200000000;
		int linesPerFile = totalLines / threadCount;
		ArrayList<Thread> activeThreads = new ArrayList<Thread>();

		for (int i = 1; i <= threadCount; i++) {
			int startLine = i == 1 ? i : (i - 1) * linesPerFile + 1;
			int endLine = i * linesPerFile;
			SplitFile mapThreads = new SplitFile(fdir + "op" + i, startLine, endLine);
			//activeThreads.add(mapThreads);
			//mapThreads.start();
		}
		activeThreads.stream().forEach(t -> {
			try {
				t.join();
			} catch (Exception e) {
			}
		});

		int treeHeight = (int) (Math.log(threadCount) / Math.log(2));

		for (int i = 0; i < treeHeight; i++) {
			ArrayList<Thread> actvThreads = new ArrayList<Thread>();

			for (int j = 1, itr = 1; j <= threadCount / (i + 1); j += 2, itr++) {
				int offset = i * 100;
				String tempFile1 = fdir + "op" + (j + offset);
				String tempFile2 = fdir + "op" + ((j + 1) + offset);
				String opFile = fdir + "op" + (itr + ((i + 1) * 100));

				MergeFiles reduceThreads = new MergeFiles(tempFile1, tempFile2, opFile);
				actvThreads.add(reduceThreads);
				reduceThreads.start();
			}
			actvThreads.stream().forEach(t -> {
				try {
					t.join();
				} catch (Exception e) {
				}
			});
		}
		long endTime = System.nanoTime();
		double timeTaken = (endTime - startTime) / 1e9;
		System.out.println(timeTaken);
		BufferedWriter logFile = new BufferedWriter(new FileWriter(opLog, true));
		logFile.write("Time Taken in seconds:" + timeTaken);
		Runtime.getRuntime().exec("valsort  " + fdir + "op" + (treeHeight * 100) + 1 + " > " + opLog);
		logFile.close();
	}

}
