package com.adanac.tool.supertool.java2e.math;

public class DiGuiTest {

	public static int proc(int n) {
		int temp = 1;
		for (int i = 1; i <= n; i++) {
			temp = temp * i;
		}
		return temp;
	}

	public static int proRes(int n) {
		int res = 0;
		for (int i = 1; i <= n; i += 2) {
			res += proc(i);
		}
		return res;
	}

	public static Long proFinal(int n) {
		Long res = 0L;
		int tem = 1;
		for (int i = 1; i <= n; i++) {
			tem = tem * i;
			if (i % 2 == 1) {
				res += tem;
				System.out.println(tem);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(proFinal(15));
	}

}
