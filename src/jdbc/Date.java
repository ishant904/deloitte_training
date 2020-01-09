package jdbc;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Date {

	public static void main(String[] args) {
		LocalDate id = LocalDate.now();
		System.out.println(id);
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd-MM-YYYY");
		System.out.println(dtf.format(id));
		System.out.println(daysToDate("25-12-2020"));

	}
	
	public static long daysToDate(String date) {
		LocalDate today=LocalDate.now();
		/*int thisyear=today.getYear();
		int thismonth=today.getMonthValue();
		int day=today.getDayOfMonth();
		System.out.println(thisyear+":"+thismonth+":"+day);*/
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate futureDate = LocalDate.from(dtf.parse(date));
		/*int futureYear=futureDate.getMonthValue();
		int futureDays=futureDate.getDayOfMonth();*/
		
		long daysBetween = ChronoUnit.DAYS.between(today, futureDate);
		return daysBetween;
		
	}

}
