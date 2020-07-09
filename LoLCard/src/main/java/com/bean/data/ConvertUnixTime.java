package com.bean.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertUnixTime {
	public static String convertDate(Long timestampStr){
	    
	    Date date = new java.util.Date(timestampStr); 
	    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+9")); 
	    String formattedDate = sdf.format(date);
	    
	    return formattedDate;
	}
}
