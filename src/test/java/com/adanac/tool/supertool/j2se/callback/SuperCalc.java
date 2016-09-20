package com.adanac.tool.supertool.j2se.callback;

public class SuperCalc {
	public void add(int a, int b, DoJob customer) {
		int result = a + b;
		customer.fillBlank(a, b, result);
	}
}
