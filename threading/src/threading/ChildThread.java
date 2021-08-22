package threading;

public class ChildThread extends Thread {
	
	@Override
	public void run() {
		if(this.isDaemon()) {
			System.out.println("This deamon thread is running");
		}else {
			System.out.println("It's a user thread is running");
		}
	}
}
