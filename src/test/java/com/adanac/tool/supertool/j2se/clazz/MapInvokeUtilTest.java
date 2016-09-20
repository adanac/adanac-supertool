package com.adanac.tool.supertool.j2se.clazz;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapInvokeUtilTest {

	@Test
	public void testInvoke() {
		Map<String, String> res = new HashMap<String, String>();
		res.put("1", "func1");
		res.put("2", "func2");
		res.put("3", "func3");
		InvokeUtil mUtil = new InvokeUtil();
		for (int i = 1; i < 4; i++) {
			String method = res.get(i + "");
			String param = "abc" + i;
			try {
				InvokeUtil.invoke(mUtil, method, param);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
