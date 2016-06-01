package com.adanac.tool.supertool.entity;

/**
 * Create a thread to implement Runnable
 * @author adanac
 */
public class DisplayMessage implements Runnable {
	private String message;

	public DisplayMessage(String message) {
		this.message = message;
	}

	public void run() {
		while (true) {
			System.out.println(message);
		}
	}
}