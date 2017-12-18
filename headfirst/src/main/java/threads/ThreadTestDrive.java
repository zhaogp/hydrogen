package threads;

import java.io.*;

public class ThreadTestDrive{
	public static void main(String[] args){
		Runnable job = new MyRunnable();
		Thread thread = new Thread(job);
		thread.setName("default-thread");
		Thread thread2 = new Thread(job);
		thread2.setName("two-thread");
		thread.start();
		thread2.start();
		try {
			Thread.sleep(110);
		} catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.println("main() stack");
	}
}
