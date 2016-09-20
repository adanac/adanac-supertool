package com.adanac.tool.supertool.j2se.callback;

public class Student {

	private String name;

	public Student(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	class doHomeWork implements DoJob {

		@Override
		public void fillBlank(int a, int b, int result) {
			System.out.println(name + "求助超级计算机：" + a + "+" + b + "=" + result);
		}

	}

	public void callHelp(int a, int b) {
		new SuperCalc().add(a, b, new doHomeWork());
	}
}
