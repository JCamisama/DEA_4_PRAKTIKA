package packpraktika1;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import packpraktika3.*;

public class AktoreGuztiak {
	
	private static AktoreGuztiak nireAktoreak;
	private HashMap<String, Aktorea> zerrenda; //HashMap zuzenean inplementatu da klase honetan, beste klaserik ez duelako erabiliko.
	
	private AktoreGuztiak(){
		
		this.zerrenda = new HashMap<String, Aktorea>();// HashMap<Giltza, ZerGorde>()
	}
	
	public static synchronized AktoreGuztiak getNireAktoreak(){
		
		if( nireAktoreak == null){
			
			nireAktoreak = new AktoreGuztiak();	
		}
		
		return nireAktoreak;
	}
	
	

	public void gehituAktorea(Aktorea pAktore){
		
		//Aurre-Baldintza:	pAktorea ez da Null izango.
		//Post-Baldinta: 	Zerrenda badago dagoeneko, ez da gehituko, bestela bai.
		//Kostua:			O(1);	
		
		if(!this.zerrenda.containsKey( pAktore.getIzena() ) ){
			
			this.zerrenda.put(pAktore.getIzena(), pAktore);
		}
		

	}
	
	
	
	public static void idatziAktoreGuztiak(PrintWriter pOutputStream){
		
		//Aurre-Baldintza:	------------------------------------------
		//Post-Baldinta: 	Aktoreen zerrenda pOutputStream-ean idatzita agertuko dira.
		//Kostua:			O(2n) ---> O(n);	
		
		pOutputStream.println("\t\t***AKTOREEN ZERRENDA***\n\n");
		
		Iterator<Aktorea> itr		= AktoreGuztiak.getNireAktoreak().getAktoreenIteradorea(); //Aktoreen zerrenda bat sortzen
		Aktorea			  aktoreHau	= null;
		
		while( itr.hasNext() ){
			
			aktoreHau	= itr.next();
			aktoreHau.idatziAktorearenIzena(pOutputStream);
			aktoreHau.inprimatuAktorea();
			
		}
		
		
	}
	
	private Iterator<Aktorea> getAktoreenIteradorea(){
		
		//Aurre-Baldintza:	------------------------------------------
		//Post-Baldinta: 	Aktoreen bilduma bat bueltatuko du, Iterator interfaz bezala.
		//Kostua:			O(n);
		
		return this.zerrenda.values().iterator(); //HashMap-eko aktore guztiak zerrenda batean kokaturik egongo dira.
	}
	
	
	public Aktorea aktoreaBilatu(String pIzena){
	
		//Aurre-Baldintza:	------------------------------------------
		//Post-Baldinta: 	Aktorea zerrendan badago, objektua bueltatuko du, bestela null.
		//Kostua:			O(1)
		
		Aktorea aktoreHau = null;
		
		aktoreHau = this.zerrenda.get(pIzena);
		
		
		return aktoreHau;
		
	}
	
	public ListaAktoreak zerrendaOrdenatuaBueltatu(){
		
		//Aurre-Baldintza:	------------------------------------------
		//Post-Baldinta: 	Aktore guztien zerrenda ordenatua bueltatuko da.
		//Kostua:			O(n + n*logn); non n aktore kopurua den.
		
		ListaAktoreak	  zerreHau	= new ListaAktoreak();
		Iterator<Aktorea> itr		= AktoreGuztiak.getNireAktoreak().getAktoreenIteradorea(); //Aktoreen zerrenda bat sortzen
		
		//Zerrenda betetzen
		while( itr.hasNext() ){
			
			zerreHau.aktoreaKargatu(itr.next());
		}
		
		//Zerrenda ordenatzen
		zerreHau.elkartuOrdenatu();
		
		return zerreHau;
		
	}

	public Aktorea ezabatuAktoreenErregistrotik(String pIzena){
		
		//Aurre-Baldintza:	------------------------------------------
		//Post-Baldinta: 	Ezabatutako aktorea bueltatuko da zerrendan badago, bestela null.
		//Kostua:			O(1);		
		
		return this.zerrenda.remove(pIzena);
	}

	public int luzera(){ //Frogak egiteko inplementatuta bakarrik.
		
		return this.zerrenda.size();
	}
	
	public void erreseteatu(){ //Frogak egiteko inplementatuta bakarrik.
		
		AktoreGuztiak.nireAktoreak = null;
	}
	
	
	
	//*****************************************GRAFOA SORTZEN******************************************************//
	public void grafoaOsatu(){
		
		GraphHash grafoHau = GraphHash.getNireGrafoa();
		
		//Aurre-baldintza:	---
		//Post-baldinta:	Grafo nagusia aktoreen izenekin eta pelikulen zerrendekin osatuko da.
		//Kostua: O(n)
		
		Iterator<Aktorea> itr		= AktoreGuztiak.getNireAktoreak().getAktoreenIteradorea(); //Aktoreen zerrenda bat sortzen
		Aktorea aktoreHau 			= null;
		
		//Grafoaren elementuen zerrenda egiteko beharko den ArrayList-a
		ArrayList<Zinematografikoa> peliZerre	=	new ArrayList<Zinematografikoa>();
		
		//Grafoa betetzen
		while( itr.hasNext() ){
			
			aktoreHau = itr.next();
			peliZerre = aktoreHau.aktorearenPelikulakBueltatu().grafokoZerrendaSortu();
			grafoHau.gehitu(aktoreHau, peliZerre);	
		}
		
	}
	
	/****************************************batazBestekorako Pelikulak*********************************************/
	
	public int batazbestekoPelikulak() {
		
		int emaitza = 0;
		int gehiketa = 0;
		
		Iterator<Aktorea> itr		= AktoreGuztiak.getNireAktoreak().getAktoreenIteradorea(); //Aktoreen zerrenda bat sortzen
		Aktorea			  aktoreHau	= null;
		
		while (itr.hasNext()) {
			
			aktoreHau = itr.next();
			gehiketa = gehiketa + aktoreHau.pelikulenListarenLuzeera();
			
		}
		
		emaitza = gehiketa / this.luzera();
		
		return emaitza;
		
	}
	
	
	
}
