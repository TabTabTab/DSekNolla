package com.nolla.dseknolla;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.text.Html;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Ordlista extends Activity {
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
		setContentView(R.layout.activity_ordlista);
		setupActionBar();
		TextView tw=(TextView)findViewById(R.id.ordlistText);
StringBuilder sb=new StringBuilder();

sb.append("<h1>Nolleordlista</h1> Ordlista Under din första tid på LTH kommer du att träffa på en hel del nya begrepp. För att underlätta för dig följer här nedan en liten ordlista. <br />");
sb.append("<h1>Ametistlila</h1>");
sb.append("Infocoms färg. Färg på C-arnas ouveraller samt andra Infocomrelaterade pryttlar och pinaler. <br />");
sb.append("<h1>Blinkmojt</h1> ");
sb.append("En mojt som blinkar. Se Mojt. <br />");
sb.append("<h1>Blixt Gordon</h1> ");
sb.append("Namn på funktionärspost som innehavs av personen som ansvarar för sektionens ljud- och ljusutrustning. <br />");
sb.append("<h1>Blå Soffan</h1> ");
sb.append("Blå soffan \"the one and only\" är död. Se #Blausoffan <br />");
sb.append("<h1>Cornelis</h1> ");
sb.append("Café och pub i Kårhuset. <br />");
sb.append("<h1>D-huset</h1> ");
sb.append("Det hus på teknis där C/D/E-teknologer spenderar större delen av sin tid. Ibland skämtsamt kallat \"E-huset\". <br />");
sb.append("<h1>D-sektionen</h1> ");
sb.append("Datatekniksektionen, sektionen för studenter på Datateknik och Infocom. Din sektion! <br />");
sb.append("<h1>D´du </h1> ");
sb.append("Sektionens informationsblad. Ges ut en gång i veckan och sätts upp på anslagstavlorna. <br />");
sb.append("<h1>DF </h1> ");
sb.append("Datorföreningen vid LU & LTH. <br />");
sb.append("<h1>Edekvata</h1> ");
sb.append("E-sektionens lokal. Ligger i källaren i ED-huset, precis som iDét. Har en massa praktiska godis- och matmojter man kan utnyttja när café iDét av någon anledning råkar vara stängt. <br />");
sb.append("<h1>ET-slasque</h1> ");
sb.append("Röjiga fester på alla sektioner efter tentaperioder. Slutar vanligtvis på Lophtet. Det är nu man kan antingen fira hur bra tentorna gick eller dränka sina sorger. Slasque står för lite slarvigare sittning. <br />");
sb.append("<h1>Fadder </h1>");
sb.append("En äldre teknolog som kommer att hjälpa dig under de första veckorna. <br />");
sb.append("<h1>Gammal och äcklig </h1> ");
sb.append("Beteckning på sektionsfifflare som varit med för länge. <br />");
sb.append("<h1>Gasque < <br />h1> ");
sb.append("En lite finare sittning. <br />");
sb.append("<h1>Gerd Olsson </h1> ");
sb.append("Person som är ansvarig för driften av sektionens datorer. <br />");
sb.append("<h1>Hugo [y´gå]</h1>  ");
sb.append("Världens enda Internetuppkopplade blinkmojt. Se ”blinkmojt”. <br />");
sb.append("<h1>IC </h1> ");
sb.append("Intresseföreningen för alla InfoCom-studenter. <br />");
sb.append("<h1>iDét</h1>  ");
sb.append("Sektionens egna lokal nere i källaren i DE-huset. Fungerar som café, pub, festlokal m.m. <br />");
sb.append("<h1>InfoCom</h1> ");
sb.append("Civilingenjörsutbildning vid LTH. InfoCom-teknologer tillhör D-sektionen. Se ”IC”. <br />");
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
sb.append("<h1>Litet ORDO </h1> ");
sb.append("Kårens veckoblad. Innehåller information om vad som händer på kåren. <br />");
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
sb.append("<h1>Ouveralle </h1>");
sb.append("Den ultimata Nollningsklädseln, som är bra i många lägen, även efter Nollningens slut. Den är slitstark, rymlig och ger en fin gemenskap. De olika utbildningarna har olika färg på sina ouveraller - InfoCom har ametistlila och Data har rosa.<br />");
sb.append("<h1>Phös </h1>");
sb.append("På andra sektioner är \"Phöset\" vad vi på D-sektionen kallar \"Staben\". På D-sektionen är alla människor som hjälper till med lekar och nolleuppdrag under nollningen phös.<br />");
sb.append("<h1>Pålsjö ängsblad </h1>");
sb.append("Kårens tidning. Skickas hem till alla som är medlemmar i TLTH.<br />");
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
sb.append("Vi som är ansvariga för nollningen på D-sektionen 2006.<br />");
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
sb.append("<h1>Uppropsdagen</h1> ");
sb.append("Dagen och kvällen är fylld med aktiviteter och det finns inte mycket tid till att göra något annat. Planera inte in något annat denna dag. Efter upprop och faddergruppsindelning kommer det att serveras en enkel lunch. Eftersom ni är väldigt många så kan inte alla serveras samtidigt, börja därför dagen med en stadig frukost. Under dagen blir det fotografering av faddergruppen, rundvandring och lära känna-aktiviteter.<br />");
sb.append("<h1>VB-fack</h1> ");
sb.append("Varje LTH-student har sitt eget veckobladsfack. I detta fack levereras mycket viktig information, och en del mindre viktig information. Bör tömmas ofta. <br />");
		
		
		tw.setText(Html.fromHtml(sb.toString()));
	//	tw.setText(wordList);
		
		
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
}
