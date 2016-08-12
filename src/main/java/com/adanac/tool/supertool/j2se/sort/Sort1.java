package com.adanac.tool.supertool.j2se.sort;

import java.util.Random;

/**
 * 桶排序
 */
public class Sort1 {

	public static void main(String[] args) {
		int[] res = initData(100, 100);
		String ss = sortData(res, false);
		System.out.println(ss);
	}

	/**
	 * 从小到大排序
	 * @param res
	 * @param sort 是否升序
	 * @return
	 */
	private static String sortData(int[] res, boolean sort) {
		StringBuilder sb = new StringBuilder();
		if (sort) {
			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < res[i]; j++) {
					sb.append(i + ",");
				}
			}
		} else {
			for (int i = res.length - 1; i > 0; i--) {
				for (int j = 0; j < res[i]; j++) {
					sb.append(i + ",");
				}
			}
		}
		String data = sb.substring(0, sb.lastIndexOf(","));
		return data;
	}

	/**
	 * 
	 * @param n 有几个数
	 * @param bounder 最大值
	 * @return
	 */
	private static int[] initData(int n, int bounder) {
		int res[] = new int[bounder];
		for (int i = 0; i < n; i++) {
			int num = Math.abs(new Random().nextInt(bounder));
			res[num]++;
		}
		return res;
	}
}