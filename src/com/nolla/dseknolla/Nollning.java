package com.nolla.dseknolla;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Nollning extends Activity {
	private DrawerLayout mDrawerLayout;
	private View clickedView;
	// ListView represents Navigation Drawer
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
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
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) { 
		        // Activity was brought to front and not created, 
		        // Thus finishing this will get us to the last viewed activity 
		        finish(); 
		        return; 
		    } 
		setContentView(R.layout.activity_nollning);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerLayout.closeDrawers(); 
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// Getting reference to the ActionBarDrawerToggle
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			/** Called when drawer is closed */
			public void onDrawerClosed(View view) {
				getActionBar().setTitle("Nolleappen");
				invalidateOptionsMenu();

			}

			/** Called when a drawer is opened */
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle("Nolleappen");



				invalidateOptionsMenu();
			}

		};


		mDrawerLayout.setDrawerListener(mDrawerToggle);
		//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), 
		//				R.layout.drawer_list_item, getResources().getStringArray(R.array.menus));
		colorArrayAdapter adapter = new colorArrayAdapter(getBaseContext(), 
				getResources().getStringArray(R.array.menus),-1);

		// Setting the adapter on mDrawerList
		mDrawerList.setAdapter(adapter);

		// Enabling Home button
		getActionBar().setHomeButtonEnabled(true);

		// Enabling Up navigation
		getActionBar().setDisplayHomeAsUpEnabled(true); 
		mDrawerList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if(position==0){

					view.setBackgroundColor(Color.parseColor("#33B5E5"));
					clickedView=view;
					mDrawerLayout.closeDrawers();
					final Handler handler = new Handler();
					handler.postDelayed(new Runnable() {
						@Override
						public void run() {
							Intent intent=new Intent(Nollning.this,CalendarActivity.class);
							clickedView.setBackgroundColor(Color.parseColor("#F280A1"));
							startActivity(intent); 
						}
					}, 250);

				}
				else if(position==1){

					view.setBackgroundColor(Color.parseColor("#33B5E5"));
					clickedView=view;
					mDrawerLayout.closeDrawers();
					final Handler handler = new Handler();
					handler.postDelayed(new Runnable() {
						@Override
						public void run() {
							Intent intent=new Intent(Nollning.this,NewsActivity.class);
							clickedView.setBackgroundColor(Color.parseColor("#F280A1"));
							startActivity(intent); 
						}
					}, 250);
				}
				else if(position==2){

					view.setBackgroundColor(Color.parseColor("#33B5E5"));
					clickedView=view;
					mDrawerLayout.closeDrawers();
					final Handler handler = new Handler();
					handler.postDelayed(new Runnable() {
						@Override
						public void run() {
							Intent intent=new Intent(Nollning.this,MapChooser.class);
							clickedView.setBackgroundColor(Color.parseColor("#F280A1"));
							startActivity(intent); 
						}
					}, 250);
				}
				else if(position==3){

					view.setBackgroundColor(Color.parseColor("#33B5E5"));
					clickedView=view;
					mDrawerLayout.closeDrawers();
					final Handler handler = new Handler();
					handler.postDelayed(new Runnable() {
						@Override
						public void run() {
							Intent intent=new Intent(Nollning.this,Ordlista.class);
							clickedView.setBackgroundColor(Color.parseColor("#F280A1"));
							startActivity(intent); 
						}
					}, 250);
				}
				else if(position==4){

					view.setBackgroundColor(Color.parseColor("#33B5E5"));
					clickedView=view;
					mDrawerLayout.closeDrawers();
					final Handler handler = new Handler();
					handler.postDelayed(new Runnable() {
						@Override
						public void run() {
							Intent intent=new Intent(Nollning.this,InfoAndLinks.class);
							clickedView.setBackgroundColor(Color.parseColor("#F280A1"));
							startActivity(intent); 
						}
					}, 250);
				}



			}
		});   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nollning, menu);
		return true;
	}
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return true;
		//return super.onOptionsItemSelected(item);

	}

}
