package com.gem.xmgc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * 自定义日期工具类
 */
public class DateUtil {

	/**
	 * 根据指定年月日,创建日期对象
	 */
	public static Date createDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		return calendar.getTime();
	}

	/**
	 * 格式化日期
	 */
	public static String formatDate(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	public static String formatDate(Date date, String pattern) {
		/*SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String time = sdf.format(date);
		return time;*/
		return new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 解析日期
	 */
	public static Date parseDate(String time) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date parseDate(String time, String pattern) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
