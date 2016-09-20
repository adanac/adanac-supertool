package com.adanac.tool.supertool.j2se.string;

public class StringTest {
	public static void main(String[] args) {
		String title = "团伙拦路抢劫持械袭警被抓 称'打的就是警察'";
		title = title.replaceAll("\'", "\"");
		System.out.println(title);
	}
}
