package com.nolla.dseknolla;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.util.Calendars;
import android.os.AsyncTask;
import android.util.Log;

public class RetrieveCalendar extends AsyncTask<String,Void,Calendar>{
	private Exception exception;
	private Calendar calendar;
	protected Calendar doInBackground(String... urlText) {
		// TODO Auto-generated method stub
		try {
			URL url=new URL(urlText[0]);
			InputStream is= url.openStream();
			Scanner scan=new Scanner(is);
			for(int i=0;i<30;i++){
				Log.w("url info:  ", scan.nextLine());
			}
			
			
			
//			 Calendar calendar=new Calendar();
//			calendar=Calendars.load("C:/Users/Johan/Documents/GitHub/DSekNolla/TextICalURL.txt");
//			 FileInputStream fin = new FileInputStream("/DSekNolla/TextICalURL.txt");
//
//			 CalendarBuilder builder = new CalendarBuilder();
//
//			 calendar = builder.build(fin);
			 calendar=Calendars.load(url);
//			 Log.w("Calendar.toString():  ", calendar.toString());
//			TextView calendarText=(TextView)findViewById(R.id.calendarText);
//			CalendarBuilder calBuilder= new CalendarBuilder();
//			calendar=calBuilder.build(is);
			return calendar;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		catch (ParserException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return null;
	}
	protected void onPostExecute(Calendar calendar) {
        // TODO: check this.exception 
        // TODO: do something with the feed
    }
	public Calendar getCalendar(){
//		Log.w("AFTER!!!:::Calendar.toString() :  ", calendar.toString());
		return calendar;
	}
}