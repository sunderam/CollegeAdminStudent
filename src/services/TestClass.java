package services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String from = "2018-05-10";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		Date date;
		try {
			date = format.parse(from);
			System.out.println("from :"+date);
			
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			
			System.out.println("todays :"+sqlDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
