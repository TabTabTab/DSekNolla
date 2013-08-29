package com.nolla.dseknolla;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.util.Calendars;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.content.Context;
public class RetrieveCalendar extends AsyncTask<String,Void,Calendar>{
	private Exception exception;
	private Calendar calendar;
	private Context context;
	ProgressDialog progressDialog;
	private AsyncTaskCompleteListener<Calendar> callback;
	public RetrieveCalendar(Context context, AsyncTaskCompleteListener<Calendar> cb) {
		this.context=context;
		this.callback=cb;
	}


    
  
    @Override
    protected void onPreExecute()
    {
    	super.onPreExecute();
      progressDialog= ProgressDialog.show(context, "Hämtar Kalendern","", true);


    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
        //do initialization of required objects objects here                
    }; 
	

	@Override
	protected Calendar doInBackground(String... urlText) {
		// TODO Auto-generated method stub
	
		try {
			URL url=new URL(urlText[0]);
			//URL url = new URL("http://www.dsek.se/kalender/ical.php?person=&dsek&tlth");
			String filePath=urlText[1];
			String internetAccess=urlText[2];
			if(internetAccess.equals("0")){
				File file = new File(filePath+"/kalender2.txt");
				if(file.exists()) {
					calendar=Calendars.load(filePath+"/kalender2.txt");
					
					return calendar;
					
			}
				else{
					
					return null;
				}
			}
			else{

			
			BufferedReader reader = null;
			try{
			reader =new BufferedReader(new InputStreamReader(url.openStream(), "ISO-8859-15"));
			}
			catch(Exception e){
				
			}
		
			
			

			StringBuilder calendarString = new StringBuilder();
			
			String currentLine="";
			String line = null;

			String line1="";
			while((line=reader.readLine())!=null){

				//				lastLine=currentLine;
				currentLine=line;

				if(currentLine.contains("DESCRIPTION:")){
					line1= currentLine.substring(currentLine.indexOf(":")+1);
					
					currentLine="DESCRIPTION:";
					calendarString.append(currentLine);
				}

				else{

					if(!line1.equals("")){



						calendarString.append(line1.trim()+"\n");



						if(currentLine.contains("DTEND;TZID=Europe/Stockholm;VALUE=DATE:20130832")){
							currentLine="DTEND;TZID=Europe/Stockholm;VALUE=DATE:20130831";
							calendarString.append(currentLine+"\n");

						}
						else{
							calendarString.append(currentLine+"\n");
						}

						line1="";
					}
					else{

						if(currentLine.contains("DTEND;")){
							if(currentLine.contains("DTEND;TZID=Europe/Stockholm;VALUE=DATE:20130832")){
								currentLine="DTEND;TZID=Europe/Stockholm;VALUE=DATE:20130831";
							}
							calendarString.append("\n");
							calendarString.append(currentLine.trim()+"\n");
						}
						else{
							calendarString.append(currentLine.trim()+"\n");
						}
					}
				}

			}



			




			FileWriter fw= new FileWriter(filePath+"/kalender2.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(calendarString.toString());
			bw.close();
	
			

			calendar=Calendars.load(filePath+"/kalender2.txt");
			
			return calendar;




			}
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
		catch (Exception e) {
			// TODO Auto-generated catch block
			
		}

		return null;
	}
	@Override
	protected void onPostExecute(Calendar calendar) {
		// TODO: check this.exception
		// TODO: do something with the feed
		 progressDialog.dismiss();
		 callback.onTaskComplete(calendar);
	}
	public Calendar getCalendar(){
		//		Log.w("AFTER!!!:::Calendar.toString() :  ", calendar.toString());
		return calendar;
	}
}