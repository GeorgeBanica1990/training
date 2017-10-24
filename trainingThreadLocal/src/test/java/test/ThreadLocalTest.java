package test;

import org.junit.Test;

import models.ThreadDemo;

public class ThreadLocalTest {

	@Test
	public void testTL() {
		Thread firstThread = new ThreadDemo();
		firstThread.start();
		Thread secondThread = new ThreadDemo();
		secondThread.start();
		
		
	}
}
