package packpraktika1;

public abstract class Zinematografikoa {
	
	protected String izena;
	protected double pageRank = 0.00;
	
	
	public Zinematografikoa (String pIzena){
		
		this.izena = pIzena;
	}
	
	public String getIzena(){
		
		return this.izena;
	}
	
	
	public boolean instantziaBerekoak(Zinematografikoa pZinemakoa){
		
		//Aurre-baldintza:	Klasekoa eta parametroa edo Aktorea edo Pelikula izango dira.
		//Post-baldinta:	Biak pelikulak edo biak aktoreak badira true, bestela false.
		//Kostua: O(1)
		
		/*Proba Kasuak
		 	 	
		 	1. this Aktorea eta pZinemakoa Pelikula     ---> False
			2. this Pelikula eta pZinemakoa Aktorea		---> False
			3. this Aktorea eta pZinemakoa Aktorea		---> True
			4. this Pelikula eta pZinemakoa Pelikula	---> True
		 */
		
		 boolean aktoreInstantziak = false; //Biak aktoreak diren jakiteko
		 boolean filmaInstantziak  = false; //Biak pelikulak diren jakiteko
	
		 aktoreInstantziak = (this instanceof Aktorea)&&(pZinemakoa instanceof Aktorea);	//Biak aktoreak?
		 filmaInstantziak  = (this instanceof Pelikula)&&(pZinemakoa instanceof Pelikula);	//Biak pelikulak?
		 
		 return aktoreInstantziak || filmaInstantziak;
	}
	
	
	/********************************************PAGERANK LABORATEGIA**************************/
	public void setPageRank(double pPageRank){
		
		this.pageRank = pPageRank;
	}
	
	public double getPageRank(){
		
		return this.pageRank;
	}
	
	public abstract int getErlazioKopurua();
	
	public void inprimatuIzenaPageRank(){
		
		System.out.println("\n"+this.izena+"------->"+ this.pageRank);
		
	}

}
