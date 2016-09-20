package com.adanac.tool.supertool.j2se.reflect;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import com.adanac.tool.supertool.j2se.reflect.PathUtils;

public class PathUtilsTest {

	@Test
	public void testGetProjectDrivePath() {

	}

	@Test
	public void testGetDrive() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClassDrivePath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClassPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetJarPath() throws IOException, URISyntaxException {
		System.out.println(PathUtils.getJarPath());
	}

}
