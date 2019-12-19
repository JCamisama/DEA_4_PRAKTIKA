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
	public void testPageRank() {
		
		
		
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
		 
		 gHau.erreseteatuFrogetan();
		
	}
	
	
	@Test
	public void testBilatzailea() {
		
		
		gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******1. Aktorerik eta pelikularik ez*******\n");
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
		 
		 Aktorea aktoreHau = AktoreGuztiak.getNireAktoreak().aktoreaBilatu("Bale, Christian");
		 
		 gHau.bilatzailea(aktoreHau);
		
		
	}
	
	/*
	@Test
	
	public void testErlazionatutaExperimentala(){

		 gHau = GraphHash.getNireGrafoa();
		 
		 System.out.println("\t\t\t*******Probak Fitxategi Nagusiarekin (Empirikoak): ERLAZIONATUTA*******\n");
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
		 //gHau.grafoaInprimatu();
		 
		 
		 //Elememtuen Arraya sortzen auzazko zenbakiekien lan egin ahal izateko
		 Zinematografikoa[] grafokoElemGuztiak = gHau.elementuenArrayaLortu();
		 
		 Random ausazkoak = new Random();
		 
		 //Behin eta berriro elementuak sartzeko erabiliko diren erakusleak
		 Zinematografikoa zine1  = null;
		 Zinematografikoa zine2  = null;
		 int 			  a		 = 0;
		 int			  b		 = 0;
		 int			  probak = 1000;
		 
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
			 b = ausazkoak.nextInt(grafokoElemGuztiak.length); // 0-tik (luzera-1)-rainoko zenbakiak
		
			 //Ausazko elementuak hartzen grafotik
			 zine1 = grafokoElemGuztiak[a];
			 zine2 = grafokoElemGuztiak[b];
			 
			 if( !zine1.equals(zine2) ){ //Aurrebaldintza: ez da elementu berbera sartuko metodoan
			 
				 //konektatuta metodoaren exekuzio denbora aztertzen
				 System.out.println("\n"+i +". Erlazionatuta froga empirikoa: "+zine1.getIzena()+"-en eta "+zine2.getIzena()+
						 "-en arteko erlazioa:  ");
				 Stopwatch kronometroa = new Stopwatch();
				 erantz = gHau.erlazionatuta(zine1, zine2);
				 hartuta = kronometroa.elapsedTime();
				 //System.out.println(erantz);
				 
				 //Zerrenda inprimatzen
				 Iterator<Zinematografikoa> itr = erantz.iterator();
				 System.out.print("Zerrenda: ");
				 
				 while (itr.hasNext()){
					 
					 System.out.print("<"+itr.next().getIzena()+">; ");
				 }
				 
				 System.out.println("\n\nTardatutako denbora: "+hartuta+" segundu.\n");
				 
				 if( hartuta > maximoa ){
					 
					 maximoa = hartuta;
				 }
				 
				 else if( hartuta < minimoa ){
					 
					 minimoa = hartuta;
				 }
				 
				 akumula = akumula + hartuta;	 
			 }
			 
			 else{
				 
				 System.out.println("\nElementu berbera ez da sartuko konektatuta metodoan.\n");
			 }
			 
		 }
		 
		 batazbe = akumula/probak;
		 System.out.println("\nBatezbesteko denbora: "+batazbe+" segundu.\n");
		 System.out.println("\nDenbora maximoa: "+maximoa+" segundu.\n");
		 System.out.println("\nDenbora minimoa: "+minimoa+" segundu.\n");
				
			 
			 gHau.erreseteatuFrogetan();
	
	}
	
	
	
	*/
	

}
