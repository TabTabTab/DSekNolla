package com.nolla.dseknolla;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Ordlista extends Activity {

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
		setContentView(R.layout.activity_ordlista2);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerLayout.closeDrawers(); 
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// Getting reference to the ActionBarDrawerToggle
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			/** Called when drawer is closed */
			public void onDrawerClosed(View view) {
				getActionBar().setTitle("Ordlista");
				invalidateOptionsMenu();

			}

			/** Called when a drawer is opened */
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle("Ordlista");



				invalidateOptionsMenu();
			}

		};


		mDrawerLayout.setDrawerListener(mDrawerToggle);
		//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), 
		//				R.layout.drawer_list_item, getResources().getStringArray(R.array.menus));
		colorArrayAdapter adapter = new colorArrayAdapter(getBaseContext(), 
				getResources().getStringArray(R.array.menus),3);

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
							Intent intent=new Intent(Ordlista.this,CalendarActivity.class);
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
							Intent intent=new Intent(Ordlista.this,NewsActivity.class);
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
							Intent intent=new Intent(Ordlista.this,MapChooser.class);
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
							Intent intent=new Intent(Ordlista.this,Ordlista.class);
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
							Intent intent=new Intent(Ordlista.this,InfoAndLinks.class);
							startActivity(intent); 
						}
					}, 250);
				}



			}
		});   
		TextView tw=(TextView)findViewById(R.id.ordlistText);
		StringBuilder sb=new StringBuilder();

		sb.append("<h1>Nolleordlista</h1> Ordlista Under din första tid på LTH kommer du att träffa på en hel del nya begrepp. För att underlätta för dig följer här nedan en liten ordlista. <br />");
		sb.append("<h1>Ametistlila</h1>");
		sb.append("Infocoms färg. Färg på gamla och dryga C-ares ouveraller samt andra Infocomrelaterade pryttlar och pinaler. <br />");
		sb.append("<h1>bit</h1>");
		sb.append("Ett storleksmått. Efter att ha köpt en ny dator finns det bara en liten bit kvar av studiebidraget<br />");
		sb.append("<h1>Blinkmojt</h1> ");
		sb.append("En mojt som blinkar. Se Mojt. <br />");
		sb.append("<h1>Blå Soffan</h1> ");
		sb.append("Blå soffan \"the one and only\" är död. Se #Blausoffan <br />");
		sb.append("<h1>Cornelis</h1> ");
		sb.append("Café och pub i Kårhuset. <br />");
		sb.append("<h1>D-huset</h1> ");
		sb.append("Det hus på teknis där C/D/E-teknologer spenderar större delen av sin tid. Ibland skämtsamt kallat \"E-huset\". <br />");
		sb.append("<h1>D-sektionen</h1> ");
		sb.append("Din sektion! I D-Sektionen är alla som studerar InfoCom eller Datateknik automagiskt medlemmar! <br />");
		sb.append("<h1>Edekvata</h1> ");
		sb.append("E-sektionens lokal. Ligger i källaren i ED-huset, precis som iDét. Har en massa praktiska godis- och matmojter man kan utnyttja när café iDét av någon anledning råkar vara stängt. <br />");
		sb.append("<h1>ET-slasque</h1> ");
		sb.append("Röjiga fester på alla sektioner efter tentaperioder. Slutar vanligtvis på Lophtet. Det är nu man kan antingen fira hur bra tentorna gick eller dränka sina sorger. Slasque står för lite slarvigare sittning. <br />");
		sb.append("<h1>Fadder </h1>");
		sb.append("En äldre teknolog som kommer att hjälpa dig under de första veckorna. <br />");
		sb.append("<h1>Gammal och äcklig </h1> ");
		sb.append("Beteckning på sektionsfifflare som varit med för länge. <br />");
		sb.append("<h1>Gasque </h1> ");
		sb.append("En lite finare sittning. <br />");
		sb.append("<h1>Hugo</h1>  ");
		sb.append("Sektionens alldeles egna blinkmojt. <br />");
		sb.append("<h1>iDét</h1>  ");
		sb.append("Sektionens egna lokal nere i källaren i DE-huset. Fungerar som café, pub, festlokal m.m. <br />");
		sb.append("<h1>InfoCom</h1> ");
		sb.append("Civilingenjörsutbildning vid LTH. InfoCom-teknologer tillhör D-sektionen. Se ”IC”. <br />");
		sb.append("<h1>Joystick</h1>");
		sb.append("Ansluts till interfacet.<br />");
		sb.append("<h1>Kakmonstret </h1> ");
		sb.append("Maskot för Infocom. C is for cookie, that's good enough for me! <br />");
		sb.append("<h1>Kavaj </h1> ");
		sb.append("Anges det \"Klädsel: Kavaj\" för en fest betyder det inte alls kavaj som man skulle kunna tro. Istället gäller mörk kostym för herrarna. Damerna har lite mer frihet och kan exempelvis ha klänning, dräkt eller kjol. <br />");
		sb.append("<h1>Kåren </h1> ");
		sb.append("Teknologkåren. Alla studenter på LTH, drygt 7500, är medlemmar i Teknologkåren. Kårens huvudsakliga uppgift är att bevaka utbildningarna, men gör även mycket annat tex arbetar med studenternas arbetsmiljö, studiemedelsfrågor, kontakter med näringsliv, nöjen och fritidsaktiviteter. Kåren är uppdelad i elva sektioner, se \"Sektion\". <br />");
		sb.append("<h1>Kårexpen </h1>");
		sb.append("Kårens expedition finns i kårhuset och hjälper dig med terminsräkningar och studentkort. <br />");
		sb.append("<h1>Kårmé </h1> ");
		sb.append("Lunchrestaurang på andra våningen i Kårhuset. <br />");
		sb.append("<h1>Lophtet </h1> ");
		sb.append("Festlokal belägen norr om Kemicentrum tillhörande kåren. Före detta svinstall. <br />");
		sb.append("<h1>Mojt </h1> ");
		sb.append("En maskin som gör något. Se \"Blinkmojt\". <br />");
		sb.append("<h1>Nolla </h1>");
		sb.append("På LTH kallas inte de nya studenterna novischer, utan Nollor. Det hela är lite logiskt eftersom noll kommer före ett, och etta blir man ju först efter att ha genomfört sitt Nolleuppdrag. <br />");

		sb.append("<h1>Nollegasque </h1> ");
		sb.append("Den grandiosa finsittningen som markerar avslutningen på Nollningen. Det är under Nollegasquen som Nollan, kanske, upphöjs till etta. <br />");
		sb.append("<h1>Nolleuppdrag </h1>");
		sb.append("För att kunna bli upphöjd till etta på Nollegasquen måste Nollan genomföra sitt Nolleuppdrag. Uppdraget utförs i grupper om 10-20 personer och vilket uppdrag Nollan får anpassas efter Nollans kvalikationer och prestationer under första veckan.<br />");
		sb.append("<h1>Nollning </h1>");
		sb.append("Introduktionsperioden som är från det att du kommer till LTH fram till Nollegasquen. Nollningen är en intensiv tid, fylld av roligheter.<br />");
		sb.append("<h1>Mus</h1>");
		sb.append("Ansluts till interfacet.<br />");
		sb.append("<h1>Ouveralle </h1>");
		sb.append("Den ultimata Nollningsklädseln, som är bra i många lägen, även efter Nollningens slut. Den är slitstark, rymlig och ger en fin gemenskap. De olika utbildningarna har olika färg på sina ouveraller - InfoCom har ametistlila och Data har rosa.<br />");
		sb.append("<h1>Phös </h1>");
		sb.append("På andra sektioner är \"Phöset\" vad vi på D-sektionen kallar \"Staben\". På D-sektionen är alla människor som hjälper till med lekar och nolleuppdrag under nollningen phös.<br />");
		sb.append("<h1>Pöble </h1>");
		sb.append("Beror lite på sammanhanget. Oftast avses folk som inte är D-sektionsmedlemmar. Ibland avses folk som inte är funktionärer inom D-sektionen.<br />");
		sb.append("<h1>Rekursion </h1>");
		sb.append("Se Rekursion.<br />");
		sb.append("<h1>Rosa Pantern </h1>");
		sb.append("Sektionens ärorika maskot. Den coolaste av coolaste och snyggaste av snyggaste. Självklart D-sektionens maskot!<br />");
		sb.append("<h1>Råsa </h1>");
		sb.append("Sektionens färg. Färg på D-arnas ouveraller samt andra sektionsrelaterade pryttlar och pinaler. Den råsa som verkligen är råsa har av en utredning fastslagits till RGB-trippeln (F216, 8016, A116). En alternativ tolkning är Pantone 189 U eller 35,3 % svart.<br />");
		sb.append("<h1>Sektion </h1>");
		sb.append("Kåren är uppdelad i elva sektioner. En sektion omfattar studenter vid ett eller flera utbildningsprogram. Sektionerna har hand om de frågor som rör studenter på just de programmen. Din sektion heter Datatekniksektionen!<br />");
		sb.append("<h1>Sexa </h1>");
		sb.append("1. Tackfest för sexslavar och sexmästare efter sittningens/festens slut. 2. Lättare mat på bal som serveras mycket sent.<br />");
		sb.append("<h1>Shäraton </h1>");
		sb.append("Rummet i iDét där man hittar flipperspel, Sparky, soffor och dörren in till styrelserummet.<br />");
		sb.append("<h1>Slasque </h1>");
		sb.append("Mindre fin sittning/fest som med fördel besöks iförd ouveralle. Se \"ET-slasque\"<br />");
		sb.append("<h1>Slav </h1>");
		sb.append("Finns i varianterna caféslav och sexslav. Caféslaven hjälper till i caféet och får för detta godis eller annat gott. Sexslaven hjälper till att anordna fester och får för detta en sexa. Se \"sexa\".<br />");
		sb.append("<h1>Sparky</h1> ");
		sb.append("En mycket gammal arkadsspelsmaskin, innehåller tusentals gamla spelhallsklassiker. Hittas i Shäraton.<br />");
		sb.append("<h1>Staben</h1> ");
		sb.append("Vi som är ansvariga för nollningen på D-sektionen 2013.<br />");
		sb.append("<h1>SVLD </h1>");
		sb.append("Studievägledningen för D och C.<br />");
		sb.append("<h1>Sångarstriden</h1> ");
		sb.append("Ädel kamp i sång och musik mellan sektionerna. Tre moment ingår; bordsvisa, körsång samt fritt program. Inträffar den första torsdagen i november.<br />");
		sb.append("<h1>Teknolog</h1> ");
		sb.append("Student vid en teknisk högskola, exempelvis LTH.<br />");
		sb.append("<h1>Teknologmössa</h1> ");
		sb.append("På LTH bär man istället för studentmössan en vit teknologmössa med svart tofs. På tofsen sätter man sedan en liten tygring, en så kallad spegat, för varje påbörjat läsår. Varje utbildning har sin egen färg på spegaten - InfoCom har ametistlila och Data har rosa.<br />");
		sb.append("<h1>TLTH</h1>");
		sb.append("Teknologkåren vid Lunds tekniska högskola. Se \"Kåren\".<br />");
		sb.append("<h1>Trolla</h1>");
		sb.append("Då man utövar automagi, brukar förvirra pöblen.<br />");




		tw.setText(Html.fromHtml(sb.toString()));
		//	tw.setText(wordList);


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
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ordlista, menu);
		return true;
	}


	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	//	@Override
	//	public boolean onOptionsItemSelected(MenuItem item) {
	//		switch (item.getItemId()) {
	//		case android.R.id.home:
	//			// This ID represents the Home or Up button. In the case of this
	//			// activity, the Up button is shown. Use NavUtils to allow users
	//			// to navigate up one level in the application structure. For
	//			// more details, see the Navigation pattern on Android Design:
	//			//
	//			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
	//			//
	//			NavUtils.navigateUpFromSameTask(this);
	//			return true;
	//		}
	//		return super.onOptionsItemSelected(item);
	//	}
}
