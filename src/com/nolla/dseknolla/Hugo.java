package com.nolla.dseknolla;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Hugo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hugo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hugo, menu);
		return true;
	}
	public void sendMessage(View view){
		EditText myText = (EditText) this.findViewById(R.id.editText1);
		String text=myText.getText().toString();
		Context context =this;
		HugoSender sender = new HugoSender(context);
//		try {
			sender.execute(text);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
