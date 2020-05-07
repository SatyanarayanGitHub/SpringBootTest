package com.satya.test.SpringBootTest.utility;

import org.springframework.stereotype.Component;

import com.satya.test.SpringBootTest.bean.AverageTimeBean;

@Component
public class TestUtility {

	public AverageTimeBean convertTime(long time) {

		AverageTimeBean avgTime = new AverageTimeBean();

		long diffSeconds = time / 1000 % 60;
		long diffMinutes = time / (60 * 1000) % 60;
		long diffHours = time / (60 * 60 * 1000) % 24;
		long diffDays = time / (24 * 60 * 60 * 1000);

		avgTime.setSeconds(diffSeconds);
		avgTime.setMinutes(diffMinutes);
		avgTime.setHours(diffHours);
		avgTime.setDays(diffDays);

		return avgTime;

	}

}
