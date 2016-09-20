package com.adanac.tool.supertool.j2se.sort;

import org.junit.Test;

import com.adanac.tool.supertool.j2se.sort.BucketSort;

public class BucketSortTest {

	@Test
	public void testBucketSort() {
		int[] data = BucketSort.initData(100, 100);
		String res = BucketSort._bucket_sort(data, true);// true升序
		System.out.println(res);
	}

}
