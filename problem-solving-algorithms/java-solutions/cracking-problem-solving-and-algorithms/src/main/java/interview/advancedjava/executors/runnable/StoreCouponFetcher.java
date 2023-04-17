package interview.advancedjava.executors.runnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import interview.advancedjava.executors.NewTask;

public class StoreCouponFetcher {

	private int taskCounter;

	public static void main(String[] args) {
		StoreCouponFetcher scf = new StoreCouponFetcher();
		scf.processCoupons();
	}
	
	public void processCoupons() {
		
		//executor service
		ExecutorService executor = Executors.newCachedThreadPool();
		
		//completion service
		ExecutorCompletionService<NewTask> completionService =
				new ExecutorCompletionService<NewTask>(executor);
		
		//task producer
		new Thread(new CouponTaskProducer(
				completionService, this.getStores())).start();
		
		//task result consumer
		do {
			try {
				Future<NewTask> future = completionService.take();
				NewTask taskResult = future.get();
				System.out.println(taskResult.getTaskOwner()+" " +taskResult.getResult());
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			taskCounter--;
		}while(taskCounter > 0);

		executor.shutdown();
	}
	
	public List<String> getStores() {
		List<String> lst = new ArrayList<>();
		lst.add("amazon");
		lst.add("bestbuy");
		lst.add("ebay");
		lst.add("macys");
		lst.add("jcpenny");
		
		taskCounter = lst.size();
		
		return lst;
	}
	
	static class CouponCallable implements Callable<NewTask>{
		
		private String store;
		
		public CouponCallable(String store) {
			this.store = store;
		}

		@Override
		public NewTask call() throws Exception {
			NewTask tr = new NewTask();
			tr.setTaskOwner(store);
			
			//get offer from remote service
			int dicount = (int )(Math.random() * 90);
			
			tr.setResult("get flat "+dicount+ "% off");
			
			return tr;
		}
		
	}
	
	static class CouponTaskProducer implements Runnable{
		
		private ExecutorCompletionService<NewTask> completionService;
		private List<String> stores;
		
		public CouponTaskProducer(ExecutorCompletionService<NewTask> ecs, 
				List<String> stores) {
			
			completionService = ecs;
			this.stores = stores;
		}
		@Override
		public void run() {
			
			for(String store : stores) {
				CouponCallable callable = new CouponCallable(store);
				completionService.submit(callable);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {}
			}				
		}
	}
}