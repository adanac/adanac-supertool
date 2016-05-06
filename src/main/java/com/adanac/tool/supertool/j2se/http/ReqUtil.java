package com.adanac.tool.supertool.j2se.http;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class ReqUtil {

	/**
	 * ip地址
	 */
	public static String ipAddr(HttpServletRequest request){
		String ipAddress = null;
	    ipAddress = request.getHeader("x-forwarded-for");
	    if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
	    	ipAddress = request.getHeader("Proxy-Client-IP");
	    }
	    if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
	        ipAddress = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
	        ipAddress = request.getRemoteAddr();
	    if(ipAddress.equals("127.0.0.1")){
		    //根据网卡取本机配置的IP
		    InetAddress inet=null;
		    try {
		    	inet = InetAddress.getLocalHost();
		    } catch (UnknownHostException e) {
		    	e.printStackTrace();
		    }
		    	ipAddress= inet.getHostAddress();
		    }   
	    }
	    //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
	    if(ipAddress!=null && ipAddress.length()>15){
	        if(ipAddress.indexOf(",")>0){
	            ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
	        }
	    }
	     return ipAddress; 
	}
	
	 /**
	  * 将短时间格式字符串转换为时间yyyy-MM-dd HH:mm:ss
	  * 
	  * @param strDate
	  * @return
	 * @throws ParseException 
	  */
	 public static String getDate(String strDate) throws ParseException {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	  Date strtodate = formatter.parse(strDate);
	  formatter = new SimpleDateFormat("yyyy-MM-dd"); 
	  String str = formatter.format(strtodate);
	  return str;
	 }

}
