package models;

public class ThreadDemo extends Thread {
	@Override
	public void run() {
		MyThreadLocal.set(getName());
		System.out.println("got into thread ");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(MyThreadLocal.get());
		
		MyThreadLocal.unset();
	}
}
