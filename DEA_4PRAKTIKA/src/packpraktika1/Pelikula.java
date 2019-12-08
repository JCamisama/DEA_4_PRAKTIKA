package packpraktika1;
import packpraktika2.*;


public class Pelikula  extends Zinematografikoa  implements Comparable<Pelikula>{
	
	private String			izena;
	private int				diruBilketa;
	private ListaAktoreak	jardunDutenak;
	
	public Pelikula(String pIzena){
		
		super(pIzena);
		this.jardunDutenak	= new ListaAktoreak();
	}
	
	public void aktoreBerriaSartu(Aktorea pAktore){
		
		//Aurre-Baldintza:	----------------------------------------------------------
		//Post-Baldinta: 	Aktorea ez badago jardunDutenak zerrendan, horretan txertatuko da.
		//Kostua:			O(n); Non n aktore kopurua da.
		
		if( pAktore != null && !this.jardunDutenak.badagoAktorea( pAktore.getIzena() )){
		
				this.jardunDutenak.gehituAktorea(pAktore);
		}
		
	}
	
	public void inprimatuIzena(){ //Frogak egiteko bakarrik
		
		System.out.println(super.getIzena());
	}
	
	
	public void gehituDirua(int pZenbatekoa){
		
		//Aurre-Baldintza:	----------------------------------------------------------
		//Post-Baldinta: 	Pelikularen diru bilketa pZenbatekoa kantitateaz handituko da.
		//Kostua:			O(1)
		
		this.diruBilketa = this.diruBilketa + pZenbatekoa;
	}

	
	public ListaAktoreak pelikularenAktoreakBueltatu() {
		
		//Aurre-Baldintza:	----------------------------------------------
		//Post-Baldintza:	Pelikularen aktore guztiak ArrayList baten barruan sartuta bueltatuko dira.
		//Kostua:			O(1);
		
		return this.jardunDutenak;
	}
	
	/*public String getIzena(){
		
		//Aurre-Baldintza:	---------------------
		//Post-Baldinta:	pelikularen izena bueltatuko da, String motakoa
		//Kostua:			O(1);
		
		return this.izena;
	}*/
	
	public boolean equals(String pFilma) { //********ALDATU EGIN DA
		
		//Aurre-Baldintza:	Letra larriak eta xeheak ezberdinduko dira.
		//Post-Baldintza:	pFilma izena pelikula honen izenaren berdina bada True, bestela False.
		//Kostua:			O(1);
		
		return super.getIzena().equals(pFilma);
	}
	
	public void AktoreaPelikulatikKendu(Aktorea pAktoreIzena){ //METODO BERRIA, JUNIT BEHAR DU
		
		this.jardunDutenak.ezabatuAktorea(pAktoreIzena);
	}

	public void diruSarreraTotalakInprimatu(){//METODO BERRIA, JUNIT BEHAR DU
		
		System.out.println("\nDiru sarrera totalak: "+ this.diruBilketa+" €\n");
	}
	
	public int compareTo(Pelikula pFilma){ //********ALDATU EGIN DA
		
		return super.getIzena().compareToIgnoreCase(pFilma.izena);
	}
	
	
	public int aktoreenLuzeera(){
		
		return this.jardunDutenak.luzera();
	}
	
	/********************************************PAGERANK LABORATEGIA**************************/
	
	public int getErlazioKopurua(){
		
		return this.jardunDutenak.luzera();
	}

}
