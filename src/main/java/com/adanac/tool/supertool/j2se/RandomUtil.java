package com.adanac.tool.supertool.j2se;

public class RandomUtil {

	/**
	 * 四位随机数
	 * @return int
	 * @author 陈荣祥
	 */
	public static int random() {

		return (int) (Math.random() * 9000 + 1000);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(random());
		}
	}

}
