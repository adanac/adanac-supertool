package com.adanac.tool.supertool.java2e.string;

public class StringTest {
	public static void main(String[] args) {
		String title = "团伙拦路抢劫持械袭警被抓 称'打的就是警察'";
		title = title.replaceAll("\'", "\"");
		System.out.println(title);
	}
}
