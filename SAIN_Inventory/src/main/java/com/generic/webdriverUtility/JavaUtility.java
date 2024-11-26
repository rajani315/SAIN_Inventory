package com.generic.webdriverUtility;


/**
 * Contains java reusable methods
 * @author Rajani 
 * 
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * To get the random number
	 * @return int
	 */
	public int getRandomNum() {
		Random r=new Random();
		int num=r.nextInt(5000);
		return num;
	}
	
	/**
	 * To get the current date in yyyy-MM-dd format
	 * @return String
	 */
	public String getSystemDateInddMMyyyy() {
		Date dateObj=new Date();
		SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
		String date = s.format(dateObj);
		return date;
	}
	
	/**
	 * To add the days to get the required date in yyyy-MM-dd format
	 * @param days
	 * @return String
	 */
	public String getRequiredDateddMMyyyy(int days) {
		/*Date date = new Date(); // creates object of Date with current date, time and timezone details
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		s.format(date);
		Calendar cal = s.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		Date dateObj = cal.getTime();
		String requiredDate = s.format(dateObj);
		*/
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // creates format for date

        Calendar calndr = Calendar.getInstance();
        calndr.add(Calendar.DAY_OF_MONTH, 30);
        String requiredDate = dateFormat.format(calndr.getTime());
        return requiredDate;
	}
}
