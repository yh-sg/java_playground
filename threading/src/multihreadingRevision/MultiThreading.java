package multihreadingRevision;

public class MultiThreading {

	public static void main(String[] args) throws InterruptedException {

		MultihreadThing myThing = new MultihreadThing();
		MultihreadThing myThing2 = new MultihreadThing();
		
		//Multiple concurrent threads require start();
		myThing.start();
		myThing2.start();
		
		//Wait for them to complete, and they'll join together and execute the next step
		myThing.join();
		myThing2.join();
		
		System.out.println("byebye");
		
		
//		for(int i=0; i<=3; i++) {
//			MultihreadThing myThing3 = new MultihreadThing(i);
//			myThing3.start();
//			
//		}
		
		//this won't stop other threads running...
//		throw new RuntimeException();
		
		
	}

}
