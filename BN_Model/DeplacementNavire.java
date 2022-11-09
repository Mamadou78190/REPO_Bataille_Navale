package BN_Model;

public class DeplacementNavire {

    public void deplacementNavire(Grille g1, Ship n1, String direction){
      
        int position = n1.getOrientation();

        switch (position){
            //verticale

            case 0 : 

                switch (direction){

                    case "bas" : 
                        if (ApparitionFlotte.balayageBas(n1, n1.getY(), n1.getX() , g1) >= 1 ){ 
                            g1.cacherCaseGrille(n1.getX(), (n1.getY()-n1.getTaille())+1);
                            g1.grilleJeu[n1.getX()][(n1.getY() + 1)] = n1.getVisuel();
                         }else{System.out.println("Impossibilité d'aller plus bas");} 

                    break;

                    case "haut" : 

                        if (ApparitionFlotte.balayageHaut(n1, (n1.getY()- (n1.getTaille() - 1)), n1.getX(), g1) >= 1){
                            g1.cacherCaseGrille(n1.getX(), n1.getY());
                            g1.grilleJeu[n1.getX()][(n1.getY() - n1.getTaille())] = n1.getVisuel();
                        }else {System.out.println("Impossibilité d'aller plus haut");}   

                    break;
                }
                
            break;
             
            case 1 : 

                switch (direction){

                    case "bas" : 

                         if (ApparitionFlotte.balayageBas(n1, (n1.getY() + (n1.getTaille()-1)) , n1.getX(), g1) >= 1){
                            g1.cacherCaseGrille(n1.getX(), n1.getY());
                            g1.grilleJeu[n1.getX()][(n1.getY() + n1.getTaille())] = n1.getVisuel();
                        }else {System.out.println("Impossibilité d'aller plus bas");}
                    
                    break; 

                    case "haut" : 

                        if(ApparitionFlotte.balayageHaut(n1, n1.getY(), n1.getX(), g1) >= 1){
                            g1.cacherCaseGrille(n1.getX(),(n1.getY()+n1.getTaille()) -1);
                            g1.grilleJeu[n1.getX()][n1.getY() - 1] = n1.getVisuel();
                        }else {System.out.println("Impossibilité d'aller plus haut");}

                    break; 
                }

            break;

            case 2 : 
                switch (direction){

                    case "gauche" :

                    if (ApparitionFlotte.balayageGauche(n1, n1.getY(), n1.getX(), g1) >= 1){
                        g1.cacherCaseGrille((n1.getX() + (n1.getTaille()-1)), n1.getY());
                        g1.grilleJeu[n1.getX() - 1][n1.getY()] = n1.getVisuel();
                    }else{System.out.println("Impossibilité d'aller à gauche");}

                    break;

                    case "droite" :

                    if(ApparitionFlotte.balayageDroite(n1, n1.getY(), n1.getX() +(n1.getTaille() -1), g1) >= 1){
                        g1.cacherCaseGrille(n1.getX(), n1.getY());
                        g1.grilleJeu[n1.getX() + n1.getTaille()][n1.getY()] = n1.getVisuel();
                    }else {System.out.println("Impossibilité d'aller à droite");}

                    break;
                }

            break;

            case 3 : 

            switch (direction){

                    case "gauche" : 

                    if (ApparitionFlotte.balayageGauche(n1, n1.getY(), (n1.getX() - (n1.getTaille() +1)), g1) >= 1){
                        g1.cacherCaseGrille(n1.getX(), n1.getY());
                        g1.grilleJeu[n1.getX()-n1.getTaille()][n1.getY()] = n1.getVisuel();
                    }else{System.out.println("Impossibilité d'aller à gauche");}

                    break;

                    case "droite" :

                    if(ApparitionFlotte.balayageDroite(n1, n1.getY(), n1.getX(), g1) >= 1){
                        g1.cacherCaseGrille((n1.getX()-n1.getTaille())+1, n1.getY());
                        g1.grilleJeu[n1.getX() + 1][n1.getY()] = n1.getVisuel();
                    }else{System.out.println("Impossibilité d'aller à droite");}

                    break;
            }
            break;
            
        }
                
    }

}
    

