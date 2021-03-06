package com.nolla.dseknolla;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MapChooser2 extends Activity {
	private DrawerLayout mDrawerLayout;
	 
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
		setContentView(R.layout.activity_map_chooser2);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		 
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		
		// Getting reference to the ActionBarDrawerToggle
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			/** Called when drawer is closed */
			public void onDrawerClosed(View view) {
				getActionBar().setTitle("Kartor");
				invalidateOptionsMenu();

			}

			/** Called when a drawer is opened */
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle("Kartor");
				
				
				
				invalidateOptionsMenu();
			}

		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), 
//				R.layout.drawer_list_item, getResources().getStringArray(R.array.menus));
		colorArrayAdapter adapter = new colorArrayAdapter(getBaseContext(), 
				getResources().getStringArray(R.array.menus),2);
		
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
					Intent intent=new Intent(MapChooser2.this,CalendarActivity.class);
					startActivity(intent);
				}
				else if(position==1){
					Intent intent=new Intent(MapChooser2.this,NewsActivity.class);
					startActivity(intent);
				}
				else if(position==2){
					Intent intent=new Intent(MapChooser2.this,MapChooser.class);
					startActivity(intent);
				}
				else if(position==3){
					Intent intent=new Intent(MapChooser2.this,Ordlista.class);
					startActivity(intent);
				}
				else if(position==4){
					Intent intent=new Intent(MapChooser2.this,InfoAndLinks.class);
					startActivity(intent);
				}

			

			}
		});   
	     
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map_chooser, menu);
		return true;
	}
	public void showCampusMap(View view){
		Intent intent=new Intent(this,CampusMap.class);

		startActivity(intent);
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
