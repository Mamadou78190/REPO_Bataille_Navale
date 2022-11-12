public class DeplacementNavire {

    public void deplacementNavire(Grille g1, Navire n1, String direction){
      
        int position = n1.getPosition();

        switch (position){
            //verticale

            case 0 : 

                switch (direction){

                    case "bas" : 
                        if (ApparitionFlotte.balayageBas(n1, n1.getOrdonnees(), n1.getAbscisse() , g1) >= 1 ){ 
                            g1.cacherCaseGrille(n1.getAbscisse(), (n1.getOrdonnees()-n1.taille)+1);
                            g1.grilleJeu[n1.getAbscisse()][(n1.getOrdonnees() + 1)] = n1.caractere;
                         }else{System.out.println("Impossibilité d'aller plus bas");} 

                    break;

                    case "haut" : 

                        if (ApparitionFlotte.balayageHaut(n1, (n1.getOrdonnees()- (n1.taille - 1)), n1.getAbscisse(), g1) >= 1){
                            g1.cacherCaseGrille(n1.getAbscisse(), n1.getOrdonnees());
                            g1.grilleJeu[n1.getAbscisse()][(n1.getOrdonnees() - n1.taille)] = n1.caractere;
                        }else {System.out.println("Impossibilité d'aller plus haut");}   

                    break;
                }
                
            break;
             
            case 1 : 

                switch (direction){

                    case "bas" : 

                         if (ApparitionFlotte.balayageBas(n1, (n1.getOrdonnees() + (n1.taille-1)) , n1.getAbscisse(), g1) >= 1){
                            g1.cacherCaseGrille(n1.getAbscisse(), n1.getOrdonnees());
                            g1.grilleJeu[n1.getAbscisse()][(n1.getOrdonnees() + n1.taille)] = n1.caractere;
                        }else {System.out.println("Impossibilité d'aller plus bas");}
                    
                    break; 

                    case "haut" : 

                        if(ApparitionFlotte.balayageHaut(n1, n1.getOrdonnees(), n1.getAbscisse(), g1) >= 1){
                            g1.cacherCaseGrille(n1.getAbscisse(),(n1.getOrdonnees()+n1.taille) -1);
                            g1.grilleJeu[n1.getAbscisse()][n1.getOrdonnees() - 1] = n1.caractere;
                        }else {System.out.println("Impossibilité d'aller plus haut");}

                    break; 
                }

            break;

            case 2 : 
                switch (direction){

                    case "gauche" :

                    if (ApparitionFlotte.balayageGauche(n1, n1.getOrdonnees(), n1.getAbscisse(), g1) >= 1){
                        g1.cacherCaseGrille((n1.getAbscisse() + (n1.taille-1)), n1.getOrdonnees());
                        g1.grilleJeu[n1.getAbscisse() - 1][n1.getOrdonnees()] = n1.caractere;
                    }else{System.out.println("Impossibilité d'aller à gauche");}

                    break;

                    case "droite" :

                    if(ApparitionFlotte.balayageDroite(n1, n1.getOrdonnees(), n1.getAbscisse() +(n1.taille -1), g1) >= 1){
                        g1.cacherCaseGrille(n1.getAbscisse(), n1.getOrdonnees());
                        g1.grilleJeu[n1.getAbscisse() + n1.taille][n1.getOrdonnees()] = n1.caractere;
                    }else {System.out.println("Impossibilité d'aller à droite");}

                    break;
                }

            break;

            case 3 : 

            switch (direction){

                    case "gauche" : 

                    if (ApparitionFlotte.balayageGauche(n1, n1.getOrdonnees(), (n1.getAbscisse() - (n1.taille -1)), g1) >= 1){
                        g1.cacherCaseGrille(n1.getAbscisse(), n1.getOrdonnees());
                        g1.grilleJeu[n1.getAbscisse()-n1.taille][n1.getOrdonnees()] = n1.caractere;
                    }else{System.out.println("Impossibilité d'aller à gauche");}

                    break;

                    case "droite" :

                    if(ApparitionFlotte.balayageDroite(n1, n1.getOrdonnees(), n1.getAbscisse(), g1) >= 1){
                        g1.cacherCaseGrille((n1.getAbscisse()-n1.taille)+1, n1.getOrdonnees());
                        g1.grilleJeu[n1.getAbscisse() + 1][n1.getOrdonnees()] = n1.caractere;
                    }else{System.out.println("Impossibilité d'aller à droite");}

                    break;
            }
            break;
            
        }
                
    }

}
    

