package threading;

public class OurThread extends Thread{
	@Override
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println("Thread #1: "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//Exception will not stop the other thread.
			//System.out.println(10/0);  
		}
		System.out.println("Thread #1 is finished!^^");
	}
}
