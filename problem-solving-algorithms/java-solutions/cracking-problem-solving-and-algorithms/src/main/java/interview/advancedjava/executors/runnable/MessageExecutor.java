package interview.advancedjava.executors.runnable;

import java.util.concurrent.Executor;

public class MessageExecutor implements Executor{

	private int taskCount;
	
	@Override
	public void execute(Runnable task) {
		taskCount++;
		System.out.println("Running task "+taskCount);
		new Thread(task).start();
	}

}