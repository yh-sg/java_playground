package multihreadingRevision;

//Either extends Thread or implement Runnable
public class MultihreadThing extends Thread {
	
	private int threadNumber;
	
	public MultihreadThing() {}
	
	public MultihreadThing(int threadNumber) {
		this.threadNumber=threadNumber;
	}
	
	@Override
	public void run() {
		for(int i = 0; i <=5; i++) {
			System.out.println(i + " from thread " + threadNumber);
			
			if (threadNumber==3)
				throw new RuntimeException("cannot be 3");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
