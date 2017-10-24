package models;

public class MyThreadLocal {

	private static final ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	
	public static void set(String value) {
		threadLocal.set(value);
	}
	
	public static void unset() {
		threadLocal.remove();
	}
	
	public static String get() {
		return threadLocal.get();
	}

}
