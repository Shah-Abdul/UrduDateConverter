package mains;
import urducalendarconverter.*;
import java.util.Scanner;
import java.util.Calendar;
import java.time.LocalDate;
public class TestConverter {
	//To initialise the DAY_OF_WEEK field in Calendar object
	public int dayOfWeek(LocalDate s)
	{
		int i=0;
		String[] arr=new String[]{"","SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
		for(i=0;i<8;i++)
		{
			if(arr[i].equals(s.getDayOfWeek().name())==true)
				break;
		}
		return i;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar date=Calendar.getInstance(); //Calendar object is the paramter to be sent to getSimpleDate() of class HijriCalendar
		LocalDate ld;	//Purely for getting the DayOfWeek to set appropriate field in Calendar object
		TestConverter t=new TestConverter(); // For calling getDayOfWeek() of this class
		int d,m,y,dow;	//date,month,year,day of week. 1 is sunday,2 is monday, so on.
		Scanner input=new Scanner(System.in);
		System.out.println("\nEnter the Gregorian date to be converted(DD-MM-YYYY):\n");
		System.out.println("DD: \t");
		d=input.nextInt();
		System.out.println("MM: \t");
		m=input.nextInt();
		System.out.println("YYYY: \t");
		y=input.nextInt();
		ld=LocalDate.of(y, m, d);
		dow=t.dayOfWeek(ld);
		// Setting the Calendar object 'date' to refer to user-entered date
		date.set(Calendar.DAY_OF_MONTH,d);
		date.set(Calendar.MONTH,m-1);	//January-0,Feb-1,Mar-2 so on in Calendar obj. So subtract 1 from user entered month
		date.set(Calendar.YEAR, y);
		date.set(Calendar.DAY_OF_WEEK,dow);
		System.out.println(HijriCalendar.getSimpleDate(date));
		input.close();
	}
	
}
