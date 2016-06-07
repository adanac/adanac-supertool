package com.adanac.tool.supertool.intf;

import java.util.Set;

import com.adanac.tool.supertool.entity.User;

public interface UserDao {
	User getUser(int id);

	Set<User> getAllUsers();

	User getUserByUserNameAndPassword(String name, String password);

	boolean insertUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(int id);
}
