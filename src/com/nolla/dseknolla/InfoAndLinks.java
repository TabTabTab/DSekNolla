 package com.nolla.dseknolla;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;

public class InfoAndLinks extends Activity {
	String title=null;
	String info="<h1>VAD ÄR NOLLNING?</h1> Nollningen är ett namn på de fem första veckorna på LTH. Den första av dessa veckor utspelar sig innan ordinarie undervisning börjar och det är här som nollningsaktiviteterna ligger som tätast. På dagarna ges nyttiga introduktionskurser i matematik och datorkunskap och på kvällarna finns det roliga fritidsaktiviteter och fester att delta i.<br /><br /> De första veckorna när man kommer till universitetet kanske man känner sig ensam, det är väldigt många studenter som börjar utan att känna en enda person i hela staden. Det är många som oroar sig över om de kommer träffa några kompisar. Det är precis detta som nollningen är till för, målet med nollningen är att studenterna ska lära känna varandra och att alla ska hitta studiekamrater. <h1>VAD ÄR EN NOLLA?</h1> En nolla är (oftast) en förstaårsstudent. Denna student tas hand om av phaddrarna som alltid ser till att nollan har det trevligt! När man är nolla får man möjligheten att bli barn på nytt och leka lekar igen, samtidigt som allvaret hopar sig i vardagen. Nolla är man fram till nollegasquen då man upphöjs till etta efter fullbordat nolleuppdrag. <h1>VAD ÄR EN PHADDER?</h1> En phadder är en äldre student som ofta springer runt i en ouveralle, och en del springer runt utan ouveralle. Phaddern vet en fruktansvärd massa saker om LTH och då speciellt hur D-sektionen och studentlivet fungerar. En phadder kan också allt som står på nollningsprogrammet, var föreläsningssalar ligger, hur man beställer pizza och vart man tar vägen om man missade sista tåget hem. De flesta phaddrarna har även gått på utbildning i ledarskap, alkoholansvar och mycket, mycket mer, så tveka inte att fråga dem något om en kris uppstår. Phaddern är till för Nollans skull.";
	String nolleuppdrag="<h2>Uppdrag</h2>"+
			"Nollan måste ha ett uppdrag för att få möjlighet att bli upphöjd till en etta! Nedan listar vi era möjligheter."+
	"<br>"+
	"<br>"+
	"<h3>Balongistapulten</h3>"+
	"För den glade artilleristen. Bygg ett projektilvapen med hög precision för att indränka de andra sketionernas Phös"+
	"<h3>Cheerleading</h3>"+
	"För den spexiga nollan som vill lovorda vår sektion i både sång och dans!"+
	"<h3>FLY-ING </h3>"+
	"FLY-Ing hålls hos ingenjörerna i Helsingborg. Det är ett nyktert arrangemang och brukar hållas på en söndag. Det går ut på att bygga en farkost som sedan ska skickas ut från en kaj i Helsingborgs hamn. (I Stockholm arrangeras varje år en Red Bull-tävling som nästintill går ut på samma sak.) Förberedelser ingår, det ska ju byggas en farkost som med hjälp av TLTH ska kunna fraktas upp till Helsingborg på tävlingsdagen. Transport till och från Helsingborg arrangeras med bussar. De nollor och phøs som är med i detta nolleuppdrag får en sittning på kvällen tillsammans med de andra sektionerna."+
	"<h3>Hinderbanan</h3>"+
	"Hinderbanan ska både springas och byggas. Nollorna kommer att behöva hjälp med tips och trix samt att bygga ett Lila/Råsa och käckt hinder. Som phøs behöver man dock inte springa en meter"+
	"<h3>Luphtbandet</h3>"+
	"Luphtbandet spexar till det och underhåller åskådarna med högklassigt mimande till musik. Som phøs uppmuntrar ni gruppen och hjälper dem till seger! "+
	"<h3>Lådbilsrallyt</h3>"+
	"Lådbilsrallyt är precis som det låter, en kamp på liv och död. Som phøs övervakar man att gruppen träffas och bygger sin bil samt ställer ut ekipaget fredagen innan Nollelördagen, den stora tävlingsdagen!"+
	"<h3>Mutlaget/Hejarklacken</h3>"+
	"Mutlaget/Hejarklacken har i uppdrag att få domarna att rösta Lila/Råsa! De ska även få Datasektionen att synas både på Nollelördagen och på Regattan! Som phøs har ni hand om införskaffning av mutmateriel och att hjälpa laget att komma på sånger och ramsor som hejar fram Datasektionen till seger! En biljett till Regattabalen för nollorna och phøsen är ett privilegium."+
	"<h3>Märkesmålning</h3>"+
	"Märkesmålningen målar vårt fina sektions-märke i märkesbacken. Som phøs ska man se till att färgen kommer till märkesbacken och även måla lite själv. Detta medan glada toner spelas i bakgrunden. "+
	"<h3>Nollespexet</h3>"+
	"Nollespexet spelar och spexar till det med allt som hänt under nollningen! Som phøs hjälper ni nollorna att samlas och skriva ihop något som får alla på nollegasquen att vika sig dubbla och ge lite Lila/Råsa skimmer över tillställningen!"+
	"<h3>Regattan</h3>"+
	"Sjøslaget där allt kan hända! Som phøs hjälper ni nollorna med att övervaka byggandet av båt och införskaffande av material som kan behövas samt få dem att komma fram till ett tema. Man samlas utanför Høgevallsbadet och tågar gemensamt upp med de andra sektionerna till sjøn Sjøn. Nollorna ska även ha fullvärdig utbildning i ølhäfv; två dagar innan arrangeras EM i ølhäfv hos Elektro som kan vara utmärkt träning. På kvällen arrangeras Regattabal där det brukar gå blött till för nollorna och phøsen."+
	"<h3>Terrorgruppen</h3>"+
	"Terrorgruppen har en mycket viktig uppgift. Lila/Råsa är lag och är det enda som ska synas över hela LTH! Alla sektionssymboler ska lysa Lila/Råsa, terrordekaler sättas upp och camping på øn Øn natten till regattan så att telefonkiosken är Lila/Råsa till Regattan! Som phøs hetsar ni nollorna att vilja måla så mycket de bara orkar! En biljett till Regattabalen för nollorna och phøsen är ett privilegium.";

	
	
	
	
String links="<h2> Länkar</h2>"+
"Här finner ni en samlig nyttiga länkar som är värt att ta en titt på."+"<br />"+"<br />"+"<br />"+
"<table>"+
	"<tr>"+
		"<td> <a href=\"http://www.afb.se/\" target=\"_blank\">AF bostäder</a></td>"+"<br />"+"<br />"+
	"</tr>"+
	"<tr>"+
		"<td> <a href=\"http://af.lu.se/\" target=\"_blank\">Akademiska Föreningen (AF)</a></td>"+"<br />"+"<br />"+
	"</tr>"+
	"<tr>"+
		"<td> <a href=\"http://www.data.lth.se/\" target=\"_blank\">Datateknik</a></td>"+"<br />"+"<br />"+
	"</tr>"+
	"<tr>"+
		"<td> <a href=\"http://www.dsek.se\" target=\"_blank\">Datatekniksektionen</a></td>"+"<br />"+"<br />"+
	"</tr>"+
	"<tr>"+
		"<td> <a href=\"http://www.dsek.se/sektionen/dchip/\" target=\"_blank\">Datatekniksektionens tjejförening - Dchip</a></td>"+"<br />"+"<br />"+
	"</tr>"+
	"<tr>"+
		"<td> <a href=\"http://www.gerdahallen.lu.se/\" target=\"_blank\">Gerdahallen</a></td>"+"<br />"+"<br />"+
	"</tr>"+
	"<tr>"+
		"<td> <a href=\"http://www.infocom.lth.se/\" target=\"_blank\">InfoCom</a></td>"+"<br />"+"<br />"+
	"</tr>"+
	"<tr>"+
		"<td> <a href=\"http://www.lth.se/\" target=\"_blank\">LTH</a></td>"+"<br />"+"<br />"+
	"</tr>"+
	"<tr>"+
		"<td> <a href=\"http://www.lu.se/\" target=\"_blank\">LU</a></td>"+"<br />"+"<br />"+
	"</tr>"+
	"<tr>"+
	"<td> <a href=\"http://studentlund.se/\" target=\"_blank\">Studentlund</a></td>"+"<br />"+"<br />"+
	"</tr>"+
	"<tr>"+
		"<td> <a href=\"http://www.tlth.se\" target=\"_blank\">Teknologkåren vid Lunds Tekniska Högskola</a></td>"+"<br />"+"<br />"+
	"</tr>"+
"</table>";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info_and_links);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info_and_links, menu);
		return true;
	}
	
	public void showInfo(View view){
		String stringToShow = null;
		switch (view.getId()) {
        case R.id.link1:
        	stringToShow=info;
        	//title="Allmän Information";
        	title="Vad är Nollning?";
            // do something
            break;
        case R.id.link2:
        	stringToShow=nolleuppdrag;
        	title="Nolleuppdrag";
            break;
        case R.id.link3:
        	stringToShow=links;
        	title="Länkar";
            break;
    }
		
		
		
		
		
		
		
		
		
		
		Intent intent=new Intent(this,InfoPane.class);
		intent.putExtra("string", stringToShow);
		intent.putExtra("title", title);
		startActivity(intent);
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
