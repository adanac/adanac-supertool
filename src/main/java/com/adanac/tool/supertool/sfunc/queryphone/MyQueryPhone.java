package com.adanac.tool.supertool.sfunc.queryphone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 自动在 discuz 7.2 的论坛上发帖子 Created by allen
 */
public class MyQueryPhone {

	private static URL url;
	private static HttpURLConnection con;
	private static String temp;
	private static BufferedReader is;
	private static byte[] b;
	private static int pos;
	private static String cookie_sid;
	private static String cookie_auth;
	private static String my_cookie;
	private static String login_hash;
	private static String form_hash;
	private static String post_formhash;
	private static String user = "byedis";// 用户名
	private static String pass = "hi,byedis123";// 密码
	private static String new_fid = "142";// 版块 ID
	private static String subject = "新主题";// 标题
	private static String msg = "这里是新主题的内容";// 帖子内容

	public static void main(String[] args) {
		try {
			// 获取 cookie_sid 和 login_formhash --------------------
			url = new URL("http://www.1234i.com/p.php?haomas=13813418912%0D%0A15683219912");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Maxthon;)");
			// con.setRequestProperty("Accept-Encoding", "gzip");
			con.setRequestProperty("referer", "http://www.1234i.com");
			// Accept-Language:zh-CN,zh;q=0.8,en;q=0.6
			// con.setRequestProperty("Accept-Language",
			// "zh-CN,zh;q=0.8,en;q=0.6");
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {

				// is = con.getInputStream();
				// 定义BufferedReader输入流来读取URL响应
				is = new BufferedReader(new InputStreamReader(con.getInputStream(), "gbk"));
				// b = new byte[is.read()];
				// is.read(b);
				// // 服务器会返回一个页面，此页面中包含 loginhash
				// temp = new String(b);
				String valueString = null;
				while ((valueString = is.readLine()) != null) {
					System.out.println(valueString);
				}

				System.out.println("------------------------------------------------------------response end");
				is.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
