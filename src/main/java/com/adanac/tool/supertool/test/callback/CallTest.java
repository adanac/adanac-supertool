package com.adanac.tool.supertool.test.callback;

public class CallTest {
	public static void main(String[] args) {
		Student s = new Student("allen");
		s.callHelp(5, 17);
		Seller seller = new Seller("seller");
		seller.callHelp(8, 39);
	}
}
