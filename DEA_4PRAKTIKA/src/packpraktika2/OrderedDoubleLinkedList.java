package packpraktika2;

public class OrderedDoubleLinkedList<T extends Comparable<T>> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T pElem){
		

		//Aurre-Baldintza:	---
		//Post-Baldinta: 	Datua posizio egokia duen nodo berri batean txertatuta egongo da, zerrendaren parte bilakatzen.
		//Kostua:			O(n);
		
		/* Proba kasuak:
		  
		 	- 1. Zerrenda hutsa izatea
		 	- 2. Elementu bakarreko zerrenda denean.
		 	- 3. Elementu berria zerrendan daudenak baino txikiagoa izatea (lehenengo posizioan gehitzea).
		 	- 4. Elementu berria zerrendako erdialdeko posizio batean joatea.
		 	- 5. Elementu berria zerrendan daudenak baino handiagoa izatea (azkenengo posizioan gehitzea).
		 */

		//Nodo berria eta unekoari apuntatzeko erakusleak sortzen:
		
		Node berria = new Node((Comparable) pElem); //COMPARABLE EZ BADUT IDAZTEN, EZ DU FUNTZIONATZEN T-REKIN!!!!!*****
		
		Node unekoa	= super.first; //Bere atributuak ama klasean definituta daudenez, "super" erreferentzia erabili da.
		
		if( unekoa == null ){ //Zerrenda hutsik dagoenean
			
			super.first = berria;
			berria.next	= berria;
			berria.prev	= berria;
		}
		
		else{
			
			int		kontatutakoPosizio	= 0;
			boolean	txikiagoDa			= false;
			
			while( (kontatutakoPosizio < super.count)&&!txikiagoDa ){ //Guztiekin konparatu arte edo elementu baino 
																		// txikiagoa den jakin arte
				
				if( berria.data.compareTo(unekoa.data) < 0 ){ //Negatiboa bada, txiagoa izango da, bestela berdina edo handiagoa
					
					txikiagoDa = true;
				}
				
				else{
					
					unekoa = unekoa.next;
					kontatutakoPosizio++; // Zerrendako elementu bat gehiago konprobatu dela 
				}	
			}
			
			//Unekoaren aurrekoa eta hurrengoen erakusleak egiten, ulermena errazteko
			Node aurrekoa	= unekoa.prev;
			Node hurrengoa	= unekoa.next;
			
			aurrekoa.next	= berria;
			berria.prev		= aurrekoa;
			unekoa.prev		= berria;
			berria.next		= unekoa;
			
			if( kontatutakoPosizio == 0 ){ //Zerrendaren lehenengoa baino txikiagoa izatekotan
				
				super.first = berria;
			}	
		}
		
		super.count++;
	}

	public void merge(DoubleLinkedList<T> pZerrenda){
		
		//Aurre baldintza: DoubleLinkedList<T> ordenatu bat sartuko da
		//Post baldintza: Ez du ezer itzuliko, baina daugakun DoubleLinkedList<T>-rekin (this.first...) eta sartutako DoubleLinkedList<T>-arekin (pZerrenda), OrderedDoubleLinkedList<T> berri ordenatu bat sortuka da
		//Kostua: 0(n)
		
		
		OrderedDoubleLinkedList<T> zerrendaLag		= (OrderedDoubleLinkedList<T>) pZerrenda; //Zerrenda ordenaturik dagoelako.
		
		Node<T> unekoa1		= this.first; 	     //Zerrenda nagusiaren (this) nodoei apuntzeko.
		Node<T> aurrekoa1	= null;   			 //Zerrenda nagusiaren (this) unekoa1-ren aurrekoari apuntatzeko.
	    Node<T> unekoa2		= zerrendaLag.first; //Kanpoko zerrendaren (pZerrenda) nodoei apuntatzeko.
	    Node<T> lagun2		= null;				 //Esteken aldaketan lagungarria izango den erakuslea.
	    Node<T> azkena2		= null;				 //pZerrendaren azkenengoa beharrezkoa izango da.
		
	    int kontX 		= 0; 			//this.count-aren laguntzaile bat
	    int kontY 		= 0; 			//zerrendaLag.count-aren laguntzaile bat
	    int aurrekoKop	= this.count;	//kopurua eguneratzen joango denez, 
	    									//laguntzaile bat erabiliko da aurreko kopurua zen zen jakiteko
	    
	    if(!zerrendaLag.isEmpty()){
	    	
	    	azkena2 = unekoa2.prev;
	    }
	    
	    while (kontX < aurrekoKop && kontY < zerrendaLag.count) {

	    	
	        if (unekoa1.data.compareTo(unekoa2.data) <= 0 ) { /*this.first-ren data string bezala, 
	        														zerrendaLag-ena baino handiagoa bada, 
	        														orduan zerrendaLag-en lehenengo elementua sartu 
	        														egingo da gure zerrenda berrian */
	       	
	        	unekoa1 = unekoa1.next;	    //Zerrendan nagusian dagoena lehenago doala esan nahi du    	
	            kontX++;
	        } 
	        
	        else { 
	        	
	        	if(this.first.data.compareTo(unekoa2.data) > 0 ){
	        		
	        		this.first = unekoa2;
	        	}
	        	aurrekoa1	= unekoa1.prev;
	        	lagun2		= unekoa2.next;			//Hurrengo iterazaioan aztertuko dena gordetzen
	        	
	        	//pZerrendako nodoa zerrenda nagusian txertatzen
	        	aurrekoa1.next	=	unekoa2;	
	        	unekoa2.prev	=	aurrekoa1;
	        	unekoa2.next	=	unekoa1;
	        	unekoa1.prev	=	unekoa2;
	        	this.count++;					//Zerrenda nagusian nodo bat gehiago dagoelako
	        	
	        	unekoa2			=	lagun2;		//Hurrengo iterazaioan aztertuko dena berreskuratzen
	        	kontY++;          
	        }  	        
	    }
	    
	    
	    if (kontX == aurrekoKop &&  !zerrendaLag.isEmpty()){ /*this zerrenda hutsa bada, 
	    														orduan zerrendaLag-en dauden
	    														objektu guztiak zerrenda nagusian gehitu behar dira*/
	    
	    	if(this.isEmpty()){ //Zerrenda nagusia hutsa denerako kasua: pZerrenda izango da zerrenda berria
	    		
	    		this.first = unekoa2;
	    		this.count = zerrendaLag.count;
	    	}
	    	
	    	else{ //pZerrendan oraindik elementu gehiago geratzen dira txertatzeko
	    		
	    		unekoa1	= unekoa1.prev; //while-etik ateratzerakoan berriz ere lehenengo nodora apuntatzen dagoelako
	    		lagun2	= unekoa2;		//pZerrendaren azkenengo nodora pasatzeko erraztasuna emango du geroago
	    		
	    		unekoa1.next	=	unekoa2;
	    		unekoa2.prev	=	unekoa1;
	  
	    		//pZerrendaren azkenengo nodoa eta zerrenda nagusiaren lehenengo nodoa erlazionatzen
	    		unekoa2			=	azkena2; //pZerrendaren azkenengo nodoa
	    		unekoa2.next	=	this.first;
	    		this.first.prev	=	unekoa2;
	    		
	    		//Zerrendaren tamaina eguneratzen
	    		this.count = this.count + (zerrendaLag.count-kontY);
	    	}			
	    }	
	  }
		 
	
	public T find(T pElem) {
 
		// Aurre Baldintza : ------
		// Post Baldintza : Elementua bueltatuko du aurkituz gero, eta null bestela
		// Kostua: O(n)
			
			
			Node<T>    lag  = this.first;		
			boolean topatua = false;
			boolean txikia	= false; //Zerrendan bilatzerakoan pElem lag.data baino txikiagoa bada,
										//hurrengo elementuak ez dira aztertuko.
			int		kont	= 0;
			T 		emaitza = null;
			
			if (!this.isEmpty()){		
			
				while(kont != this.count && !topatua && !txikia) {


                    if (pElem.compareTo(lag.data) < 0 ){
  
                    	txikia=true;

                    }
				
					else if (lag.data.equals(pElem)) {
						
						topatua = true;
						emaitza = lag.data;
						
						
					}
					
					else{
						
						lag=lag.next;	
						kont++;
					}
				}
			}
			
			return emaitza;		
	}

	@Override
	public T remove(T pElem) {

		//Aurre-Baldintza:	---
		/*Post-Baldinta: 	Elementua badago, zerrendatik ezabatuko da eta datua bueltatuko da, bestela null.
		 					era eraginkorrean ezabatuko da elementua*/
		//Kostua:			O(n);
		
		/* Proba kasuak:
		  
		 	- 1. Zerrenda hutsa izatea
		 	- 2. Elementua zerrendan dago eta elementu bakarreko zerrenda denean.
		 	- 3. Elementua zerrendan ez dago eta elementu bakarreko zerrenda denean.
		 	- 4. Elementua zerrendan dago eta elementu anitzeko zerrenda denean: Lehenengoa denean.
		 	- 5. Elementua zerrendan dago eta elementu anitzeko zerrenda denean: Erdialdean dagoenean.
		 	- 6. Elementua zerrendan dago eta elementu anitzeko zerrenda denean: Amaieran dagoenean.
		 	- 7. Elementua zerrendan ez dagoenean eta elementu anitzeko zerrenda denean: Lehenengoa baino txikiagoa denean.
		 	- 8. Elementua zerrendan ez dagoenean eta elementu anitzeko zerrenda denean: Erdialdeko bat baino txikiagoa denean.
		 	- 9. Elementua zerrendan ez dagoenean eta elementu anitzeko zerrenda denean: Guztiak baino handiagoa denean.
		 */
		
		Node unekoa	= super.first; //Bere atributuak ama klasean definituta daudenez, "super" erreferentzia erabili da.
		Comparable ezabatutakoa = null;
		
		if(unekoa != null){
			
			//Unekoaren aurrekoa eta hurrengoen erakusleak egiten, ulermena errazteko
			Node aurrekoa	= unekoa.prev;
			Node hurrengoa	= unekoa.next;
			
			//Elementu bakarreko zerrenda denean
			if(unekoa == aurrekoa && unekoa.data.equals(pElem)){
				
				ezabatutakoa	= unekoa.data;
				this.first		= null;		//Zerrenda hutsik geratuko da
				super.count--;              //Elementuen kopurua txikitu egin da.
			}
			
			else { //Edo ez da elementu bakarrekoa edo ez dago zerrendan
				
				boolean	topatua		= false;
				boolean txikiagoaDa	= false;
				int		kontatutakoPosizio	= 0; //Zerrenda zirkularrean behin eta berriro ez zeharkatzeko
				
				while( kontatutakoPosizio < super.count && !topatua && !txikiagoaDa){
					
					if(unekoa.data.equals(pElem)){ //Aurkituta izan da.
						
						ezabatutakoa	= unekoa.data;
						topatua			= true;
						aurrekoa.next	= hurrengoa;
						hurrengoa.prev	= aurrekoa;
						super.count--;            //Elementuen kopurua txikitu egin da.
					}
					
					else if(unekoa.data.compareTo(pElem) > 0){ //Ez da aurkitu eta gainera oraingoa baino txikiagoa da
						
						txikiagoaDa = true;
					}
					
					else{ //Hurrengoa aztertu ahal izateko
						
						aurrekoa	= aurrekoa.next;
						unekoa		= unekoa.next;
						hurrengoa	= hurrengoa.next;
						kontatutakoPosizio++;
					}
				}
			}
		}
		
		return (T) ezabatutakoa;
	}
}

