package com.nolla.dseknolla;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.Property;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Html;
import android.text.format.Time;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

public class CalendarActivity extends Activity {
	CalendarReader cr;
	@Override
	public boolean onKeyDown(int i, KeyEvent event) {
		
		if(i==KeyEvent.KEYCODE_MENU){
			return true;
		}
		else{
		return super.onKeyDown(i, event);
		}
		
	}
	
	private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager  = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null;
	}
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		// Show the Up button in the action bar.
	
		setupActionBar();
		
		try {
			syncCalendar();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//((TextView)findViewById(R.id.calendarText)).setMovementMethod(new ScrollingMovementMethod());
		
	
	}

	//@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void syncCalendar() throws FileNotFoundException{
		TextView tw=(TextView)findViewById(R.id.calendarText);
		String FilePath = this.getFilesDir().getPath().toString();
		Time old = new Time();
		
		
		
		File file = new File(FilePath+"/calendarTime.txt");
		if(file.exists()) {
		
		StringBuilder sb1 = new StringBuilder();
		
		FileInputStream in;
		try {
			in = openFileInput("calendarTime.txt");
			   InputStreamReader inputStreamReader = new InputStreamReader(in);
			    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			    
			    String line;

			    while ((line = bufferedReader.readLine()) != null) {
			        sb1.append(line);
			       
			    }
			
			
		} catch (FileNotFoundException e1) {
		
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] splits =sb1.toString().split("Europe");
		String year =splits[0].substring(0, 4);
	
		String month =splits[0].substring(4, 6);
	
		String monthDay =splits[0].substring(6, 8);

		String hour =splits[0].substring(9, 11);

		String minute =splits[0].substring(11, 13);
	
		String second =splits[0].substring(13, 15);
	
		
		
	
		old.set(Integer.parseInt(second), Integer.parseInt(minute), Integer.parseInt(hour), Integer.parseInt(monthDay), Integer.parseInt(month)+1, Integer.parseInt(year));
		 
		Time newTime = new Time();
		newTime.setToNow();
		if(newTime.monthDay>old.monthDay){
			
			updateCalendar();		}
		//+33
		else if(newTime.hour>old.hour+3){
			updateCalendar();
		}
		
		else{
			
			
			
			   BufferedReader br = new BufferedReader(new FileReader(FilePath+"/kalender.txt"));
			    try {
			        StringBuilder sb = new StringBuilder();
			        String line = br.readLine();

			        while (line != null) {
			            sb.append(line);
			            sb.append('\n');
			            line = br.readLine();
			        }
			        String everything = sb.toString();
			       
			    	tw.setText(Html.fromHtml(everything));
					tw.scrollTo(0, tw.getTop());
					
			    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
			        try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			
			
			
		
		}
		
		
		}
		else{
		updateCalendar();
		}
	
	}
		
		
		
		@TargetApi(Build.VERSION_CODES.HONEYCOMB)
		public void updateCalendar() throws FileNotFoundException{
			Context context = this;
	
			
			TextView tw=(TextView)findViewById(R.id.calendarText);
			
			String FilePath = this.getFilesDir().getPath().toString();

		String urlText="http://www.dsek.se/kalender/ical.php?person=&dsek&tlth";
		boolean internetAccess=isNetworkAvailable();
		String InternetAccessString="0";
		if(internetAccess){
			//hämta en kalender annars ladda en gamal textfil
			InternetAccessString="1";
		}

		
		cr=new CalendarReader(urlText,FilePath,InternetAccessString,context,this);
		
		
		Scroller scroller = new Scroller(context);
		scroller.setFriction(1000);
		tw.setScroller(scroller);
		
		
	
	}
		
		
		
	public void showCalendar(){
		Context context = this;
		
		TextView tw=(TextView)findViewById(R.id.calendarText);
		String FilePath = this.getFilesDir().getPath().toString();
		ComponentList cList=cr.getComponentList();
		if(cList!=null){
		StringBuilder sb=new StringBuilder();
		String end=null;
		String start=null;
		String location=null;
		String summary=null;
		String description=null;
		boolean nollning=false;
		int oldDate=0;
		for(Object c:cList){
			String time = null;

			boolean show=false;
			for(Object p:((Component)c).getProperties()){
				Property prop=(Property)p;

				if(prop.getName().equals("DTSTART")){

					time = prop.getValue();
					if(time.contains("T")){
						time=time.substring(0, time.indexOf("T"));
						
					}
				}
			}	


			if(time!=null){
				if(Integer.parseInt(time)<20131007&&Integer.parseInt(time)>20130825){
					show=true;
				}
			}
			if(show){
				end=null;
				start=null;
				location=null;
				summary=null;
				description=null;
				nollning=false;
				String startTime = null;
				
				for(Object p:((Component)c).getProperties()){
					Property prop=(Property)p;
					

					if(prop.getName().equals("DTSTART")){
						startTime =prop.getValue();
						start=getFormatedTimeAsString(startTime);

					}
					if(prop.getName().equals("DTEND")){
						String endTime =prop.getValue();
						end=getFormatedTimeAsString(endTime);
					}
					if(prop.getName().equals("SUMMARY")){
						summary=prop.getValue();
						if(summary.equals("Nollning")){
							nollning=true;
						}
					}
					if(prop.getName().equals("DESCRIPTION")){
						description=prop.getValue();
					}
					if(prop.getName().equals("LOCATION")){
						location=prop.getValue();

					}
				}
				if(nollning==false){
				
				String[] date=startTime.split(" ");
				String[] date2=date[0].split("T");
				
				if(Integer.parseInt(date2[0])!=oldDate){
					oldDate=Integer.parseInt(date2[0]);
					sb.append("<h1>"+getFormatedTimeAsString(date2[0]).trim()+":"+"<h1> ");
				}
					
					
				sb.append("<h3>"+summary+"</h3>");
				sb.append("Från: "+start+" Till: "+end+"<br />");
				if(!description.equals("")){
				
				sb.append(description+"<br />");
				}
				if(location!=null){
				sb.append("Plats: "+location+"<br />");
				}
				sb.append("<br />");
				}
			}
		}
	
		tw.setText(Html.fromHtml(sb.toString()));
		tw.scrollTo(0, tw.getTop());
		FileWriter fw;
		try {
			Time CalendarNow = new Time();
			CalendarNow.setToNow();
			
			fw = new FileWriter(FilePath+"/kalender.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close();
			fw =new FileWriter(FilePath+"/calendarTime.txt");
			bw = new BufferedWriter(fw);
			bw.write(CalendarNow.toString());
			bw.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		
		
		
		
		
		}
		else{
		
			
		

			Toast toast = Toast.makeText(context, "Aktivera Internet för att hämta kalendern", Toast.LENGTH_SHORT);
			toast.show();	
		}
	}
	
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
			
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendar, menu);
		return true;
	}
	public String getFormatedTimeAsString(String startTime){
		StringBuilder sb = new StringBuilder();
		String hourMinute=null;
		if(startTime.contains("T")){
			startTime=startTime.replace("T", " ");
			hourMinute=startTime.substring(startTime.indexOf(" ")+1, startTime.indexOf(" ")+5);

		}
		startTime=startTime.substring(4);
		String Month =startTime.substring(0, 2);
		String date = startTime.substring(2,4);
		if((""+date.charAt(0)).equals("0")){
			date=""+date.charAt(1);
		}

		sb.append(date+" ");
		if(Month.equals("08")){
			sb.append("Augusti ");
		}
		else if(Month.equals("09")){
			sb.append("September ");
		}
		else{
			sb.append("Oktober ");
		}
		if(hourMinute!=null){
			String hour=hourMinute.substring(0, 2);
			String minute =hourMinute.substring(2);
			sb.append(" "+hour+":"+minute+" ");
		}
		return sb.toString();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}