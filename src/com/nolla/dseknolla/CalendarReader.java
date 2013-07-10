package com.nolla.dseknolla;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.ComponentList;



/**
 * @author Johan
 *
 *Not yet tested
 */
public class CalendarReader  {
	private Calendar calendar;
	//not yet tested
	public CalendarReader(String urlText){
		RetrieveCalendar retCal=new RetrieveCalendar();
		retCal.execute(urlText);
		
		calendar=retCal.getCalendar();
	}
		
	public ComponentList getComponentList(){
		calendar.hashCode();
		return calendar.getComponents();
	}

}