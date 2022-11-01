package modele;
import java.util.Random;

import modele.personnage;

public class grille {

    public int ligne;
	public int colonne;
	public String [][] grille;
	
	//Constructeur du tableau de y colonne et x ligne 
	public grille(int y, int x) {
		
		ligne = x;
		colonne = y;
		grille = new String[ligne][colonne];
		

		for (int i=0; i<ligne; i++) {
			
			for (int j=0; j<colonne; j++) {
				
				grille[i][j] = "--";
			}
		}
		
	}

    //Afficher la grille
    public void afficher() {
		
		for (String[] tab: grille) {
		     for (String s: tab) {
		         System.out.print(" | "+s);
		     }
		     System.out.println(" |");
		  }
		
	}

    //Balayer la grille dans les 4 sens 
    public int balayageCollision (String sens, personnage p1, int ligneB, int colonneB){

        int cmpt = 0;

        switch (sens) {

            case "haut" : 
            
            for (int i= 0; i<p1.taille; i++){
				if (((ligneB+2)-p1.taille) > 0 && grille [ligneB-i][colonneB] == "--"){
						cmpt = cmpt + 1;
				}else {cmpt = cmpt;}
			}
            break;

            case "bas" : 
             
                    for (int i= 0; i<p1.taille; i++){
				         if (((ligneB-1)+p1.taille) < this.ligne && grille [ligneB+i][colonneB] == "--"){
				     		cmpt = cmpt + 1;
				        }else {cmpt = cmpt;}
                    }
            break;    
			
            case "gauche" : 
            
                for (int i= 0; i<p1.taille; i++){
				    if (((colonneB+2)-p1.taille) > 0 && grille [ligneB][colonneB-i] == "--"){
				    	cmpt = cmpt+1;
				    }else{cmpt = cmpt;}
			    }
            break;

            case "droite" : 
               
                for (int i= 0; i<p1.taille; i++){
				    if (((colonneB-1)+p1.taille) < this.colonne && grille [ligneB][colonneB+i] == "--"){
				    	cmpt = cmpt+1;
				    }else {cmpt = cmpt;}
			    }
            break;
        }

        return (cmpt);
    }

    //Placer les navires sans chevauchements
    public void placerNavire (personnage p1){

        //Coordonnées aléatoires
		Random random = new Random();
		Random random2 = new Random();
		int ligneG = 0;
		int colonneG = 0;
		do{
	   		ligneG = random.nextInt(this.ligne);	
		}while(grille [ligneG][colonneG] != "--");

		do{
			colonneG = random2.nextInt(this.colonne);
		}while(grille [ligneG][colonneG] != "--");

        //Position aléatoire
		Random random3 = new Random();
        int position = random3.nextInt(3);

        switch (position) {

            case 0 : 
			    if (((colonneG-1)+p1.taille < this.colonne) && balayageCollision("droite", p1, ligneG, colonneG) == p1.taille){
				    //-> droite
				    for (int i = 0; i<p1.taille; i++) {
				    	grille [ligneG][colonneG+i] = p1.caract;
				    }
			    }else if (((colonneG+1)-p1.taille) > 0 && balayageCollision("gauche", p1, ligneG, colonneG) == p1.taille){
				    for (int i = 0; i<p1.taille; i++) {
				    	grille [ligneG][colonneG-i] = p1.caract;
				    }
			    } else if(((ligneG+1)-p1.taille) > 0 &&  balayageCollision("haut", p1, ligneG, colonneG) >= p1.taille){
				    for (int i = 0; i<p1.taille; i++) {
				    	grille [ligneG-i][colonneG] = p1.caract;
				    }
			    }else if(((ligneG+1)+p1.taille) < this.ligne && balayageCollision("bas", p1, ligneG, colonneG) >= p1.taille){
				    for (int i = 0; i<p1.taille; i++) {
				    	grille [ligneG+i][colonneG] = p1.caract;}
			    }

			break;

           
            case 1 : 
			    if (((colonneG+2)-p1.taille) > 0 && balayageCollision("gauche", p1, ligneG, colonneG) == p1.taille){
					    //<- gauche
	    		    for (int i = 0; i<p1.taille; i++) {
				    	grille [ligneG][colonneG-i] = p1.caract;
				    }
			    }else if (((colonneG-1)+p1.taille) < this.colonne && balayageCollision("droite", p1, ligneG, colonneG) == p1.taille){
				    for (int i = 0; i<p1.taille; i++) {
				    	grille [ligneG][colonneG+i] = p1.caract;
			    	}
			    }else if (((ligneG-1)+p1.taille) < this.ligne && balayageCollision("bas", p1, ligneG, colonneG) >= p1.taille){
			    	for (int i = 0; i<p1.taille; i++) {
			    		grille [ligneG+i][colonneG] = p1.caract;
			    	}	
		    	}else if(((ligneG+1)-p1.taille) > 0 &&  balayageCollision("haut", p1, ligneG, colonneG) >= p1.taille){
		    		for (int i = 0; i<p1.taille; i++) {
		    			grille [ligneG-i][colonneG] = p1.caract;
		    		}
		    	}
			break;

            case 2 : 
                if (((ligneG-1)+p1.taille) < this.ligne && balayageCollision("bas", p1, ligneG, colonneG) >= p1.taille){
			    	// |bas
	    	        for (int i = 0; i<p1.taille; i++) {
				        grille [ligneG+i][colonneG] = p1.caract;}
				
			    }else if(((ligneG+1)-p1.taille) > 0 &&  balayageCollision("haut", p1, ligneG, colonneG) >= p1.taille){
				    for (int i = 0; i<p1.taille; i++) {
					grille [ligneG-i][colonneG] = p1.caract;
				    }
			    }else if (((colonneG-1)+p1.taille) < this.colonne && balayageCollision("droite", p1, ligneG, colonneG) == p1.taille){
				    for (int i = 0; i<p1.taille; i++) {
				    	grille [ligneG][colonneG+i] = p1.caract;
			    	}
			    }else if (((colonneG+1)-p1.taille) > 0 && balayageCollision("gauche", p1, ligneG, colonneG) >= p1.taille){
			    	for (int i = 0; i<p1.taille; i++) {
			    		grille [ligneG][colonneG-i] = p1.caract;
			    	}
			    }
            break;

            case 3 : 
                if (((ligneG+2)-p1.taille) > 0 && balayageCollision("haut", p1, ligneG, colonneG) == p1.taille){
			    	// |^ haut 
	    	    		for (int i = 0; i<p1.taille; i++) {
			    			grille [ligneG-i][colonneG] = p1.caract;
			    		}
			    }else if (((ligneG-1)+p1.taille) < this.ligne && balayageCollision("bas", p1, ligneG, colonneG) >= p1.taille){
			    	for (int i = 0; i<p1.taille; i++) {
			    		grille [ligneG+i][colonneG] = p1.caract;
			    	}	
			    }else if (((colonneG+1)-p1.taille) > 0 && balayageCollision("gauche", p1, ligneG, colonneG) == p1.taille){
			    	for (int i = 0; i<p1.taille; i++) {
			    		grille [ligneG][colonneG-i] = p1.caract;
			    	}
			    }else if (((colonneG-1)+p1.taille) < this.colonne && balayageCollision("droite", p1, ligneG, colonneG) == p1.taille){
			    	for (int i = 0; i<p1.taille; i++) {
			    		grille [ligneG][colonneG+i] = p1.caract;
			    	}
			    }
            break;
        }
    }
    
}
