package threads;

public class MyRunnable implements Runnable {
	public void run(){
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + "is running ...");
		go();
	}

	public void go(){
		try {
			Thread.sleep(100);
		} catch(InterruptedException ex){
			ex.printStackTrace();
		}
		doMore();
	}

	public void doMore(){
		System.out.println("in run() stack");
	}
}
