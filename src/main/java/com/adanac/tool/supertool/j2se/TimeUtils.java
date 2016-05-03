package com.adanac.tool.supertool.j2se;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.adanac.tool.supertool.constant.Constants;

public class TimeUtils {

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.PATTREN_2);
		String currDate = sdf.format(new Date().getTime());
		return currDate;
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getCurrentTimestamp() {
		return new Timestamp(new Date().getTime()).toString();
	}

	/**
	 * 获取当前时间+1年
	 * 
	 * @return
	 */
	public static Timestamp getOneYearLaterTs() {
		Calendar currCalendar = Calendar.getInstance();
		currCalendar.set(Calendar.YEAR, currCalendar.get(Calendar.YEAR) + 1);
		return new Timestamp(currCalendar.getTimeInMillis());

	}

	/**
	 * 判断是否已过期
	 * 
	 * @param time
	 * @return
	 */
	public static boolean isExpire(String time) {
		// 需要比对失效时间，失效的话则返回空
		Date endDate = DateUtils.parse(time, Constants.PATTREN_2);
		Date now = new Date();
		// 该券已过期了
		if (endDate.before(now)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(isExpire("2016-10-24 22:12:15"));
		System.out.println(isExpire("2016-01-24 22:12:15"));
	}

}
