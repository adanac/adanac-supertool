package com.adanac.tool.supertool.j2se.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

import com.adanac.tool.supertool.j2se.io.PropertiesUtils;

import junit.framework.Assert;

public class PropertiesUtilsTest {

	@Test
	public void testReadProperties() throws Exception {
		String filePath = "conf/allenKey.properties";
		Properties readProperties = PropertiesUtils.readProperties(filePath);
		System.out.println(readProperties.getProperty("baiDU_apiKey"));
		Assert.assertNotNull(readProperties.getProperty("baiDU_apiKey"));
	}

	@Test
	public void testWriteProperties() throws FileNotFoundException, IOException {
		String filePath = "conf/allenKey.properties";
		String key = "allen_key";
		String value = "allen_value";
		String comment = "allen_comment";
		PropertiesUtils.writeProperties(key, value, comment, filePath);
		Properties readProperties = PropertiesUtils.readProperties(filePath);
		System.out.println(readProperties.getProperty("allen_key"));
	}

}
