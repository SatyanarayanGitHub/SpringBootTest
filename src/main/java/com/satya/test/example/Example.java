package com.satya.test.example;

import java.util.Date;

public class Example {

	public static void main(String[] args) {

		Example ex = new Example();

		//current time
		Date d2 = new Date();

		//before date
		Date d1 = new Date(d2.getTime() - (2 * 24 * 3600 * 1000));

		ex.dateDifference(d1, d2);

	}

	public void dateDifference(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();		 

		System.out.println("Time diff in Millisec :: " + diff);
		
		diff = 162864586;

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);

		System.out.print(diffDays + " days, ");
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " seconds.");
	}

}
