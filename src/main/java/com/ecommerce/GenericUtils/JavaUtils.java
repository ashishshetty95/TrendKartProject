package com.ecommerce.GenericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	/**
	 * This method is used to generate a random number
	 * @param range
	 * @return
	 */
	public int getRandomNumber(int range) {
		Random r=new Random();
		int random=r.nextInt(range);
		return random;
	}
	/**
	 * This method is used tp get the System date
	 * @return
	 */
	public String systemDate() {
		Date date=new Date();
		String systemDate = date.toString();
		return systemDate;
	}
	/**
	 * This method is used to get the date in required format
	 * @return
	 */
	public String systemDateInFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		Date date = new Date();
		String systemDateInFormat = dateFormat.format(date);
		return systemDateInFormat;
	}
}
