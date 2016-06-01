package com.adanac.tool.supertool.entity;

public class Employee implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7716842838380856049L;
	public String name;
	public String address;
	public transient int SSN;
	public int number;

	public void mailCheck() {
		System.out.println("Mailing a check to " + name + " " + address);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", SSN=" + SSN + ", number=" + number + "]";
	}

}