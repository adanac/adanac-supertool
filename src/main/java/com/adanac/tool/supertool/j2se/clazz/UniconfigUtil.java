package com.adanac.tool.supertool.j2se.clazz;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UniconfigUtil {
	public static Properties getpro() {

		String configValue = "abc";

		Properties properties = new Properties();
		InputStream in = new ByteArrayInputStream(configValue.getBytes());
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// properties.load(configValue);
		return properties;
	}
}
