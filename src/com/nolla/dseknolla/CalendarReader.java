package com.nolla.dseknolla;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;

/**
 * @author Johan
 *
 *Not yet tested
 */
public class CalendarReader {
	private URL url;;
	private CalendarBuilder calBuilder;
	private Calendar calendar;
	//not yet tested
	public CalendarReader(String urlText){
		try {
			url=new URL(urlText);
			InputStream is= url.openStream();
			calendar=calBuilder.build(is);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
