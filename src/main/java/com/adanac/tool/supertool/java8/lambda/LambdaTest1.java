package com.adanac.tool.supertool.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class LambdaTest1 {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		Collections.sort(names, (o1, o2) -> o1.compareTo(o2));

		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
	}

	@Test
	public void test1() {
		List<String> names = new ArrayList<>();
		names.add("TaoBao");
		names.add("ZhiFuBao");
		List<String> lowercaseNames = names.stream().map((String name) -> {
			return name.toLowerCase();
		}).collect(Collectors.toList());
		System.out.println(lowercaseNames);
	}
}
