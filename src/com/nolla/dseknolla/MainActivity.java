package com.nolla.dseknolla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) { 
		        // Activity was brought to front and not created, 
		        // Thus finishing this will get us to the last viewed activity 
		        finish(); 
		        return; 
		    } 
		setContentView(R.layout.activity_main);
		ScrollView scroll=(ScrollView)findViewById(R.id.SCROLLER_ID222);
		scroll.scrollTo(0, scroll.getTop());
		
		
	}
	

	@Override
	public boolean onKeyDown(int i, KeyEvent event) {
	
		if(i==KeyEvent.KEYCODE_MENU){
			return true;
		}
		else{
		return super.onKeyDown(i, event);
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
	
		return true;
	}
	
	public void showCalendar(View view){
		Intent intent=new Intent(this,CalendarActivity.class);
		startActivity(intent);
	}
	public void showWordList(View view){
		Intent intent=new Intent(this,Ordlista.class);
		startActivity(intent);
	}
	
	
	
	public void showNews(View view){
		Intent intent=new Intent(this,NewsActivity.class);
		
	
		
		startActivity(intent);
	}
	
	public void showMap(View view){
		Intent intent=new Intent(this,MapChooser.class);
		
	
		
		startActivity(intent);
	}
	
	public void showInfoList(View view){
		Intent intent=new Intent(this,InfoAndLinks.class);
		
	
		
		startActivity(intent);
	}
	
	public void showHugo(View view){
		Intent intent=new Intent(this,Hugo.class);
		
		
		
		startActivity(intent);
	}

}