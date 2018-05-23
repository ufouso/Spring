package com.xpp.testOne;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TestMessage {
	
	public static void main(String[] args) {
		//以下为创建本地化实例
		//1.通过语言和地区定义
		Locale locale1 = new Locale("zh","CN");
		
		//2.通过语言定义泛型的
		Locale locale2 = new Locale("zh");
		
		//3.通过引用常量，相当于new Locale("zh", "CN")
		Locale locale3 = Locale.CHINA;
		
		//4.通过引用常量返回本地化对象，相当于new Locale("zh")
		Locale locale4 = Locale.CHINESE;
		
		//5.获取系统默认的本地化对象
		Locale locale5 = Locale.getDefault();
		
		//格式化操作工具类
		//1.对金额进行语言格式化
		Locale locale = new Locale("zh", "CN");
		NumberFormat currmt = NumberFormat.getCurrencyInstance(locale);
		double d = 6.28;
		System.out.println(currmt.format(d));
		
		//2.对时间日期进行语言格式化
		Locale localeEN = new Locale("en");
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, localeEN);
		System.out.println(df.format(new Date()));
		
		//3.信息格式化
		String pattern1 = "{0},你好！，你于{1}在工商银行存入{2}元";
		String pattern2 = "At {1,time,short} on {1,date,long}, {0} paid {2,number,currency}";
		//3.1.用于动态替换占位符的参数
		Object[] params = {"John", new GregorianCalendar().getTime(), "1.0E3"};
//		//3.2 使用默认本地化对象格式化信息
//		String l1 = MessageFormat.format(pattern1, params);
//		System.out.println(l1);
		//3.3 使用指定的本地对象化信息
		//出现的错误Cannot format given Object as a Number，
//		导致的原因是：new MessageFormat的第二个参数不能是对象
		MessageFormat mf = new MessageFormat(pattern2, new Locale("en","US"));
		String l2 = mf.format(params);
		System.out.println(l2);
		
	}	
}
