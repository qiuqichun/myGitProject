package cn.boc.sh.spark.action;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		String format5 = String.format("%tF",new Date());
		System.out.println(format5);
		
		long time = new Date().getTime();
		System.out.println(time);
		System.out.println();
		Date date = new Date();
		System.out.println(date);
		System.out.println();
		String format = new SimpleDateFormat("YYYYMMdd").format(new Date().getTime());
		System.out.println(format);
		System.out.println();
		String format2 = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
		System.out.println(format2);
		System.out.println();
		String format3 = new SimpleDateFormat("hhmm").format(new Date());
		System.out.println(format3);
		System.out.println();
		String format4 = new SimpleDateFormat("yyyyMMdd").format(new Date());
		System.out.println(format4);
		long nanoTime = System.nanoTime();
		System.out.println(nanoTime);
		long nanoTime2 = System.nanoTime();
		System.out.println(nanoTime2);
		
	}

}
