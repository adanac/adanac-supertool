package com.adanac.tool.supertool.java2e.serialization;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.adanac.tool.supertool.entity.UserDto;
import com.adanac.tool.supertool.j2se.serialization.SerializeUtil;

public class SerializeUtilTest {

	@Test
	public void testSerialize() {
		UserDto user = new UserDto();
		user.setId(101);
		user.setName("allen");
		user.setPassword("pwd123");
		user.setSex(1);
		byte[] _user_byte = SerializeUtil.serialize(user);
		System.out.println(_user_byte);
		UserDto _user_obj = (UserDto) SerializeUtil.unserialize(_user_byte);
		System.out.println(_user_obj.toString());
	}

	@Test
	public void testUnserialize() {
		fail("Not yet implemented");
	}

}
