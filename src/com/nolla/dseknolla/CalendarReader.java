package com.nolla.dseknolla;

import java.util.concurrent.ExecutionException;

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
		try {
			calendar=retCal.execute(urlText).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		calendar=retCal.getCalendar();
	}
		
	public ComponentList getComponentList(){
		calendar.hashCode();
		return calendar.getComponents();
	}

}