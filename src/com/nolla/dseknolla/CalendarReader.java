package com.nolla.dseknolla;

import android.content.Context;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.ComponentList;



/**
 * @author Johan
 *
 *Not yet tested
 */
public class CalendarReader implements AsyncTaskCompleteListener<Calendar>{
	private Calendar calendar;
	private CalendarActivity calendarActivity;
	
	//not yet tested
	public CalendarReader(String urlText, String filePath,String InternetAccess, Context context, CalendarActivity calendarActivity){
		RetrieveCalendar retCal=new RetrieveCalendar(context,this);
		this.calendarActivity=calendarActivity;
	//	try {
			
		//	calendar=retCal.execute(urlText,filePath,InternetAccess).get();
			retCal.execute(urlText,filePath,InternetAccess);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		calendar=retCal.getCalendar();
	}

	public ComponentList getComponentList(){
		if(calendar!=null){
		return calendar.getComponents();
		}
		else{
			return null;
		}
	}

	@Override
	public void onTaskComplete(Calendar result) {
		calendar=result;
		calendarActivity.showCalendar();
		
	}

}