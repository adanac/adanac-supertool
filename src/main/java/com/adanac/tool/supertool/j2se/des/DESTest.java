package com.adanac.tool.supertool.j2se.des;

public class DESTest {
	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
		}
	}

	public static void test() throws Exception {
		String inputStr = "DES";
		// String key = DESCoder.initKey();
		String key = "PhxRxxUvdWI=";
		System.err.println("原文:\t" + inputStr);

		System.err.println("密钥:\t" + key);

		byte[] inputData = inputStr.getBytes();
		inputData = DESCoder.encrypt(inputData, key);

		System.err.println("加密后:\t" + DESCoder.encryptBASE64(inputData));

		byte[] outputData = DESCoder.decrypt(inputData, key);
		String outputStr = new String(outputData);

		System.err.println("解密后:\t" + outputStr);

		// assertEquals(inputStr, outputStr);
	}
}
