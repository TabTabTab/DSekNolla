package com.nolla.dseknolla;

import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.Property;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Scroller;
import android.widget.TextView;

public class CalendarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar2);
		// Show the Up button in the action bar.

		setupActionBar();
		syncCalendar();
		//((TextView)findViewById(R.id.calendarText)).setMovementMethod(new ScrollingMovementMethod());
		
	
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void syncCalendar(){
		String FilePath = this.getFilesDir().getPath().toString();

		String urlText="http://www.dsek.se/kalender/ical.php?person=&dsek&tlth";
		CalendarReader cr=new CalendarReader(urlText,FilePath);
		TextView tw=(TextView)findViewById(R.id.calendarText);
		Context context = this;
		Scroller scroller = new Scroller(context);
		scroller.setFriction(1000);
		tw.setScroller(scroller);
		ComponentList cList=cr.getComponentList();
		StringBuilder sb=new StringBuilder();
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
				String end=null;
				String start=null;
				String location=null;
				String summary=null;
				String description=null;
				boolean nollning=false;
				
				
				for(Object p:((Component)c).getProperties()){
					Property prop=(Property)p;
					

					if(prop.getName().equals("DTSTART")){
						String startTime =prop.getValue();
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
				sb.append(summary+"\n");
				sb.append("Från: "+start+" Till: "+end+"\n");
				if(!description.equals("")){
				sb.append(description+"\n");
				}
				if(location!=null){
				sb.append("Plats: "+location+"\n");
				}
				sb.append("\n");
				}
			}
		}
		tw.setText(sb.toString());
		tw.scrollTo(0, tw.getTop());
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