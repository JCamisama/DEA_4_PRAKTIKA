package packpraktika1;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaAktoreak {
	
	private ArrayList<Aktorea> zerrenda;
	
	public ListaAktoreak(){
		
		this.zerrenda = new ArrayList<Aktorea>();
	}
	

	private Iterator<Aktorea> getIteradorea(){
		
		//Aurre-Baldintza:	------------------------------------------
		//Post-Baldinta: 	Aktoreen bilduma bat bueltatuko du, Iterator interfaz bezala.
		//Kostua:			O(n);
		
		return this.zerrenda.iterator();
	}
	
	

	public void inprimatuAktoreak(){
		
		Iterator<Aktorea>	itr			= this.getIteradorea();
		Aktorea				aktoreHau	= null;
		
		while( itr.hasNext() ){
			
			aktoreHau = itr.next();
			aktoreHau.inprimatuAktorea();
		}
	}

	public void idatziAktoreGuztiak(PrintWriter pOutputStream){
		
		//Aurre-Baldintza:	Fitxategiaren kokapena/helburua  egokia da (pOutputStream).
		/*Post-Baldinta: 	Aktoreen zerrenda bere baitan daukan fitxategia sortuko da ez bada existitzen, 
							bestela horren gainean idatziko da. */
		//Kostua:			O(n); Non n aktore kopurua da.
		
		Iterator<Aktorea> itr		= this.getIteradorea();
		Aktorea			  aktoreHau = null;
		
		while(itr.hasNext() ){
			
			aktoreHau = itr.next();
			aktoreHau.idatziAktorearenIzena(pOutputStream);
		}
		
	}
	
	public int luzera(){
		
		//Aurre-Baldintza:	-----------------------------------
		//Post-Baldinta: 	Zerrendaren luzera bueltatuko da.
		//Kostua:			O(n); Non n aktore kopurua da.
		
		return this.zerrenda.size();
	}
	
	public void elkartuOrdenatu(){
		
		//Aurre-Baldintza:	-----------------------------------
		//Post-Baldinta: 	Zerrenda alfabetikoki ordenatuta bueltatuko da (A-tik Z-ra)
		//Kostua:			O( n*log(n) ); Non n aktore kopurua da.
		
		this.elkartuOrdenatu(this.zerrenda, 0, this.zerrenda.size()-1);
		
	}
	
	private void elkartuOrdenatu(ArrayList<Aktorea> pAktoreak, int pHasiera, int pAmaiera){

		//Aurre-Baldintza:	pHasiera eta pAmaiera zerrendaren luzera baino txikiagoak izango dira.
		//Post-Baldinta: 	Zerrenda alfabetikoki ordenatuta bueltatuko da (A-tik Z-ra).
		//Kostua:			O( n*log(n) ); Non n aktore kopurua da.
		
		
		if(pHasiera < pAmaiera){
			
			this.elkartuOrdenatu( pAktoreak, pHasiera, ((pHasiera +pAmaiera)/2));
			this.elkartuOrdenatu( pAktoreak, ((pHasiera +pAmaiera)/2) +1, pAmaiera );
			this.bateratu(pAktoreak, pHasiera, ((pHasiera +pAmaiera)/2), pAmaiera);
		
		}
		
	}
	
	private  void bateratu(ArrayList<Aktorea> pAktoreak, int pHasiera, int pErdikoa, int pAmaiera){
		
		//Aurre-Baldintza:	pHasiera, pErdikoa eta pAmaiera zerrendaren luzera baino txikiagoak izango dira.
		//Post-Baldinta: 	Zerrenda alfabetikoki ordenatuta bueltatuko da (A-tik Z-ra).
		//Kostua:			O(n); Non n aktore kopurua da.
		
		ArrayList<Aktorea>	bateratua	= new ArrayList<Aktorea>(pAmaiera-pHasiera+1);
		int					ezker		= pHasiera;
		int					eskuin		= pErdikoa + 1;
		Aktorea				ezkerAktore	= null;
		Aktorea				eskuAktore	= null;
		
		while( ezker <= pErdikoa && eskuin <= pAmaiera){
			
			
			ezkerAktore = pAktoreak.get(ezker);
			eskuAktore	= pAktoreak.get(eskuin);
			 
			if( ezkerAktore.lehenagoDoa(eskuAktore)){
				
				bateratua.add(ezkerAktore);
				ezker++;
			}
			
			else{
				
				bateratua.add(eskuAktore);
				eskuin++;
			}	
		}
		
		if( ezker > pErdikoa ){

			while( eskuin <= pAmaiera ){
				
				eskuAktore	= pAktoreak.get(eskuin);
				bateratua.add(eskuAktore);
				eskuin++;
			}			
		}
		
		else{
			
			while( ezker <= pErdikoa ){
				
				ezkerAktore = pAktoreak.get(ezker);
				bateratua.add(ezkerAktore);
				ezker++;
			}
		}
		
		for(int i = pHasiera; i <= pAmaiera; i++){
			
			this.zerrenda.set(i, bateratua.get(i-pHasiera));
		}
		
	}
	
	public boolean badagoAktorea(String pIzena){
		
		//Aurre-Baldintza:	Letra larrien eta xeheen artean desberdinduko da.
		//Post-Baldinta: 	Zerrenda alfabetikoki ordenatuta bueltatuko da (A-tik Z-ra).
		//Kostua:			O(n); Non n aktore kopurua da.
		
		Iterator<Aktorea> 	itr			=	this.getIteradorea();
		Aktorea				aktoreHau	=	null;
		boolean				badago		=	false;
		
		while(!badago && itr.hasNext()){
			
			aktoreHau	=	itr.next();
			badago		=	(pIzena == aktoreHau.getIzena());
		}
			
		return badago;	
		
	}
	
	public void ezabatuAktorea(Aktorea pAktore){
		
		//Aurre-Baldintza:	----------------------------------------------------------
		//Post-Baldinta: 	Aktorea ez bada null eta aktoreen zerrenda  badago, zerrendatik ezabatuko da.
		//Kostua:			O(n); Non n aktore kopurua da.
		
		if( pAktore != null && this.badagoAktorea(pAktore.getIzena()) ){
			
			this.zerrenda.remove(pAktore);
		}
	}
	
	
	public void gehituAktorea(Aktorea pAktore){

		//Aurre-Baldintza:	----------------------------------------------------------
		//Post-Baldinta: 	Aktorea ez bada null eta ez badago zerrendan, gehituko da.
		//Kostua:			O(n); Non n aktore kopurua da.
		
		if( !this.badagoAktorea(pAktore.getIzena()) ){
			
			this.zerrenda.add(pAktore);
		}
	}
	
	
	
	public Aktorea aktoreaBilatu(Aktorea pAktore) {
		
		//Aurre-Baldintza:	----------------------------------------------------------
		//Post-Baldinta: 	Aktorea bueltatuko da zerrendan badago, bestela null.
		//Kostua:			O(n); Non n aktore kopurua da.
		
		Iterator<Aktorea>	itr				= this.getIteradorea();
		Aktorea				egungoAktorea	= null;
		boolean				topatua			= false;
		
		while( itr.hasNext() && !topatua ){
			
			egungoAktorea = itr.next();
			
			if (egungoAktorea.bilatzekoAktorea(pAktore)) {
				
				topatua = true;	
				System.out.println("Zure aktorea listan dago");								
			}			
		}
		
		if (!topatua) {
			
			System.out.println("Zure aktorea ez dago listan");
			egungoAktorea	= null;
		}
		
		return egungoAktorea;
		
	}
	
	
	public boolean ordenatutaDago(){
		
		boolean				ordenatua 		= true;
		Aktorea				aktoreEzker		= null;
		Aktorea				aktoreEskuin	= null;
		int					posizioa		= 1; //Eskuineko aktoretik hasiko da
		
		while( ordenatua && posizioa < this.luzera() ){
			
			aktoreEzker  = this.zerrenda.get(posizioa-1);
			aktoreEskuin = this.zerrenda.get(posizioa);
			
			ordenatua = aktoreEzker.lehenagoDoa(aktoreEskuin);
			
			posizioa++;
			
		}
		
		return ordenatua;
		
	}
	
	public void aktoreaKargatu(Aktorea pAktoreHau){//Aktoreak hashmapetatik hartzeko, badagoen konprobatu gabe
		
		this.zerrenda.add(pAktoreHau);
	}
	
	
	
	
	//*************************************************GRAFOA***********************************************//	
	public ArrayList<Zinematografikoa> grafokoZerrendaSortu(){
		
		ArrayList<Zinematografikoa> graforakoZerre	= new ArrayList<Zinematografikoa>();
		Iterator<Aktorea> 			itr				= this.getIteradorea();
		Aktorea						aktoreHau		= null;
		
		while(itr.hasNext()){
			
			aktoreHau = itr.next();
			graforakoZerre.add(aktoreHau);
		}
		
		
		return graforakoZerre;	
	}

}


