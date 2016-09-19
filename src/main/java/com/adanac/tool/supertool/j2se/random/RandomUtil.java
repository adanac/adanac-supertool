package com.adanac.tool.supertool.j2se.random;

public class RandomUtil {

	/**
	 * 四位随机数
	 * 
	 * @return int
	 */
	public static int random() {

		return (int) (Math.random() * 9000 + 1000);
	}

}
