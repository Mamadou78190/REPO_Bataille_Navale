
package BN_Model;

public class DeplacementNavire {

    public void deplacementNavire(Grille g1, Ship n1, String direction){
      
        int position = n1.getOrientation();

      if (n1.getTaille() > 1){

        switch (position){
            //verticale
            case 0 : 

                switch (direction){

                    case "bas" : 
                        if (ApparitionFlotte.balayageBas(n1, n1.getY(), n1.getX() , g1) >= 1 ){ 
                            g1.cacherCaseGrille(n1.getX(), (n1.getY()-n1.getTaille())+1);
                            g1.grilleJeu[n1.getX()][(n1.getY() + 1)] = n1.getVisuel();
                            n1.setY((n1.getY() + 1));
                            System.out.println("Bateau déplacé en bas");
                            g1.afficherGrille();
                          }else{System.out.println("Impossibilité d'aller plus bas");} 

                    break;

                    case "haut" : 

                        if (ApparitionFlotte.balayageHaut(n1, (n1.getY()- (n1.getTaille() - 1)), n1.getX(), g1) >= 1){
                            g1.cacherCaseGrille(n1.getX(), n1.getY());
                            g1.grilleJeu[n1.getX()][(n1.getY() - n1.getTaille())] = n1.getVisuel();
                            n1.setY(n1.getY() -1);
                            System.out.println("Bateau déplacé en haut");
                            g1.afficherGrille();
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
                            n1.setY(n1.getY() + 1);
                            System.out.println("Bateau déplacé en bas");
                            g1.afficherGrille();
                        }else {System.out.println("Impossibilité d'aller plus bas");}
                    
                    break; 

                    case "haut" : 

                        if(ApparitionFlotte.balayageHaut(n1, n1.getY(), n1.getX(), g1) >= 1){
                            g1.cacherCaseGrille(n1.getX(),(n1.getY()+n1.getTaille()) -1);
                            g1.grilleJeu[n1.getX()][n1.getY() - 1] = n1.getVisuel();
                            n1.setY(n1.getY() - 1);
                            System.out.println("Bateau déplacé en haut");
                            g1.afficherGrille();
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
                        n1.setX(n1.getX() - 1);
                        System.out.println("Bateau déplacé à gauche");
                        g1.afficherGrille();
                    }else{System.out.println("Impossibilité d'aller à gauche");}

                    break;

                    case "droite" :

                    if(ApparitionFlotte.balayageDroite(n1, n1.getY(), n1.getX() +(n1.getTaille() -1), g1) >= 1){
                        g1.cacherCaseGrille(n1.getX(), n1.getY());
                        g1.grilleJeu[n1.getX() + n1.getTaille()][n1.getY()] = n1.getVisuel();
                        n1.setX(n1.getX() + 1);
                        System.out.println("Bateau déplacé à droite");
                        g1.afficherGrille();
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
                        n1.setX(n1.getX() - 1);
                        System.out.println("Bateau déplacé à gauche");
                        g1.afficherGrille();
                    }else{System.out.println("Impossibilité d'aller à gauche");}

                    break;

                    case "droite" :

                    if(ApparitionFlotte.balayageDroite(n1, n1.getY(), n1.getX(), g1) >= 1){
                        g1.cacherCaseGrille((n1.getX()-n1.getTaille())+1, n1.getY());
                        g1.grilleJeu[n1.getX() + 1][n1.getY()] = n1.getVisuel();
                        n1.setX(n1.getX() + 1);
                        System.out.println("Bateau déplacé à droite");
                        g1.afficherGrille();
                    }else{System.out.println("Impossibilité d'aller à droite");}

                    break;
            }
            break;
            
        }
      } else if (n1.getTaille() == 1){

            switch (direction){

                case "gauche" :
            
                if (ApparitionFlotte.balayageGauche(n1, n1.getY(),n1.getX()-1,g1) == 1){
                    g1.cacherCaseGrille(n1.getX(), n1.getY());
                    g1.grilleJeu[n1.getX()-1][n1.getY()] = n1.getVisuel();
                    System.out.println("Sous-Marin déplacé à gauche");
                    n1.setX(n1.getX()-1);
                    g1.afficherGrille();
                }else{System.out.println("Impossibilité d'aller à gauche");}

                break;


                case "droite" :

                if(ApparitionFlotte.balayageDroite(n1, n1.getY(),n1.getX()+1,g1) == 1){
                    g1.cacherCaseGrille(n1.getX(), n1.getY());
                    g1.grilleJeu[n1.getX()+1][n1.getY()] = n1.getVisuel();
                    System.out.println("Sous-Marin déplacé à droite");
                    n1.setX(n1.getX()+1);
                    g1.afficherGrille();
                }else{System.out.println("Impossibilité d'aller à droite");}

                break;

                case "haut" : 

                if(ApparitionFlotte.balayageHaut(n1, n1.getY()-1,n1.getX(),g1) == 1){
                    g1.cacherCaseGrille(n1.getX(), n1.getY());
                    g1.grilleJeu[n1.getX()][n1.getY()-1] = n1.getVisuel();
                    System.out.println("Sous-Marin déplacé en haut");
                    n1.setY(n1.getY()-1);
                    g1.afficherGrille();
                }else{System.out.println("Impossibilité d'aller plus haut");}

                break;

                case "bas" :

                if(ApparitionFlotte.balayageBas(n1, n1.getY()+1,n1.getX(),g1) ==  1){
                    g1.cacherCaseGrille(n1.getX(), n1.getY());
                    g1.grilleJeu[n1.getX()][n1.getY()+1] = n1.getVisuel();
                    System.out.println("Sous-Marin déplacé en bas");
                    n1.setY(n1.getY()+1);
                    g1.afficherGrille();
                }else{System.out.println("Impossibilité d'aller plus bas");}
            }    
        }          
    }

}
    



                



    


