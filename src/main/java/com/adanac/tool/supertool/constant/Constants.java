package com.adanac.tool.supertool.constant;

/**
 * 常量类
 */
public interface Constants {

	/**
	 * 默认每页展示条数
	 */
	int DEF_PAGESIZE = 1000;

	/**
	 * 默认显示页码
	 */
	int DEF_PAGENUMBER = 1;

	String PATTREN_1 = "yyMMddHHmmss";
	String PATTREN_2 = "yyyy-MM-dd";

	int PRE_ZERO_LEN = 6;

	String RULE_PRE = "r_";

	/**
	 * 商户编码前缀
	 */
	public static final String MERCHANT_CODE = "02";

	/**
	 * 商户编码后缀的长度
	 */
	public static final int MERCHANT_CODE_LENGTH = 4;

	/**
	 * 数字常量
	 * @return int
	 */
	public static class intNum {
		public static final int NUM = -1;

		public static final int NUM_0 = 0;

		public static final int NUM_1 = 1;

		public static final int NUM_2 = 2;

		public static final int NUM_3 = 3;

		public static final int NUM_4 = 4;

		public static final int NUM_5 = 5;
	}

	/**
	 * 返回字符类型数字常量
	 * @return string
	 */
	public static class strNum {

		public static final String STR_0 = "0";

		public static final String STR_1 = "1";

		public static final String STR_2 = "2";

		public static final String STR_3 = "3";

		public static final String STR_4 = "4";

		public static final String STR_5 = "5";

		public static final String STR_6 = "6";

		public static final String STR_7 = "7";

		public static final String STR_8 = "8";

		public static final String STR_9 = "9";

	}
}
