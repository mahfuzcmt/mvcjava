package edu.vub.ns.webcore.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
	
	public static void main(String[] args) {
		System.out.println(getDateStrWithPattern("dd-MMM-yyyy", new Date()));
	}
	
	private static SimpleDateFormat dateFormat;
	/**
	 * Use to parse String Date value to long date value
	 * @param strDateValue
	 * @return long
	 */
	public static long getDateAsLongValue(String strDateValue) {
		// create a SimpleDateFormat instance and define format
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long datevalue=0;
		try {
			// parse String vale to Date
			Date date =sdf.parse(strDateValue);
			// get long value for Date
			datevalue=date.getTime();
		} catch (ParseException e) {
			//LoggerUtils.getLog().error("An exception occurred while parsing String value to Date value", e);
		}
		return datevalue;
	}
	
	public static Date getDateFromStringWithPattern(String strDate, String datePattern)
	{
		Date date = null;
		dateFormat = new SimpleDateFormat(datePattern);
		try
		{
			date = dateFormat.parse(strDate);
		}
		catch (ParseException e)
		{
			
		}
		return date;
	}
	
	public static String getDateFromStringWithPattern(Date givenDate, String datePattern)
	{
		String strDate = null;
		dateFormat = new SimpleDateFormat(datePattern);
		try
		{
			strDate = dateFormat.format(givenDate);
		}
		catch (Exception e)
		{
			
		}
		return strDate;
	}
	
	public static Timestamp getTimestampFromStr(String strDateValue) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date dt;
		try {
			dt = sdf.parse(strDateValue);
			return new Timestamp(dt.getTime());
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Timestamp getTimestampFromDBStr(String strDateValue) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd.HH.mm.ss. SSS");
		java.util.Date dt;
		try {
			dt = sdf.parse(strDateValue);
			return new Timestamp(dt.getTime());
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String getStringDateFromDBStr(Date date) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("MMddyyyyHHmmssSSS");
		try {
			String dateStr=sdf1.format(date).toString();
			return dateStr;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Use to parse String Date value to Date value
	 * @param strDateValue
	 * @return long
	 */
	public static Date getDateFromStr(String strDateValue) {
		// create a SimpleDateFormat instance and define format
		strDateValue=strDateValue.substring(0, 8);
		DateFormat sdf = new SimpleDateFormat("MMddyyyy");
		Date datevalue=null;
		try {
			// parse String vale to Date
			datevalue =sdf.parse(strDateValue);			
		} catch (ParseException e) {
			//LoggerUtils.getLog().error("An exception occurred while parsing String value to Date value", e);
		}
		return datevalue;
	}
	
	public static String getStringDateFromStr(String strDateValue) {
		 String strDate=null;
		 try {
		      //create SimpleDateFormat object with source string date format
			 SimpleDateFormat sdfSource  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		     
		      //parse the string into Date object
		      Date date = sdfSource.parse(strDateValue);
		     
		      //create SimpleDateFormat object with desired date format
		      SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		     
		      //parse the date into another format
		      strDate = sdfDestination.format(date);		     
		     
		      //System.out.println("Converted date is : " + strDate);
		     
		 } catch(ParseException pe) {
			 System.out.println("Parse Exception : " + pe);
		 }
		 return strDate;
	}
	
	
	@SuppressWarnings("deprecation")
	public static String getStringDateByOneDec(String strDateValue) {
		 String strDate = null;
		 try {
			 //create SimpleDateFormat object with source string date format
			 SimpleDateFormat sdfSource  = new SimpleDateFormat("yyyyMMdd");
		     //parse the string into Date object
		     Date date = sdfSource.parse(strDateValue);
		     date.setDate(date.getDate()-1);
		     //parse the date into another format
		     strDate = sdfSource.format(date);
	     } catch(ParseException pe) {
	    	 System.out.println("Parse Exception : " + pe);
	     }
		 return strDate;
	}
	
	/**
	 * used to get formatted date as String
	 * @return String
	 */
	public static String getDateStrWithPattern(String datePattern, Date givenDate) {
		if(givenDate == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		String date = sdf.format(givenDate);
		return date;
	}
	
	public static Date getDateWithPattern(String datePattern, String givenDate) {
		Date date = null;
		if(givenDate == null){
			return date;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		try {
			date = sdf.parse(givenDate);
		} catch (ParseException e) {
			// e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * used to get system current date
	 * @return Date
	 */
	public static java.sql.Date getCurrentSystemDate()
	{
		java.sql.Date systemSqlDate = new java.sql.Date(new Date().getTime());
		
		return systemSqlDate;
	}
	
	// Get System Date
		public static Date getSystemDate()
		{
			return new Date();
		}
	
	public static String formatDateToString(Date givenDate)
	{
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(givenDate);
	}
	
	@SuppressWarnings("deprecation")
	public static String getTomorrowDate()
	{
		Date todayDate = getSystemDate();
		todayDate.setDate(todayDate.getDate() + 1);
		return formatDateToString(todayDate);
	}
	
	public static String getTodayDate()
	{
		return formatDateToString(getSystemDate());
	}
	
	public static String getTodayDateTimeStr()
	{
		return formatDateToString(getSystemDate())+" "+"00:00:00";
	}
	
	public static String getTomorrowDateTimeStr()
	{
		return getTomorrowDate()+" "+"23:59:59";
	}
	
	public static Date getDateFromString(String date)
	{
		Date dt = null;
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		
		try
		{
			dt = dateFormat.parse(date);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return dt;
	}
	
	public static String getTimeGMT(String timeZone)
	{
			TimeZone tz = TimeZone.getTimeZone(timeZone);        
	        int rawOffset = tz.getRawOffset();
	        
	        String strSymbol = "+";
	        if(rawOffset < 0)
	        {
	         strSymbol = "-";
	        }
	        
	        int hour = rawOffset / (60*60*1000);
	        int min = Math.abs(rawOffset / (60*1000)) % 60;
	        
	        if(hour<0){
	        	hour *= -1;
	        }
	        
	        if(hour < 10 )
	        {
	        	strSymbol += "0"+hour; 
	        }
	        else
	        {
	         strSymbol += String.valueOf(hour);
	        }
	        strSymbol += ":";
	        if(min < 10)
	        {
	         strSymbol += "0"+min; 
	        }
	        else
	        {
	         strSymbol += String.valueOf(min);
	        }
	        return "GMT"+strSymbol;
	}
	
	public static String getOneMinusDate(String orinalDate)
	 {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String reduceDate = null;		  
		  try {
			   Date d = format.parse(orinalDate); 
			   cal.setTime(d);
			   cal.add(Calendar.SECOND, -1);
			   d = cal.getTime();			   
			   reduceDate = format.format(d);
		   
		  } catch (ParseException e) {
			  	e.printStackTrace();
		  }		  
		  return reduceDate;
	 }
	
	
	/**
	 * Get Actual Duration
	 * @param disconnect
	 * @param orig
	 * @return double
	 */
	public static double getActualDuration(Date disconnect, Date orig)
	{
		double callDuration = (disconnect.getTime() - orig.getTime()) / 1000.0;
		
		return callDuration;
	}
	
	public static double getRoundDownDuration(Date disconnect, Date orig)
	{
		double callDuration = (disconnect.getTime() - orig.getTime()) / 1000.0;
		
		callDuration = Math.floor(callDuration);
			
		
		return callDuration;
	}
	
}
