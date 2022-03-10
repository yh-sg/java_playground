package multihreadingRevision;

class SimplePlus1Counter
{
	int count;
	
//	//This won't work as the count that both thread are taking might not be sync to the actual count
//	public void increment() {
//		count++;
//	}
	
	//Synchronized keyword is to tell that whenever a thread is working, other threads should not interfere with it.
	public synchronized void increment() {
		count++;
	}
	
}

public class SyncronizeDemo {
	public static void main(String[] args) throws InterruptedException{
		SimplePlus1Counter c = new SimplePlus1Counter();
		
		Runnable r1 = () -> {
			for(int i=0;i<100; i++) {
				c.increment();
			}
		};
		
		Runnable r2 = () -> {
			for(int i=0;i<100; i++) {
				c.increment();
			}
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(c.count);
	}
}
