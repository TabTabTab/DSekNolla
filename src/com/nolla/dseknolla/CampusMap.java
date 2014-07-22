package com.nolla.dseknolla;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;

public class CampusMap extends Activity {
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
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	    WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.campus);
//	   String imageUrl =  "file:///android_asset/campussnygg.png";
	    
		String imageUrl =  "file:///android_asset/test.htm";
	
	    
	    
	    
	    
        WebView wv = (WebView) findViewById(R.id.webView1);
        wv.getSettings().setBuiltInZoomControls(true);
     // wv.getSettings().setLoadWithOverviewMode(true);
	 // wv.getSettings().setUseWideViewPort(true);
	
       // wv.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        
        
        
        
        Display display=getWindowManager().getDefaultDisplay();
        
        int width=display.getWidth();
        
        width=width/2;
        
   
        
        
        
        
        
        String data="<html><body bgcolor=\"#F280A1\"><style>body { margin: 0; padding: 0; }</style><img src=\"file:///android_asset/campussnygg.png\" style=\"width:"+width+"px\"/></body></html>";
         
        
        wv.loadDataWithBaseURL("fake://not/needed", data, "text/html", "utf-8", "");
    
        
        
        
        
      
        

       
        
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

}
