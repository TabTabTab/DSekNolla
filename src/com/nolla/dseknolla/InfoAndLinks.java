 package com.nolla.dseknolla;

import android.os.Bundle;
import android.os.Handler;
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

public class InfoAndLinks extends Activity {

	private DrawerLayout mDrawerLayout;

	// ListView represents Navigation Drawer
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
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

String datatekniksektionen="<h1>Datatekniksektionen</h1>"+

"Datatekniksektionen är din sektion, där du är medlem. Är du inte det bör du se över ditt liv lite. Alla som börjar på Datateknik eller InfoCom blir helt automagiskt medlemmar i D-sektionen. Det kan vara lite jobbigt att förstå att det är InfoCom och Datateknik som var för sig är äkta delmängder av Datatekniksektionen men tillsammans är de helheten.<br /><br />"+

"Sektionen är en del av Teknologkåren och vi (sektionen) består av en massa funktionärer, styrelse och engagerade människor.<br />"+

"Som medlem är du väldigt välkommen att hjälpa sektionsmedlemmarna med att göra saker som är roligt, vilket kan vara att anordna LAN, sälja kakor, laga mat, dricka öl eller något annat. Alla tar så mycket ansvar de vill!<br /><br />"+

"För att sektionens ordförande skall kunna hålla koll på sina funktionärer har han delat in dem i mästerier, där varje mästeri har en mästare som tar ansvar för sina funktionärer.";


String gorapasektionen="<h1>Vad kan man göra på sektionen?</h1>"+

"<i>För att förhindra att styrelsen inte ska totalt gå in i väggen så har de ett mästeri som hjälper dem. Här följer en beskrivning av dessa.</i><br />"+

"<h2>Cafémästeriet</h2>"+

"För att se till att sektionsmedlemmarna får i sig tillärckligt med onyttigheter för att hålla sig vakna under föreläsningarna så säljer caféfunktionärerna olika typer av läsk, godis och D-bollar under lunchen i iDét. Om du (n0llan) känner att det vore kul att hjälpa till att sälja kan man prata med den personen som man ger pengarna till när man handlar.<br />"+

"<h2>Sexmästeriet</h2>"+

"När man har pluggat för länge och nått den punkt när man kan mindre än när man började kan det vara bra att ta en paus för att rensa huvudet för att hjälpa dig rensa huvudet så jobbar sexmästeriet med att anordna sittningar och pubar i iDét där det serveras alkohol i alla des former och mat. Om man jobbar i sexet står man antingen bakom baren eller i köket, beroende på hur mycket man tycker om människor.<br />"+


"<h2>Källarmästeriet</h2>"+

"För att cafét ska kunna sälja onyttiga nyttighetet och sexet ska kunna fylla sektionen med ansvar så behöver iDét fungera, och inte falla sönder. Det mästeri som tejpar ihop iDét innan det imploderar är Källarmästeriet. Saker som mästeriet ansvarar för att tejpa ihop är möbler, väggar, tak, golv, baren, datorer och mojter. Som komplement till tejp kan man också använda PL400 om man vill att saker ska sitta fast extra hårt. 3 gånger om året bjuder källarmästaren till Snickerboa där de som vill samlas för att tejpa fast saker som sitter löst.<br />"+


"<h2>Näringslivsutskottet</h2>"+

"Efter man tagit examen och blivit riktig civilingenjör är det meningen att man ska skaffa jobb och få pengar. För att det ska bli lättare att skaffa jobb och få pengar drar Näringslivsmästeriet hit företag för att prata med teknologer. Eftersom det är konstigt att prata med människor utan anledning brukar evenemangen kallas för andra saker som \"lunchföreläsningar\", \"företagspubar\" eller \"arbetsmarknadsdagar\". Under arbetsmarknadsdagarna står det jättemånga företag i D-huset och pratar med alla som går förbi. Om man pratar tillräckligt mycket med företagen kan man få saker som pennor, nyckelringar eller jobb.<br />"+

"<h2>Programmästeriet</h2>"+

"Ibland kan det vara bra att göra något annat än att pluga och phesta, tex. vara på LANparty eller åka på ölresa. För sektionens behov av fritid uppfylls ansvarar Programmästeriet. I Programmästeriet jobbar tex. pepparna för att se till så att folk har kul även om de inte tror det, och LANparty-ansvarig som anordnar Geekend 3 gånger om året då man sitter i en källare och spelar Battlefield 3, eller försöker installera Linux på en brödrost<br />"+

"<h2>Studierådet</h2>"+

"I Studierådet finns de som har förstått att det är bra att plugga, och ibland har de pluggfik i iDét för att hjälpa andra människor att plugga. De ser även till så att kurserna inte blir för svåra eller konstiga genom att skälla på föreläsare som gör fel, och ibland funkar det. I Studierådet så finner man bland annat kurskommissarien som ser till att folk svarar på sina kursutvärderingar. Det finns också jämlikhetsombud som balanserar sektionen om den blir för överviktig.<br />"+

"<h2>Propagandamästeriet</h2>"+

"Om du (n0llan), och Gamble, ska kunna gå på pubar, eller sittningar kan det vara bra om någon berättar för dig när det är. Propagandamästeriet försöker berätta det för dig genom att Artisterna ritar affischer, DWWW kodar ihop hemsidan och Propagandamästaren har ansvar. Inom Propagandamästeriet hittar man också Fotograferna, som tar bilder från phester så att någon kommer ihåg vad som faktiskt hände och Arkivarierna som håller reda på vad som hände för länge sedan.";



String vettochettikett= "<h1>Vett och Ettiquette</h1>"+

"Hejsan nollan! Efterssom ni snart kommer att ha möjligheten att gå på en hel drös med fester && tillställningar av olika slag kommer här lite information om vad som gäller under dessa för att alla ska få en så trevlig kväll som möjligt.<br /><br />"+

"Sektionens fester består av tre (3) olika typer:<br />"+
" Gasque: Gasque är ett studentikost ord för \"finsittning\" och utalas ungefär \"gask\". Hit går vi klädda i lite finare kläder (läs kostym eller motsvarande), och äter vällagad mat av det lite exklusivare slaget. Oftast finns det jättemycket underhållning planerat. Ett exempel på en gasque är nollegasquen, där nollan blir upphöjd till etta efter genomför nolleuppdrag.<br /><br />"+

"Slasque: Slasquen är tillsammans med gasquen den andra av två soters sittningar. På slasquen behöver man inte vara lika fin i kanten som på gasquen, men man ska fortfarande förhålla sig till vissa regler. Maten är oftast lite enklare än på gasquen, men är alltid god och vällagad. Slasquer kommer nollan få erfara flera gånger per år. Slasqueklädsle är oftast ouveralle, eller efter tema då sådant angivits.<br /><br />"+

"Pub: Fest av det enklare slaget. Puben har öppet och säljer både drycker av alkoholhaltig sort samt drycker av icke alkoholhaltig sort för att släcka nollans törst. Till desssa finns det alltid någon form av mat tillgänglig -många gånger i form av supergoda hamburgare. Här kan du sitta och prata med dina mednollor, phaddrar, och alla andra medlemmar i sektionen på ett lättsamt vis. Klädsle är oftast ouveralle.<br /><br />"+

"Under alla slags sittningar förekommer tal, meddelanden och s.k. gycklen. Gycklen innebär att någon eller några framför något skoj, oftast i form av en sång eller ett spex. Dessa är många gånger skrivna av de framförande för just innevarande kväll. Vare sig det är ett tal, meddelande eller gyckle gäller ALLTID att alla andra ska vara tysta. Spara allt prat till efteråt. Även viskningar kan höras, och de kan vara mycket irriterande för de som har svårt att höra föreställningen. Så visa respekt för dem som har lagt ner tid för att förbereda något kul för just Dig!<br /><br />"+

"Om det helt plötsligt dimper ner en sångbok på din plats, som du misstänker vara någon annans, betyder det att personen i fråga har skickat iväg dden på en tur genom sittningen. Då är det helt okej, och oftast så önskat, att du ska skriva en liten hälsning eller något meddelande någonstans i sångboken. Datera gärna meddelandet, då det är kul att se efter flera år på vilka sittningar man har varit. Självklart kladdar du inte över något som redan står i boken.<br /><br />"+

"Slutligen finns det en sång, vid namn \"O, gamla klang och jubeltid\", som ALLTID avslutar sittningen. Sista versen till denna sjungs stående, och därefter är det ej längre tillåtet att sätta sig till bords. Detta för att sexmästeriet nu väldigt gärna vill duka av borden, och ställa om lokalen till dansgolv. Under tiden som detta sker kan man gå en liten runda, ta lite luft, röka (om man av någon anledning sysslar med sådant), hälsa på i Edekvata, eller göra något annat - någon annanstans! Du när snart välkommen tillbaka! Och slutligare - Kom ihåg att det finns omtentor, men inga omphester! Och slutligast - Det är helt okej att sjunga \"hellre än bra\"!";






















	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info_and_links2);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerLayout.closeDrawers(); 
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// Getting reference to the ActionBarDrawerToggle
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			/** Called when drawer is closed */
			public void onDrawerClosed(View view) {
				getActionBar().setTitle("Information");
				invalidateOptionsMenu();

			}

			/** Called when a drawer is opened */
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle("Information");



				invalidateOptionsMenu();
			}

		};


		mDrawerLayout.setDrawerListener(mDrawerToggle);
		//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), 
		//				R.layout.drawer_list_item, getResources().getStringArray(R.array.menus));
		colorArrayAdapter adapter = new colorArrayAdapter(getBaseContext(), 
				getResources().getStringArray(R.array.menus),4);

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

					mDrawerLayout.closeDrawers();
					final Handler handler = new Handler();
					handler.postDelayed(new Runnable() {
						@Override
						public void run() {
							Intent intent=new Intent(InfoAndLinks.this,CalendarActivity.class);
							startActivity(intent); 
						}
					}, 250);

				}
				else if(position==1){

					mDrawerLayout.closeDrawers();
					final Handler handler = new Handler();
					handler.postDelayed(new Runnable() {
						@Override
						public void run() {
							Intent intent=new Intent(InfoAndLinks.this,NewsActivity.class);
							startActivity(intent); 
						}
					}, 250);
				}
				else if(position==2){

					mDrawerLayout.closeDrawers();
					final Handler handler = new Handler();
					handler.postDelayed(new Runnable() {
						@Override
						public void run() {
							Intent intent=new Intent(InfoAndLinks.this,MapChooser.class);
							startActivity(intent); 
						}
					}, 250);
				}
				else if(position==3){

					mDrawerLayout.closeDrawers();
					final Handler handler = new Handler();
					handler.postDelayed(new Runnable() {
						@Override
						public void run() {
							Intent intent=new Intent(InfoAndLinks.this,Ordlista.class);
							startActivity(intent); 
						}
					}, 250);
				}
				else if(position==4){

					mDrawerLayout.closeDrawers();
					final Handler handler = new Handler();
					handler.postDelayed(new Runnable() {
						@Override
						public void run() {
							Intent intent=new Intent(InfoAndLinks.this,InfoAndLinks.class);
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
    
	 	case R.id.link4:
	 		stringToShow=datatekniksektionen;
	 		title="Datatekniksektionen";
	 		break;
	 	case R.id.link5:
	 		stringToShow=gorapasektionen;
	 		title="Vad kan man göra på sektionen?";
	 		break;	
	 	case R.id.link6:
	 		stringToShow=vettochettikett;
	 		title="Vett och Etikett";
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
