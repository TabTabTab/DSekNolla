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
			//URL url=new URL(urlText[0]);
			URL url = new URL("http://www.dsek.se/kalender/ical.php?person=&dsek&tlth");
			String filePath=urlText[1];
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
//			 calendar=Calendars.load(url);
//			 Log.w("Calendar.toString():  ", calendar.toString());
//			TextView calendarText=(TextView)findViewById(R.id.calendarText);
//			CalendarBuilder calBuilder= new CalendarBuilder();
//			calendar=calBuilder.build(is);
			BufferedReader reader =new BufferedReader(new InputStreamReader(url.openStream(), "ISO-8859-15"));
			String line1=null;
//			while((line1=reader.readLine())!=null){
//				Log.w("rader: ",line1);
//			}
			StringBuilder calendarString = new StringBuilder();
			String lastLine="";
			String currentLine="";
			String line = null;
			int i=2;
			Log.w("kommer vi hit","ja");
			while((line=reader.readLine())!=null){
				//i++;
				lastLine=currentLine;
				currentLine=line;
				if(currentLine.contains("DESCRIPTION:")){
					currentLine="DESCRIPTION:";
					calendarString.append(currentLine);
				}
//				if(lastLine.contains("DESCRIPTION:")){
//					currentLine=" "+currentLine;
//				}
				else{
				calendarString.append(currentLine.trim()+"\n");
				}
//				if(i%2==0){
//					//ska man ha contains här?
//					Log.w("kommer vi hit iaf?",currentLine+"hit måste vi komma");
//					if(lastLine.equals("DESCRIPTION:\n")){
//						Log.w("här fanns det skit",currentLine+" detta är skit");
//						if(!currentLine.equals("\n")){
//							currentLine="aaaaaaaaaaaaaaaaaaaaaaaaaaa "+currentLine;
//						}
//
//					}
//					else{
//						calendarString.append(lastLine+"\n");
//						calendarString.append(currentLine+"\n");
//					}
//				}

			}

			Log.w("final",calendarString.toString());
			//stringReader
			StringReader stringReader = new StringReader(calendarString.toString());
			BufferedReader test = new BufferedReader(stringReader);
			while((line1=test.readLine())!=null){
				Log.w("modified",line1);
			}

			Log.w("modified","före filen är sparad");
//			FileOutputStream fos = new FileOutputStream("kalender.txt");
//			fos.write(calendarString.toString().getBytes());
//			fos.close();
			FileWriter test2= new FileWriter(filePath+"/kalender.txt");
			test2.write(calendarString.toString());
			test2.close();
			Log.w("modified","efter filen är sparad");
		//	CalendarBuilder builder = new CalendarBuilder();
		//	Calendar calendar = builder.build(test);
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