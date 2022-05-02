package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTest {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);

		printDate01(now);
		printDate02(now);
	}

	private static void printDate02(Date d) {
		// 년도(+1900)
		int year = d.getYear();

		// 월(0 ~ 11, +1)
		int month = d.getMonth();

		// 일(0 ~ 30, +1)
		int day = d.getDay();

		// 시
		int hours = d.getHours();

		// 분
		int minute = d.getMinutes();

		// 초
		int seconds = d.getSeconds();

		System.out.println(
				(year + 1900) 
				+ "-" + 
				(month + 1) + "-" + 
				(day<10 ? "0" : "") + day + " " + 
				hours + ":" + 
				minute + ":" + 
				seconds);
	}

	private static void printDate01(Date d) {
		// 2022-05-02 10:55:07
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(d);

		System.out.println(date);
	}
}
