package com.adanac.tool.supertool.j2se.random;

import org.junit.Test;

public class RandomUtilTest {

	@Test
	public void testRandom() {
		for (int i = 0; i < 10; i++) {
			System.out.println(RandomUtil.get4random());
		}
	}

}
