package com.nolla.dseknolla;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.TextView;

public class InfoPane extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info_pane);
		TextView tw=(TextView)findViewById(R.id.textview);
		Intent intent = getIntent();
		String info=intent.getStringExtra("string");
		String title=intent.getStringExtra("title");
		this.setTitle(title);
		tw.setMovementMethod(LinkMovementMethod.getInstance());
		tw.setText(Html.fromHtml(info));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info_pane, menu);
		return true;
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

}
