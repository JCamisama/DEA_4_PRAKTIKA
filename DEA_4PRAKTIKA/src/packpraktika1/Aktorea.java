package packpraktika1;

import java.io.PrintWriter;
import java.util.*;

public class Aktorea extends Zinematografikoa{
	
	private ListaPelikulak		starringPelikula; //Jardun duen pelikularen posizioa (errenkada) gordeko da
	
	public Aktorea(String pIzena){
		
		super(pIzena);
		starringPelikula = new ListaPelikulak();
	}
	
	public void gehituPelikula(Pelikula pFilma){
		
		//Aurre-Baldintza:	Pelikularen objektua existituko da (ListaPelikulan null kasua tratatu da, dena den)
		//Post-Baldinta: 	Pelikula aktorearen zerrendan gehituta agertuko da.
		//Kostua:			O(1);			
		
		this.starringPelikula.gehituPelikula(pFilma);
	}

	
	public void inprimatuAktorea(){ //FROGAK EGITEKO METODOA, EZ DA MEMORIAN SARTUKO
		
		System.out.println("\n" +super.getIzena()+ "\n");
		
	}
	
	public void idatziAktorearenIzena(PrintWriter pOutputStream){
		
		//Aurre-Baldintza:	Pelikularen onjektua existituko da.
		//Post-Baldinta:	Pelikula aktoreanren zerrendan gehituta agertuko da.
		//Kostua:			O(1);
		
		pOutputStream.println(super.getIzena());
	}
	
	public boolean lehenagoDoa(Aktorea pBesteAktorea){
		
		//Aurre-Baldintza:	pBesteAktorea-ren izena String bat izango da.
		/*Post-Baldinta:	Alfabetoaren ordena jarraituz, aktore honen izena
						 	pBesteAktorea-rena baino lehen badoa, True, bestela False */
		//Kostua:			O(1);
		
		return super.getIzena().compareToIgnoreCase(pBesteAktorea.getIzena())<= 0;
		
	}
	
	
	/*public String getIzena(){ //getter hau ezinbestekoa da HashMap-aren erabilera posiblea ariketaren testuinguruan
		
		//Aurre-Baldintza:	---------------------
		//Post-Baldinta:	aktorearen izena bueltatuko da, String motakoa
		//Kostua:			O(1);
		return this.izena;
	}*/
	
	/****************************************JONPORT**********************************************/
	
	public boolean bilatzekoAktorea(Aktorea pAktore) {
		
		//Aurre-Baldintza:	Letra larriak eta xeheak ezberdinduko dira.
		//Post-Baldintza:	pAktorearen izena aktore honen izenaren berdina bada True, bestela False.
		//Kostua:			O(1);
		
		return super.getIzena().equals(pAktore.getIzena());
	}

	
	public ListaPelikulak aktorearenPelikulakBueltatu() {
		
		//Aurre-Baldintza:	----------------------------------------------
		//Post-Baldintza:	Aktorearen pelikula guztiak ArrayList baten barruan sartuta bueltatuko dira.
		//Kostua:			O(1);
		
		return this.starringPelikula;
	}
	
	public void ezabatuBerePelikuletatik(){
		
		this.starringPelikula.ezabatuPelikulaHauetatik(this);
		this.starringPelikula.garbitu();
	}
	
	/****************************************batazBestekorako*********************************************/
	
	public int pelikulenListarenLuzeera(){
		
		return this.starringPelikula.luzera();
		
	}
	
	/********************************************PAGERANK LABORATEGIA**************************/
	
	public int getErlazioKopurua(){
		
		return this.starringPelikula.luzera();
	}
	
}
