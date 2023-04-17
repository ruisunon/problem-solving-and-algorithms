package interview.advancedjava.executors;

public class NewTask implements Runnable {

	private String taskOwner;
	private String result;
	
    public String getTaskOwner() {
		return taskOwner;
	}

	public void setTaskOwner(String taskOwner) {
		this.taskOwner = taskOwner;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
    public void run() {
    	  System.out.println(Thread.currentThread().getName());
    }   
    
}