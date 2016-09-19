package com.adanac.tool.supertool.java2e.random;

import org.junit.Test;

import com.adanac.tool.supertool.j2se.random.RandomUtil;

public class RandomUtilTest {

	@Test
	public void testRandom() {
		for (int i = 0; i < 10; i++) {
			System.out.println(RandomUtil.random());
		}
	}

}
