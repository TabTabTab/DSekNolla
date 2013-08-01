package com.nolla.dseknolla;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.util.Calendars;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class RetrieveCalendar extends AsyncTask<String,Void,Calendar>{
	private Exception exception;
	private Calendar calendar;
	protected Calendar doInBackground(String... urlText) {
		// TODO Auto-generated method stub
		try {
			URL url=new URL(urlText[0]);
			//URL url = new URL("http://www.dsek.se/kalender/ical.php?person=&dsek&tlth");
			String filePath=urlText[1];
			



			BufferedReader reader =new BufferedReader(new InputStreamReader(url.openStream(), "ISO-8859-15"));
			

			StringBuilder calendarString = new StringBuilder();
			String lastLine="";
			String currentLine="";
			String line = null;
			
			String line1="";
			while((line=reader.readLine())!=null){
		
//				lastLine=currentLine;
				currentLine=line;
				
				if(currentLine.contains("DESCRIPTION:")){
					line1= currentLine.substring(currentLine.indexOf(":")+1);
					Log.w("efter : " ,line1);
					currentLine="DESCRIPTION:";
					calendarString.append(currentLine);
				}

				else{
					
			if(!line1.equals("")){
				
				
				
				calendarString.append(line1.trim()+"\n");
				Log.w("test",currentLine);
//				calendarString.append("DTEND;TZID=Europe/Stockholm:20130101T030002"+"\n");
				if(currentLine.contains("DTEND;TZID=Europe/Stockholm:")){
				calendarString.append(currentLine+"\n");
				}
				line1="";
				}
			else{
				if(currentLine.contains("DTEND;TZID=Europe/Stockholm:")){
					calendarString.append("\n");
				}
				calendarString.append(currentLine.trim()+"\n");
			}
				}
//				if(currentLine.equals("DESCRIPTION:")){
//					
//				}
//				else{
//					if(lastLine.equals("DESCRIPTION:")){
//						calendarString.append("DESCRIPTION:"+currentLine.trim()+"\n");
//						Log.w("log","DESCRIPTION:"+currentLine.trim()+"\n");
//					}
//					calendarString.append(currentLine.trim()+"\n");
//					}


			}


			
			



			FileWriter fw= new FileWriter(filePath+"/kalender.txt");
			fw.write(calendarString.toString());
			fw.close();
		

			calendar=Calendars.load(filePath+"/kalender.txt");
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