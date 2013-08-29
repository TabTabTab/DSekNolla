package com.nolla.dseknolla;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.text.format.Time;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

public class NewsActivity extends Activity implements AsyncTaskCompleteListener<String>{
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
		setContentView(R.layout.activity_news);
		// Show the Up button in the action bar.
		setupActionBar();
		String FilePath = this.getFilesDir().getPath().toString();
		TextView tw=(TextView)findViewById(R.id.newsText);
		Time old = new Time();
		File file = new File(FilePath+"/newsTime.txt");
		if(file.exists()) {
			
			StringBuilder sb1 = new StringBuilder();
			
			FileInputStream in;
			try {
				in = openFileInput("newsTime.txt");
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
				
				updateNews();		
				}
			
			else if(newTime.hour>old.hour+3){
				updateNews();
			}
			
			else{
				
				
				
				   BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(FilePath+"/news.txt"));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				    try {
				        StringBuilder sb = new StringBuilder();
				        String line = br.readLine();

				        while (line != null) {
				            sb.append(line);
				            sb.append('\n');
				            line = br.readLine();
				        }
				        String everything = sb.toString();
				        tw.setMovementMethod(LinkMovementMethod.getInstance());
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
			updateNews();
		}
		
		
		

		
	}
	
	
	private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager  = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null;
	}
		
		
	private void updateNews(){
		String FilePath = this.getFilesDir().getPath().toString();
		TextView tw=(TextView)findViewById(R.id.newsText);
		if(isNetworkAvailable()){
	
		
		
		Context context = this;
		RetriveNews retriveNews=new RetriveNews(context,this);
		
//		try {
			//tw.setText(Html.fromHtml(retriveNews.execute(FilePath).get()));
			retriveNews.execute(FilePath);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		tw.scrollTo(0, tw.getTop());

		}
		else{
			File file = new File(FilePath+"/news.txt");
			if(file.exists()) {
				
			
					
					
					
					 BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader(FilePath+"/news.txt"));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
				
				
				
			
			
			else{
				Context context = this;
				Toast toast = Toast.makeText(context, "Aktivera Internet för att hämta nyheterna", Toast.LENGTH_SHORT);
				toast.show();	
			}	

		}
	}
		
	private void showNews(String result){
		TextView tw=(TextView)findViewById(R.id.newsText);
		tw.setMovementMethod(LinkMovementMethod.getInstance());
	//	tw.setText(Html.fromHtml("<a href=\"mailto:Pablo.Moscato@newcastle.edu.au\">Pablo.Moscato@newcastle.edu.au</a>"));
		tw.setText(Html.fromHtml(result));
		
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
		getMenuInflater().inflate(R.menu.news, menu);
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


	@Override
	public void onTaskComplete(String result) {
		
		showNews(result);
		
		// TODO Auto-generated method stub
		
	}

}
