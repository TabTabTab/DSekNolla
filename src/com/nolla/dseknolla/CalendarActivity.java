package com.nolla.dseknolla;

import java.io.File;
import java.io.FileOutputStream;

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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class CalendarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		// Show the Up button in the action bar.

		setupActionBar();
		syncCalendar();
		((TextView)findViewById(R.id.calendarText)).setMovementMethod(new ScrollingMovementMethod());
	}

	private void syncCalendar(){
	String FilePath = this.getFilesDir().getPath().toString();

		String urlText="http://www.calendarwiz.com/CalendarWiz_iCal.php?crd=norfolkgov";
		CalendarReader cr=new CalendarReader(urlText,FilePath);
		TextView tw=(TextView)findViewById(R.id.calendarText);
		ComponentList cList=cr.getComponentList();
		StringBuilder sb=new StringBuilder();
		for(Object c:cList){
			for(Object p:((Component)c).getProperties()){
				Property prop=(Property)p;
				sb.append("Name: "+prop.getName()+" Value:  "+prop.getValue()+"\n\n**");
			}
		}
		tw.setText(sb.toString());
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