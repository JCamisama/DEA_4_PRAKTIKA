import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import packpraktika1.AktoreGuztiak;
import packpraktika1.Aktorea;
import packpraktika1.IrakurketakEtaIdazketak;
import packpraktika1.Pelikula;
import packpraktika1.PelikulaGuztiak;
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

}
