package packpraktika1;

import java.util.ArrayList;
import java.util.Iterator;

import packpraktika3.GraphHash;

public class PelikulaGuztiak {
	
	private static PelikulaGuztiak nirePelikulak;
	private ListaPelikulak zerrenda;
	
	private PelikulaGuztiak(){
			
			this.zerrenda = new ListaPelikulak();
		}
	public static synchronized PelikulaGuztiak getNirePelikulak(){
			
		if(PelikulaGuztiak.nirePelikulak == null){
			
			PelikulaGuztiak.nirePelikulak = new PelikulaGuztiak();
		}
		
		return PelikulaGuztiak.nirePelikulak;
	}
	
	
	
	
	public Pelikula pelikulaBilatu(String pPelikulaIzena){//METODO BERRIA, JUNIT BEHAR DU
		
		
		return this.zerrenda.pelikulaBilatu(pPelikulaIzena);
	}

	
	
	
 	public void gehituPelikula(Pelikula pFilma){
		
		//Aurre-Baldintza:	----------------------------------------------------------
		//Post-Baldinta: 	Pelikula ez bada null eta ez badago zerrendan, gehituko da.
		//Kostua:			O(m); Non m pelikulen kopurua da.
		
		this.zerrenda.gehituPelikula(pFilma);
	}
	
	public void ezabatuFilma(Pelikula pFilma){
		
		//Aurre-Baldintza:	----------------------------------------------------------
		//Post-Baldinta: 	Pelikula ez bada null eta pelikulen zerrendan  badago, zerrendatik ezabatuko da.
		//Kostua:			O(m); Non m pelikulen kopurua da.
		
		this.zerrenda.ezabatuFilma(pFilma);
	}
	
	public void inprimatuGuztiak(){//Frogak egiteko programatu da bakarrik, ez da memorian idatzi behar
		
		this.zerrenda.inprimatuGuztiak();
	}

	
	public void pelikulaKargatu(Pelikula pPelikula){//Pelikula zerrendan sartzeko errepikapena konprobatu gabe.
		
		this.zerrenda.pelikulaKargatu(pPelikula);
	}
	
	public int luzera(){ //Frogak egiteko programatu da bakarrik, ez da memorian idatzi behar
		
		return this.zerrenda.luzera();
	}
	
	public void erreseteatu(){ //Frogak egiteko programatu da bakarrik, ez da memorian idatzi behar
		
		PelikulaGuztiak.nirePelikulak = null;
	}
	
	
	public int batazbestekoAktoreak (){
		int emaitza=0;
		int gehiketa=0;
		ArrayList<Zinematografikoa> pelikulak = this.zerrenda.grafokoZerrendaSortu();
		Iterator<Zinematografikoa> itr = pelikulak.iterator();
		Pelikula peliHau = null;
		while (itr.hasNext()){
			peliHau = (Pelikula)itr.next();
			gehiketa = gehiketa + peliHau.aktoreenLuzeera();	
		}
		
		emaitza = gehiketa/this.zerrenda.luzera();
		
		return emaitza;
	}
	
	
	//*****************************************GRAFOA SORTZEN******************************************************//
	public void grafoaOsatu(){
		
		GraphHash grafoHau = GraphHash.getNireGrafoa();
		
		//Aurre-baldintza:	---
		//Post-baldinta:	Grafo nagusia pelikulen izenekin eta aktoreen zerrendekin osatuko da.
		//Kostua: O(n)
		
		ArrayList<Zinematografikoa> pelikulak = this.zerrenda.grafokoZerrendaSortu();
		Iterator<Zinematografikoa>	itr		  = pelikulak.iterator(); //Pelikuleen zerrenda bat sortzen
		Pelikula					peliHau   = null;
		
		//Grafoaren elementuen zerrenda egiteko beharko den ArrayList-a
		ArrayList<Zinematografikoa> aktoreZerre	=	new ArrayList<Zinematografikoa>();
		
		//Grafoa betetzen
		while( itr.hasNext() ){
			
			peliHau  = (Pelikula) itr.next();
			aktoreZerre = peliHau.pelikularenAktoreakBueltatu().grafokoZerrendaSortu();
			grafoHau.gehitu(peliHau, aktoreZerre);	
		}	
	}
}
