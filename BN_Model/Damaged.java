
package BN_Model;

public class Damaged {

    // public void deplacementNavire(Grille grille, Ship ship, String direction){
      
//         int position = ship.getOrientation();
//         if (navireDamaged(ship, grille) == false){
//         if (ship.getTaille() > 1){

//             switch (position){
//                 //verticale
//                 case 0 : 

//                     switch (direction){

//                         case "bas" : 
//                             if (ApparitionBateau.balayageBas(ship, ship.getY(), ship.getX() , grille) >= 1 ){ 
//                                 String contenuGrilleB = grille.getContenuGrille(ship.getX(), ship.getY());
//                                 grille.cacherCaseGrille(ship.getX(), (ship.getY()-ship.getTaille())+1);
//                                 grille.grilleJeu[ship.getX()][(ship.getY() + 1)] = contenuGrilleB;
//                                 ship.setY((ship.getY() + 1));
//                                 System.out.println("Bateau déplacé en bas");
//                                 grille.afficherGrille();
//                               }else{System.out.println("Impossibilité d'aller plus bas");} 

//                         break;

//                         case "haut" : 

//                             if (ApparitionBateau.balayageHaut(ship, (ship.getY()- (ship.getTaille() - 1)), ship.getX(), grille) >= 1){
//                                 String contenuGrilleH = grille.getContenuGrille(ship.getX(), ship.getY());
//                                 grille.cacherCaseGrille(ship.getX(), ship.getY());
//                                 grille.grilleJeu[ship.getX()][(ship.getY() - ship.getTaille())] = contenuGrilleH;
//                                 ship.setY(ship.getY() -1);
//                                 System.out.println("Bateau déplacé en haut");
//                                 grille.afficherGrille();
//                             }else {System.out.println("Impossibilité d'aller plus haut");}   

//                         break;
//                     }
                
//                 break;
             
//                 case 1 : 

//                     switch (direction){

//                         case "bas" : 

//                             if (ApparitionBateau.balayageBas(ship, (ship.getY() + (ship.getTaille()-1)) , ship.getX(), grille) >= 1){
//                                 String contenuGrille = grille.getContenuGrille(ship.getX(), ship.getY());
//                                 grille.cacherCaseGrille(ship.getX(), ship.getY());
//                                 grille.grilleJeu[ship.getX()][(ship.getY() + ship.getTaille())] = contenuGrille;
//                                 ship.setY(ship.getY() + 1);
//                                 System.out.println("Bateau déplacé en bas");
//                                 grille.afficherGrille();
//                             }else {System.out.println("Impossibilité d'aller plus bas");}
                    
//                         break; 

//                         case "haut" : 

//                             if(ApparitionBateau.balayageHaut(ship, ship.getY(), ship.getX(), grille) >= 1){
//                                 String contenuGrille = grille.getContenuGrille(ship.getX(), ship.getY());
//                                 grille.cacherCaseGrille(ship.getX(),(ship.getY()+ship.getTaille()) -1);
//                                 grille.grilleJeu[ship.getX()][ship.getY() - 1] = contenuGrille;
//                                 ship.setY(ship.getY() - 1);
//                                 System.out.println("Bateau déplacé en haut");
//                                 grille.afficherGrille();
//                             }else {System.out.println("Impossibilité d'aller plus haut");}

//                         break; 
//                     }

//                 break;

//                 case 2 : 
//                     switch (direction){

//                         case "gauche" :

//                         if (ApparitionBateau.balayageGauche(ship, ship.getY(), ship.getX(), grille) >= 1){
//                             String contenuGrille = grille.getContenuGrille(ship.getX(), ship.getY());
//                             grille.cacherCaseGrille((ship.getX() + (ship.getTaille()-1)), ship.getY());
//                             grille.grilleJeu[ship.getX() - 1][ship.getY()] = contenuGrille;
//                             ship.setX(ship.getX() - 1);
//                             System.out.println("Bateau déplacé à gauche");
//                             grille.afficherGrille();
//                         }else{System.out.println("Impossibilité d'aller à gauche");}

//                         break;

//                         case "droite" :

//                         if(ApparitionBateau.balayageDroite(ship, ship.getY(), ship.getX() +(ship.getTaille() -1), grille) >= 1){
//                             String contenuGrille = grille.getContenuGrille(ship.getX(), ship.getY());
//                             grille.cacherCaseGrille(ship.getX(), ship.getY());
//                             grille.grilleJeu[ship.getX() + ship.getTaille()][ship.getY()] = contenuGrille;
//                             ship.setX(ship.getX() + 1);
//                             System.out.println("Bateau déplacé à droite");
//                             grille.afficherGrille();
//                         }else {System.out.println("Impossibilité d'aller à droite");}

//                         break;
//                     }

//                 break;

//                 case 3 : 

//                 switch (direction){

//                         case "gauche" : 

//                         if (ApparitionBateau.balayageGauche(ship, ship.getY(), (ship.getX() - (ship.getTaille() +1)), grille) >= 1){
//                             String contenuGrille = grille.getContenuGrille(ship.getX(), ship.getY());
//                             grille.cacherCaseGrille(ship.getX(), ship.getY());
//                             grille.grilleJeu[ship.getX()-ship.getTaille()][ship.getY()] = contenuGrille;
//                             ship.setX(ship.getX() - 1);
//                             System.out.println("Bateau déplacé à gauche");
//                             grille.afficherGrille();
//                         }else{System.out.println("Impossibilité d'aller à gauche");}

//                         break;

//                         case "droite" :

//                         if(ApparitionBateau.balayageDroite(ship, ship.getY(), ship.getX(), grille) >= 1){
//                             String contenuGrille = grille.getContenuGrille(ship.getX(), ship.getY());
//                             grille.cacherCaseGrille((ship.getX()-ship.getTaille())+1, ship.getY());
//                             grille.grilleJeu[ship.getX() + 1][ship.getY()] = contenuGrille;
//                             ship.setX(ship.getX() + 1);
//                             System.out.println("Bateau déplacé à droite");
//                             grille.afficherGrille();
//                         }else{System.out.println("Impossibilité d'aller à droite");}

//                         break;
//                 }
//                 break;
            
//             }

//             } else if (ship.getTaille() == 1){

//                 switch (direction){

//                     case "gauche" :
            
//                     if (ApparitionBateau.balayageGauche(ship, ship.getY(),ship.getX()-1,grille) == 1){
//                         String contenuGrille = grille.getContenuGrille(ship.getX(), ship.getY());
//                         grille.cacherCaseGrille(ship.getX(), ship.getY());
//                         grille.grilleJeu[ship.getX()-1][ship.getY()] = contenuGrille;
//                         System.out.println("Sous-Marin déplacé à gauche");
//                         ship.setX(ship.getX()-1);
//                         grille.afficherGrille();
//                     }else{System.out.println("Impossibilité d'aller à gauche");}

//                     break;


//                     case "droite" :

//                     if(ApparitionBateau.balayageDroite(ship, ship.getY(),ship.getX()+1,grille) == 1){
//                         String contenuGrille = grille.getContenuGrille(ship.getX(), ship.getY());
//                         grille.cacherCaseGrille(ship.getX(), ship.getY());
//                         grille.grilleJeu[ship.getX()+1][ship.getY()] = contenuGrille;
//                         System.out.println("Sous-Marin déplacé à droite");
//                         ship.setX(ship.getX()+1);
//                         grille.afficherGrille();
//                     }else{System.out.println("Impossibilité d'aller à droite");}

//                     break;

//                     case "haut" : 

//                     if(ApparitionBateau.balayageHaut(ship, ship.getY()-1,ship.getX(),grille) == 1){
//                         String contenuGrille = grille.getContenuGrille(ship.getX(), ship.getY());
//                         grille.cacherCaseGrille(ship.getX(), ship.getY());
//                         grille.grilleJeu[ship.getX()][ship.getY()-1] = contenuGrille;
//                         System.out.println("Sous-Marin déplacé en haut");
//                         ship.setY(ship.getY()-1);
//                         grille.afficherGrille();
//                     }else{System.out.println("Impossibilité d'aller plus haut");}

//                     break;

//                     case "bas" :

//                     if(ApparitionBateau.balayageBas(ship, ship.getY()+1,ship.getX(),grille) ==  1){
//                         String contenuGrille = grille.getContenuGrille(ship.getX(), ship.getY());
//                         grille.cacherCaseGrille(ship.getX(), ship.getY());
//                         grille.grilleJeu[ship.getX()][ship.getY()+1] = contenuGrille;
//                         System.out.println("Sous-Marin déplacé en bas");
//                         ship.setY(ship.getY()+1);
//                         grille.afficherGrille();
//                     }else{System.out.println("Impossibilité d'aller plus bas");}
//                 }    
//         }
//         }else {System.out.println("VOTRE BATEAU EST ENDOMMAGER VOUS NE POUVEZ PAS LE DEPLACER");}      
//     }

    public boolean navireDamaged(Ship navire, Grille grille){

        boolean status = false;

        for (int i = 0; i < navire.getTaille(); i++){

            Coordonnees coordonnes = navire.getCaseShip(i);

            if (grille.tableauJeu[coordonnes.getX()][coordonnes.getY()]==" ## "){
                status = true;
            }
        }
        return status;
    }
}
    



                



    


