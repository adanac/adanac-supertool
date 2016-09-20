package com.adanac.tool.supertool.j2se.reflect;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.adanac.tool.supertool.thirdparty.excel.User;

public class ReflectUtilsTest {

	@Test
	public void testGetFieldModifier() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMethodModifier() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFieldValueObjectObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFieldValueClassOfTString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFieldsClassOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFieldsClassOfTBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClassFieldsAndSuperClassFields() {
		fail("Not yet implemented");
	}

	@Test
	public void testInvokeClassOfTString() {
		fail("Not yet implemented");
	}

	@Test
	public void testInvokeObjectString() {
		fail("Not yet implemented");
	}

	@Test
	public void testInvokeClassOfTStringClassOfTArrayObjectArray() {
		fail("Not yet implemented");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testInvokeObjectStringClassOfTArrayObjectArray() throws Exception {
		User u = new User();
		ReflectUtils.invoke(u, "setName", new Class[] { String.class }, new Object[] { "xx发大水法大水法x" });
		System.out.println(ReflectUtils.getFieldValue(u, "name"));
	}

}
