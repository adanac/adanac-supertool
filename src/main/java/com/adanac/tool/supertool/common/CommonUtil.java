package com.adanac.tool.supertool.common;

import java.io.IOException;
import java.util.Properties;

import com.adanac.tool.supertool.j2se.io.PropertiesUtils;

public class CommonUtil {

	public static String getPropertyValue(String filePath, String key) {
		String property = "";
		try {
			Properties properties = PropertiesUtils.readProperties(filePath);
			property = properties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return property;
	}
}
