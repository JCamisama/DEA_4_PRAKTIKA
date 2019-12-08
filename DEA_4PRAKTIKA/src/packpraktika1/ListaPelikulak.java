package packpraktika1;

import packpraktika2.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaPelikulak {

	private DoubleLinkedList<Pelikula> zerrenda;
	
	public ListaPelikulak(){
		
		this.zerrenda = new UnorderedDoubleLinkedList<Pelikula>();
	}
	
	
	
	private Iterator<Pelikula> getIteradorea(){
		
		//Aurre-Baldintza:	------------------------------------------
		//Post-Baldinta: 	Pelikulen bilduma bat bueltatuko du, Iterator interfaz bezala.
		//Kostua:			O(m); Non m pelikulen kopurua den
		
		return this.zerrenda.iterator();
	}
	
	public void gehituPelikula(Pelikula pFilma){//********ALDATU EGIN DA
		
		//Aurre-Baldintza:	----------------------------------------------------------
		//Post-Baldinta: 	Pelikula ez bada null eta ez badago zerrendan, gehituko da.
		//Kostua:			O(m); Non m pelikulen kopurua da.
		
		if( pFilma != null && !this.badago(pFilma) ){
			
			((UnorderedDoubleLinkedList) this.zerrenda).addToRear(pFilma);
		}
	}
	
	public void ezabatuFilma(Pelikula pFilma){
		
		//Aurre-Baldintza:	----------------------------------------------------------
		//Post-Baldinta: 	Pelikula ez bada null eta pelikulen zerrendan  badago, zerrendatik ezabatuko da.
		//Kostua:			O(m); Non m pelikulen kopurua da.
	
		this.zerrenda.remove(pFilma);
	}
	
	public void inprimatuGuztiak(){//Frogak egiteko programatu da bakarrik, ez da memorian idatzi behar
		
		Iterator<Pelikula> itr = this.getIteradorea();
		
		Pelikula peliHau = null;
		
		while( itr.hasNext() ){
			
			peliHau = itr.next();
			peliHau.inprimatuIzena();
		}
		
	}
	

	public Pelikula pelikulaBilatu(String pFilma) {
		
		//Aurre-Baldintza:	----------------------------------------------------------
		//Post-Baldinta: 	Pelikula bueltatuko da zerrendan badago, bestela null.
		//Kostua:			O(m); Non m pelikulen kopurua da.
		
		Iterator<Pelikula>	itr				= this.getIteradorea();
		Pelikula			egungoPelikula	= null;
		boolean				topatua			= false;
		
		while( itr.hasNext() && !topatua){
			
			egungoPelikula = itr.next();
			
			if (egungoPelikula.equals(pFilma)) {
				
				topatua = true;	
				System.out.println("Zure pelikula listan dago");								
			}			
		}
		
		if (!topatua) {
			
			System.out.println("Zure pelikula ez dago listan.");
			egungoPelikula	= null;
		}
		
		return egungoPelikula;
	}
	
	public boolean badago(Pelikula pFilma){
		
		Iterator<Pelikula> 	itr			=	this.getIteradorea();
		Pelikula			peliHau		=	null;
		boolean				badago		=	false;
		
		while(!badago && itr.hasNext()){
			
			peliHau	=	itr.next();
			badago	=	(pFilma.getIzena() == peliHau.getIzena());
		}
			
		return badago;	
	}
	
	
	public void pelikulaKargatu(Pelikula pPelikula){ //Gehiketa egiten du, ea zerrendan dagoen konrpobatu gabe
		
		//Aurre-Baldintza:	----------------------------------------------------------
		//Post-Baldinta: 	Pelikula ez bada null eta ez badago zerrendan, gehituko da.
		//Kostua:			O(1);
		
			((UnorderedDoubleLinkedList) this.zerrenda).addToRear(pPelikula);
	}
	
	public void ezabatuPelikulaHauetatik(Aktorea pAktoreIzena){//METODO BERRIA, JUNIT BEHAR DU
		
		Iterator<Pelikula> 	itr			=	this.getIteradorea();
		Pelikula			peliHau		=	null;
		

		while(itr.hasNext()){
			
			peliHau	=	itr.next();
			peliHau.AktoreaPelikulatikKendu(pAktoreIzena);
		}
				
	}
	
	public int luzera(){ //Frogak egiteko bakarrik
		
		return this.zerrenda.size();
	}
	
	public void erreseteatu() { //Frogak egiteko bakarrik
		
		this.zerrenda = null;
		
	}
	
	public void garbitu(){ //Frogak egiteko bakarrik
		
		this.zerrenda.zerrendaHustu();;
	}
	
	
	//*************************************************GRAFOA***********************************************//
	public ArrayList<Zinematografikoa> grafokoZerrendaSortu(){//METODO BERRIA, JUNITAK BEHAR DITU
		
		ArrayList<Zinematografikoa> graforakoZerre	= new ArrayList<Zinematografikoa>();
		Iterator<Pelikula> 			itr				=	this.getIteradorea();
		Pelikula					peliHau			=	null;
		
		while(itr.hasNext()){
			
			peliHau = itr.next();
			graforakoZerre.add(peliHau);
		}
		
		
		return graforakoZerre;	
	}


}
