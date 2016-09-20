package com.adanac.tool.supertool.j2se.clazz;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.adanac.tool.supertool.j2se.clazz.MapInvokeUtil;

public class MapInvokeUtilTest {

	@Test
	public void testInvoke() {
		Map<String, String> res = new HashMap<String, String>();
		res.put("1", "func1");
		res.put("2", "func2");
		res.put("3", "func3");
		MapInvokeUtil mUtil = new MapInvokeUtil();
		for (int i = 1; i < 4; i++) {
			String method = res.get(i + "");
			String param = "abc" + i;
			try {
				MapInvokeUtil.invoke(mUtil, method, param);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
