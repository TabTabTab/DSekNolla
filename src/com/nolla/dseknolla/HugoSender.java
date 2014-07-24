package com.nolla.dseknolla;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import android.content.Context;
import android.os.AsyncTask;

import android.util.Log;
import android.widget.Toast;

public class HugoSender extends AsyncTask<String,Void,String>{
	String stringToSend;
	private boolean success=true;
	private Context context;
	
	
	public HugoSender(Context context) {
		this.context=context;
		
	}
	
	
	

	@Override
	protected String doInBackground(String... urlText) {
		
		try {
			stringToSend=urlText[0];
			Socket connection = new Socket("hugo.dsek.lth.se", 1101); 
			PrintStream out = new PrintStream(connection.getOutputStream());
			out.println(stringToSend);
			out.close();
			connection.close();
	
	
			
		} catch (IOException e) { 
			success=false;
			
		}
		return stringToSend;
	}
	@Override
	protected void onPostExecute(String x) {
		if(success){
			Toast toast = Toast.makeText(context, "Ditt medelande har skickats till Hugo", Toast.LENGTH_SHORT);
			toast.show();
		}
		else{
			Toast toast = Toast.makeText(context, "Ditt medelande kunde inte skickas till Hugo", Toast.LENGTH_SHORT);
			toast.show();
		}
	}	
	

	
}