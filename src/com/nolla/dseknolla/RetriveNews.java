package com.nolla.dseknolla;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.text.format.Time;

public class RetriveNews extends AsyncTask<String,Void,String>{
	private String newsString;
	ProgressDialog progressDialog;
	private Context context;
	private AsyncTaskCompleteListener<String> callback;
	
	public RetriveNews(Context context, AsyncTaskCompleteListener<String> cb) {
		this.context=context;
		this.callback=cb;
	}
	
	
	  @Override
	    protected void onPreExecute()
	    {
	    super.onPreExecute();
	      progressDialog= ProgressDialog.show(context, "Hämtar Nyheterna","", true);
             
	    }; 

	@Override
	protected String doInBackground(String... urlText) {
	
		String FilePath=urlText[0];
		
		
		
		StringBuilder sb = new StringBuilder();
		Document doc = null;
	
		try {
			
			doc = Jsoup.connect("http://www.dsek.se/").get();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
		//	e.printStackTrace();
		}


		Elements news =doc.getAllElements();
		Iterator<Element> itr = news.iterator();

		while(itr.hasNext()){
			Element element = itr.next();
			//if(element.id().contains("nyhetLang"))
			if(element.className().contains("fancyparagraph"))
			{
				Elements children=element.children();
				Iterator<Element> childItr = children.iterator();
				while(childItr.hasNext()){
					Element temp=childItr.next();
					if(temp.className().equals("fancyParagraphHeader")){
					
					sb.append("<h1>"+temp.text()+"</h1>");
					//	sb.append("<br />");
					//	sb.append("<br />");
		
					}
					if(temp.id().contains("nyhetLang")){
						
						//String rows[]=temp.html().split("<br />");
						
						sb.append(temp.html());
						sb.append("<br />");

						
						
					
						
						
//						
//					sb.append(temp.text()+"\n");	
//						sb.append("\n");
//						sb.append("<br />");
					}
					if(temp.id().contains("nyhetMetadata")){
						String s=temp.html();
						s=s.substring(s.indexOf("<br />")+7);
						s=s.substring(0, s.indexOf("<br />"));
						
						
						if(s.contains(",")){
							s=s.substring(0, s.indexOf(","));
						}

						sb.append(s+"\n");
						sb.append("\n");
						sb.append("<br />");
						sb.append("<br />");
						sb.append("<br />");



					}




				}
			}

		
	
		}
		
		
		FileWriter fw;
		try {
			Time NewsNow = new Time();
			NewsNow.setToNow();
			
			fw = new FileWriter(FilePath+"/news.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close();
			fw =new FileWriter(FilePath+"/newsTime.txt");
			bw = new BufferedWriter(fw);
			bw.write(NewsNow.toString());
			bw.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		String newsString =sb.toString();
		return newsString;
		
	}
	@Override
	protected void onPostExecute(String news) {
		// TODO: check this.exception
		// TODO: do something with the feed
		 progressDialog.dismiss();
		 callback.onTaskComplete(news);
	}
	
}