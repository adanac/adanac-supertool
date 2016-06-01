package com.adanac.tool.supertool.j2se.io;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	public static void main(String[] args) throws IOException {
		FileReader fr = null;
		try {
			// 创建字符输入流
			fr = new FileReader("src/main/java/com/adanac/tool/supertool/j2se/io/FileReaderTest.java");
			// 创建一个长度为32的"竹筒"
			char[] cbuf = new char[32];
			// 用于保存实际读取的字符数
			int hasRead = 0;
			// 使用循环来重复“取水”的过程
			while ((hasRead = fr.read(cbuf)) > 0) {
				// 取出"竹筒"中(字节),将字节数组转成字符串输入
				System.out.println(new String(cbuf, 0, hasRead));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			// 关闭文件输入流
			if (fr != null) {
				fr.close();
			}
		}
	}
}