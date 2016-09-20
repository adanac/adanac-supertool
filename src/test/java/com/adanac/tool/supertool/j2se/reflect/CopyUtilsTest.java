package com.adanac.tool.supertool.j2se.reflect;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.adanac.tool.supertool.entity.Skill;
import com.adanac.tool.supertool.entity.User;
import com.adanac.tool.supertool.entity.UserDto;
import com.adanac.tool.supertool.j2se.reflect.CopyUtils;

public class CopyUtilsTest {

	/********* 在相同的对象间拷贝 *******************/

	@Test
	public void test_copy1() throws Exception {
		User u = new User();
		u.setAge(1);
		u.setId(101);
		u.setName("allen");
		u.setPassword("pwd1");

		User u2 = new User();
		BeanUtils.copyProperties(u2, u);
		System.out.println(u2.toString());
	}

	@Test
	public void test_copy2() throws Exception {
		User u = new User();
		u.setAge(1);
		u.setId(101);
		u.setName("allen");
		u.setPassword("pwd1");
		Skill s1 = new Skill();
		s1.setSid("s101");
		s1.setSname("吃饭");
		s1.setSlevel(2);
		u.setSkill(s1);
		User u2 = new User();
		CopyUtils.copyProperties(u2, u);
		System.out.println(u2.getSkill().toString());
	}

	/*********** 在不同的对象间拷贝 ******************************/

	@Test
	public void test_copy3() throws Exception {
		User u = new User();
		u.setAge(1);
		u.setId(101);
		u.setName("allen");
		u.setPassword("pwd1");

		UserDto user = new UserDto();
		CopyUtils.copyProperties(user, u);
		System.out.println(user.toString());
	}

	@Test
	public void test_copy4() throws Exception {
		User u = new User();
		u.setAge(1);
		u.setId(101);
		u.setName("allen");
		u.setPassword("pwd1");

		Skill s1 = new Skill();
		s1.setSid("s101");
		s1.setSname("吃饭");
		s1.setSlevel(2);
		u.setSkill(s1);

		UserDto user = new UserDto();
		CopyUtils.copyProperties(user, u);
		user.setSex(8);
		System.out.println(user.toString());
	}

}
