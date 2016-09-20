package com.adanac.tool.supertool.j2se.bean;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.adanac.tool.supertool.entity.PersonDto;

public class BeanUtilTest {

	@Test
	public void testTransMap2Bean2() {
		PersonDto person = new PersonDto();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Mike");
		map.put("age", 25);
		BeanMapUtil.transMap2Bean2(map, person);
		System.out.println("--- transMap2Bean Map Info: ");
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		System.out.println("--- Bean Info: ");
		System.out.println("name: " + person.getName());
		System.out.println("age: " + person.getAge());
	}

	@Test
	public void testTransMap2Bean() {
		fail("Not yet implemented");
	}

	@Test
	public void testTransBean2Map() {
		PersonDto person = new PersonDto();
		person.setName("allen");
		person.setNum(11);
		person.setAge(12);
		person.setSex("男");
		Map<String, Object> map = BeanMapUtil.transBean2Map(person);

		System.out.println("--- transBean2Map Map Info: ");
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
