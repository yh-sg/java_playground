package threading;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	public static void main(String[] args) {
		//Timer = 	A facility for threads to schedule tasks
		//			for future execution in a background thread
		
		//TimerTask =	A task that can be scheduled for one-time
		//				or repeated execution by a timer.
		
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			
			int counter = 10;
			@Override
			public void run() {
				if(counter>0) {
					System.out.println(counter+" seconds");
					counter--;
				}else {
					System.out.println("Task is completed =)");
					timer.cancel();
				}
			}
		};
		
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 2021);
		date.set(Calendar.MONTH, Calendar.AUGUST);
		date.set(Calendar.DAY_OF_MONTH, 22);
		date.set(Calendar.HOUR_OF_DAY, 21);
		date.set(Calendar.MINUTE, 7);
		date.set(Calendar.SECOND, 0);
		
		//timer.schedule(task, 3000);
//		timer.schedule(task, date.getTime());
		timer.scheduleAtFixedRate(task, date.getTime(), 1000);
		
	}
}
