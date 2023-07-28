package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TakutoShiotani implements Serializable{
	private int age;
	private int teaYear;
	private int teaMonth;

	public TakutoShiotani() {
		// TODO 自動生成されたコンストラクター・スタブ

		//年齢
		int bornyear = 1999;
		int thisyear = LocalDateTime.now().getYear();
		this.age = thisyear - bornyear;

		//茶道歴
		int startyear = 2021;
		int startmonth = 11;
		LocalDateTime ldt = LocalDateTime.now();
		int year = ldt.getYear() - startyear;
		int month = ldt.getMonthValue() - startmonth;
		int monthly = year * 12 + month;

		this.teaYear = monthly / 12;
		this.teaMonth = monthly % 12;

	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getTeaYear() {
		return this.teaYear;
	}
	
	public int getTeaMonth() {
		return this.teaMonth;
	}

}
