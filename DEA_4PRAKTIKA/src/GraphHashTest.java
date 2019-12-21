import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import packpraktika1.AktoreGuztiak;
import packpraktika1.Aktorea;
import packpraktika1.IrakurketakEtaIdazketak;
import packpraktika1.Pelikula;
import packpraktika1.PelikulaGuztiak;
import packpraktika1.Stopwatch;
import packpraktika1.Zinematografikoa;
import packpraktika3.GraphHash;

public class GraphHashTest {

	Zinematografikoa aktore1, aktore2, peli1, peli2 = null;	
	GraphHash gHau;
	IrakurketakEtaIdazketak cHau;
	ArrayList<Zinematografikoa> erlazioak;

	@Before
	public void setUp() throws Exception {
		
		cHau		= new IrakurketakEtaIdazketak();
		aktore1 = new Aktorea("Santa Claus");		
		peli1 = new Pelikula("Popiloluta");
		
	}

	@After
	public void tearDown() throws Exception {
		
		gHau.erreseteatuFrogetan();
		aktore1 = null;		
		peli1 = null;
		erlazioak = null;
			
	}

	@Test
	public void testPageRankPartekatutakoFitxategiarekin() {
		
		
		
		gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******PageRank-en kalkulua klasean konpartitutako fitxategiarekin*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/probakPageRank.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 
		 //Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		 
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 //gHau.grafoaInprimatu();
		 
		 gHau.pageRank();
		 
		 gHau.erreseteatuFrogetan();
		
	}
	
	
	
	@Test
	public void testPageRankKonektatutaFitxategiarekin() {
		
		
		
		gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******PageRank-en kalkulua Konektatuta Fitxategiarekin******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/Konektatuta.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 
		 //Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		 
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 //gHau.grafoaInprimatu();
		 
		 gHau.pageRank();
		 
		 gHau.erreseteatuFrogetan();
		
	}
	
	
	
	@Test
	public void testFilmsActors20162017Fitxategiarekin() {
		
		
		
		gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******PageRank-en kalkulua Konektatuta Fitxategiarekin******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/FilmsActors20162017.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 
		 //Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		 
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 //gHau.grafoaInprimatu();
		 
		 gHau.pageRank();
		 
		 gHau.erreseteatuFrogetan();
		
	}
	
	@Test
	public void testBilatzaileaPartekatutakoFitxategiarekin() {
		
		
		gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******1. Aktorerik eta pelikularik ez*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/probakPageRank.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 
		 //Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		 
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 //gHau.grafoaInprimatu();
		 
		 gHau.pageRank();
		 
		 
		 
		 //1. Bilatzailean sartutako elementua null izatea (null)
		 System.out.println("\n\n\n");
		 System.out.println("\t\t\t*******1. Bilatzailean sartutako elementua null izatea (null)*******\n");
		 ArrayList<Zinematografikoa> emaitza1 =  gHau.bilatzailea(null);
		 assertNull(emaitza1);
		 System.out.println("Null bueltatu du.");
	
		 
		 
		 
		 //2. Bilatzailean sartutako elementua grafoan ez dago (null eta errore mezua)
		 System.out.println("\n\n\n");
		 System.out.println("\t\t\t*******2. Bilatzailean sartutako elementua grafoan ez dago (null eta errore mezua)*******\n");
		 
		 Zinematografikoa ezDagoena = new Aktorea("Ez nago, Zerrendan");
		 ArrayList<Zinematografikoa> emaitza2 =  gHau.bilatzailea(ezDagoena);
		 assertNull(emaitza2);
		 System.out.println("Null bueltatu du.");
		 
		 
		 
		 //3. Bilatzailean sartutako elementua grafoan dago eta auzokide bakarra dauka (Pitt).
		 System.out.println("\n\n\n");
		 System.out.println("\t\t\t*******3. Bilatzailean sartutako elementua grafoan dago eta auzokide bakarra dauka (Pitt)*******\n");
		 
		 Zinematografikoa troya = PelikulaGuztiak.getNirePelikulak().pelikulaBilatu("Troya");
		 ArrayList<Zinematografikoa> emaitza3 =  gHau.bilatzailea(troya);
		 assertNotNull(emaitza3);//elementu bakarra pantailaratuko da (Pitt)
		 
		 
		 
		 /*4. Bilatzailean sartutako elementua grafoan dago eta bi auzokide ditu.
		  	  Zerrenda handienetik txikienera ordenatuta egongo da.*/
		 System.out.println("\n\n\n");
		 System.out.println("\t\t\t*******4. Bilatzailean sartutako elementua grafoan dago eta bi auzokide ditu. *******\n");
		 System.out.println("Zerrenda handienetik txikienera ordenatuta egongo da.");
		 Zinematografikoa waltz = AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Waltz");
		 ArrayList<Zinematografikoa> emaitza4 =  gHau.bilatzailea(waltz);
		 assertNotNull(emaitza4);
		 assertTrue(gHau.ordenatutaDago(emaitza4));
		 
		 
		 
		 
		 
		 /*5. Bilatzailean sartutako elementua grafoan dago eta auzokide anitz ditu.
	  	      Zerrenda handienetik txikienera ordenatuta egongo da.*/
		 System.out.println("\n\n\n");
		 System.out.println("\t\t\t*******4. Bilatzailean sartutako elementua grafoan dago eta bi auzokide ditu. *******\n");
		 System.out.println("Zerrenda handienetik txikienera ordenatuta egongo da.");
		 Zinematografikoa pitt = AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Pitt");
		 ArrayList<Zinematografikoa> emaitza5 =  gHau.bilatzailea(pitt);
		 assertNotNull(emaitza5);
		 assertTrue(gHau.ordenatutaDago(emaitza5));
		 
		
	}
	

	@Test
	
	public void testBilatzailea20162017Fitxategiarekin(){

		 gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******Probak Fitxategi Nagusiarekin (Empirikoak): Bilatzailea*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki("Fitxategiak/FilmsActors20162017.txt");
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 
		 //Irakurritako aktore eta pelikula kopuruak adierazten
		 System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		 System.out.println("\nPelikula kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
		 
		 
		//Grafoa sortzen eta nodo kopurua zehazten
		 gHau.grafoaSortu(AktoreGuztiak.getNireAktoreak(), PelikulaGuztiak.getNirePelikulak());
		 System.out.println("\nGrafoaren nodo kopurua: " + gHau.size()+"\n\n\n\n");
		 
		 gHau.pageRank(); //Grafoaren elementu guztiei pageRank-ak esleituko zaizkie
		 
		 
		 //Elememtuen Arraya sortzen auzazko zenbakiekien lan egin ahal izateko
		 Zinematografikoa[] grafokoElemGuztiak = gHau.elementuenArrayaLortu();
		 
		 Random ausazkoak = new Random();
		 
		 //Behin eta berriro elementuak sartzeko erabiliko diren erakusleak
		 Zinematografikoa zine1  = null;
		 int 			  a		 = 0;
		 int			  b		 = 0;
		 int			  probak = 25;
		 
		 //Batez-besteko denbora, maximoa eta minimoa
		 double hartuta = 0.00;
		 double minimoa = 0.00;
		 double maximoa = 0.00;
		 double akumula = 0.00;
		 double batazbe = 0.00;
		 
		 ArrayList<Zinematografikoa> erantz = null;
		 
		 for (int i = 0; i < probak; i++){
			 
			 //Auzazko zenbakiak hartzen
			 a = ausazkoak.nextInt(grafokoElemGuztiak.length); // 0-tik (luzera-1)-rainoko zenbakiak
		
			 //Ausazko elementuak hartzen grafotik
			 zine1 = grafokoElemGuztiak[a];
	
		
			 
			 //konektatuta metodoaren exekuzio denbora aztertzen
			 System.out.println("\n"+i +". Bilatzailea froga empirikoa: "+zine1.getIzena()+"-ren zerrenda "
			 		+ "ordenatua pageRank-en arabera: ");
			 Stopwatch kronometroa = new Stopwatch();
			 erantz = gHau.bilatzailea(zine1);
			 hartuta = kronometroa.elapsedTime();
			 assertTrue(gHau.ordenatutaDago(erantz)); //Ordenatuta dagoela konprobatzeko
			 
			 System.out.println("\n\nTardatutako denbora: "+hartuta+" segundu.\n");
			 
			 if( hartuta > maximoa ){
				 
				 maximoa = hartuta;
			 }
			 
			 else if( hartuta < minimoa ){
				 
				 minimoa = hartuta;
			 }
			 
			 akumula = akumula + hartuta;	 
			
			 
	
		 }
		 
		 batazbe = akumula/probak;
		 System.out.println("\nBatezbesteko denbora: "+batazbe+" segundu.\n");
		 System.out.println("\nDenbora maximoa: "+maximoa+" segundu.\n");
		 System.out.println("\nDenbora minimoa: "+minimoa+" segundu.\n\n");
				
			 
			 gHau.erreseteatuFrogetan();
	
	}
	
	

	

}
