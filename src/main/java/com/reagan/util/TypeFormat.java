package com.reagan.util;

import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import org.springframework.stereotype.Component;


/**
 * <p>Description:类型转换 </p>
 * @date 2013年9月5日
 * @author reagan
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Component("typeFormat")
public class TypeFormat {
	
	private static final char[] r = new char[] { 'Q', 'w', 'E', '8', 'a', 'S',
		'2', 'd', 'Z', 'x', '9', 'c', '7', 'p', 'O', '5', 'i', 'K', '3',
		'm', 'j', 'U', 'f', 'r', '4', 'V', 'y', 'L', 't', 'N', '6', 'b',
		'g', 'H' };

	private static final char[] b = new char[] { 'q', 'W', 'e', 'A', 's', 'D',
		'z', 'X', 'C', 'P', 'o', 'I', 'k', 'M', 'J', 'u', 'F', 'R', 'v',
		'Y', 'T', 'n', 'B', 'G', 'h' };

	private static final int l = 34;

	private static final int s = 6;
	
	/**
	 * 方法用途: ISO转换UTF-8<br>
	 * 实现步骤: <br>
	 * @param str 转换字符串
	 * @return 转换后的值
	 * @throws Exception
	 */
	public static String iosToUtf(String str) throws Exception {
		if (str != null && str.length() > 0) {
			return new String(str.getBytes("ISO-8859-1"),
					Charset.forName("UTF-8"));
		} else {
			return null;
		}
	}

	/**
	 * 方法用途:  返回日期<br>
	 * 实现步骤: <br>
	 * @return 日期对象
	 */
	public static Date getTime() {
		Calendar calendar = Calendar.getInstance(TimeZone
				.getTimeZone("GMT+08:00"));
		Date date = calendar.getTime();
		return date;
	}

	/**
	 * 方法用途: 日期格式化<br>
	 * 实现步骤: yyyy-MM-dd HH:mm:ss<br>
	 * @param date 需要格式化的日期
	 * @return 格式化好的日期
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 方法用途: 日期格式化<br>
	 * 实现步骤: yyyy 年  M 月 d 日 HH 点 mm 分 ss 秒<br>
	 * @param date 需要格式化的日期
	 * @return 格式化好的日期
	 */
	public static String formatCNDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy 年  M 月 d 日 HH 点 mm 分 ss 秒");
		return sdf.format(date);
	}
	
	/**
	 * 方法用途: 日期格式化<br>
	 * 实现步骤: yyyy 年  M 月 d 日<br>
	 * @param date 需要格式化的日期
	 * @return 格式化好的日期
	 */
	public static String formatCNSimple(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy 年  M 月 d 日");
		return sdf.format(date);
	}

	/**
	 * 方法用途: 日期格式化<br>
	 * 实现步骤: yyyy-MM-dd<br>
	 * @param date 需要格式化的日期
	 * @return 格式化好的日期
	 */
	public static String fromatSimple(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	/**
	 * 方法用途: 日期格式化<br>
	 * 实现步骤: yyyyMM<br>
	 * @param date 需要格式化的日期
	 * @return 格式化好的日期
	 */
	public static String fromatMother(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		return sdf.format(date);
	}
	
	/**
	 * 方法用途: 日期格式化<br>
	 * 实现步骤: HH:mm:ss<br>
	 * @param date 需要格式化的日期
	 * @return 格式化好的日期
	 */
	public static String formatTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 方法用途: 日期格式化<br>
	 * 实现步骤: HH 点 mm 分 ss 秒<br>
	 * @param date 需要格式化的日期
	 * @return 格式化好的日期
	 */
	public static String formatCNTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH 点 mm 分 ss 秒");
		return sdf.format(date);
	}

	/**
	 * 方法用途: 订单SN<br>
	 * 实现步骤: 订单的SN号生成<br>
	 * @param supplierId
	 * @return 格式化好的日期
	 */
	public static String getOrderSn(long supplierId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		String a = String.valueOf(System.currentTimeMillis()).substring(9);
		if (a.length() < 4)
			a = a + "0";
		return supplierId + sdf.format(new Date()) + a;
	}


	/**
	 * 方法用途: 日期格式化<br>
	 * 实现步骤: yyyy-MM-dd<br>
	 * @param time 需要格式化的日期
	 * @return 格式化好的日期对象
	 */
	public static Date formatString(String time) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	/**
	 * 方法用途: 日期格式化<br>
	 * 实现步骤: yyyy-MM-dd HH:mm:ss<br>
	 * @param time 需要格式化的日期
	 * @return 格式化好的日期对象
	 */
	public static Date formatStringFull(String time) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.parse(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	/**
	 * 方法用途: 返回天<br>
	 * 实现步骤: <br>
	 * @return 返回天的日期对象
	 */
	public static Date getToday() {
		Calendar now = Calendar.getInstance();
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);
		// now.add(Calendar.DAY_OF_MONTH, 1);
		return now.getTime();
	}

	/**
	 * 方法用途: 返回天<br>
	 * 实现步骤: <br>
	 * @return 返回明天的日期对象
	 */
	public static Date getDateAft(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		// now.set(Calendar.HOUR_OF_DAY, 24);
		return now.getTime();
	}

	/**
	 * 方法用途: 返回天<br>
	 * 实现步骤: <br>
	 * @return 返回昨天的日期对象
	 */
	public static Date getDateBefore(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		// now.set(Calendar.HOUR_OF_DAY, 24);
		return now.getTime();
	}

	/**
	 * 方法用途: 字符串转换INT<br>
	 * 实现步骤: <br>
	 * @return int对象
	 */
	public static int toInt(String str, int defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}

	public static String toSerialNumber(long num) {
		char[] buf = new char[32];
		int charPos = 32;
		while ((num / l) > 0) {
			buf[--charPos] = r[(int) (num % l)];
			num /= l;
		}
		buf[--charPos] = r[(int) (num % l)];
		String str = new String(buf, charPos, (32 - charPos));
		if (str.length() < s) {
			StringBuffer sb = new StringBuffer();
			Random rnd = new Random();
			for (int i = 0; i < s - str.length(); i++) {
				sb.append(b[rnd.nextInt(24)]);
			}
			str += sb.toString();
		}
		return str;
	}
	
	public static String formatMoney(double money) {
		DecimalFormat dFormat = new DecimalFormat("#,##0.00");
		return dFormat.format(money);
	}
	
	public static String formatDouble(double value) {
		DecimalFormat dFormat = new DecimalFormat("##.00");
		return dFormat.format(value);
	}
	
	
	public static Date  getAddTime() {
        Calendar cal = Calendar. getInstance ();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, 1);
        return  cal.getTime();
    }

}
