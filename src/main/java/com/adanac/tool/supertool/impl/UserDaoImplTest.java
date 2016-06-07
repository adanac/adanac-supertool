package com.adanac.tool.supertool.impl;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.adanac.tool.supertool.entity.User;

public class UserDaoImplTest {

	@Test
	public void testGetUser() {
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.getUser(1);
		Assert.assertNotNull(user);
	}

	@Test
	public void testGetAllUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertUser() {
		UserDaoImpl userDao = new UserDaoImpl();
		User user = new User("user1", "pwd1", 18);
		boolean flag = userDao.insertUser(user);
		Assert.assertEquals(true, flag);

	}

	@Test
	public void testUpdateUser() {
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.getUser(1);
		user.setAge(20);
		user.setName("user1up");
		user.setPassword("paswdup");
		boolean flag = userDao.updateUser(user);
		Assert.assertEquals(true, flag);
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserByUserNameAndPassword() {
		fail("Not yet implemented");
	}

}
