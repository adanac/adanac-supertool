package com.adanac.tool.supertool.j2se.clazz;

import java.util.HashMap;
import java.util.Map;

/**
 * 解决 if-else比较多的情况
 * @author adanac
 */
public class MapInvokeUtil {

	public void func1(String s) {
		System.out.println("====func1====" + s);
	}

	public void func2(String s) {
		System.out.println("====func2====" + s);
	}

	public void func3(String s) {
		System.out.println("====func3====" + s);
	}

	public void test1() {
		Map<String, String> res = new HashMap<String, String>();
		res.put("1", "func1");
		res.put("2", "func2");
		res.put("3", "func3");
		MapInvokeUtil mUtil = new MapInvokeUtil();
		for (int i = 1; i < 4; i++) {
			String method = res.get(i + "");
			String param = "abc" + i;
			try {
				invoke(mUtil, method, param);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void invoke(Object o, String method, String param) throws Exception {
		o.getClass().getMethod(method, new Class[] { String.class }).invoke(o, new Object[] { param });
	}

	public static void main(String[] args) {
		MapInvokeUtil mapInvoke = new MapInvokeUtil();
		mapInvoke.test1();
	}

}
