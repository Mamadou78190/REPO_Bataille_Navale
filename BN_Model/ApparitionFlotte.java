// package BN_Model;
// import java.util.Random;

// public class ApparitionFlotte{

//     public static int balayageHaut(Ship p1, int ordonnees, int abscisses, Grille g1){

//         int cmpt = 0;
//                 for (int i= 0; i<p1.getTaille(); i++){
//                     if (((ordonnees) - i) >= 0 && g1.tableauJeu [abscisses][ordonnees-i] == " ~~ "){
//                       cmpt = cmpt +1;
//                     } 
//                 }
//         return cmpt; 

//     }

//     public static int balayageBas(Ship p1, int ordonnees, int abscisses, Grille g1){
//         int cmpt = 0;

//         for (int i= 0; i<p1.getTaille(); i++){
//             if (((ordonnees)+i) <= (g1.getTailleAbscisse()-1) && g1.tableauJeu [abscisses][ordonnees+i] == " ~~ "){
//                 cmpt = cmpt+1;
//             }
//         }
//         return cmpt;
//     }

//     public static int balayageGauche(Ship p1, int ordonnees, int abscisses, Grille g1){
//         int cmpt = 0;

//         for (int i= 0; i<p1.getTaille(); i++){
//             if (((abscisses)- i ) >= 0 && g1.tableauJeu [abscisses-i][ordonnees] == " ~~ "){
//                     cmpt = cmpt + 1;
//             }
//         }

//         return cmpt;
//     }

//     public static int balayageDroite(Ship p1, int ordonnees, int abscisses, Grille g1){
//         int cmpt = 0;

//         for (int i= 0; i<p1.getTaille(); i++){
//             if (((abscisses)+i) <= (g1.getTailleAbscisse()-1) && g1.tableauJeu [abscisses+i][ordonnees] == " ~~ "){
//                 cmpt = cmpt + 1;
//            }
//        }

//         return cmpt;
//     }
     
//     public String flotteGrille(Grille g1, Ship p1, int indexShipFromFlotte){

//         //Coordonnées aléatoires
// 		Random randomAbscisse = new Random();
// 		Random randomOrdonnee = new Random();
// 		int abscisses;
// 		int ordonnees;
//         boolean disponibilite = false; 
//         boolean jetonBas = false;
//         boolean jetonHaut = false;
//         boolean jetonGauche = false;
//         boolean jetonDroit = false;


    
//             do {

//               abscisses = randomAbscisse.nextInt(g1.getTailleAbscisse());
// 		      ordonnees = randomOrdonnee.nextInt(g1.getTailleOrdonnees());

//                 if (balayageBas(p1, ordonnees, abscisses, g1) == p1.getTaille()){
//                     jetonBas = true;
//                     disponibilite = true;
//                 } if (balayageDroite(p1, ordonnees, abscisses, g1) == p1.getTaille()){
//                     jetonDroit = true;
//                     disponibilite = true;
//                 } if (balayageGauche(p1, ordonnees, abscisses, g1) == p1.getTaille()){
//                     jetonGauche = true;
//                     disponibilite = true;
//                 } if (balayageHaut(p1, ordonnees, abscisses, g1) == p1.getTaille()){
//                     jetonHaut = true;
//                     disponibilite = true;
//                 }
//             }while(disponibilite == false);


//             // Random random3 = new Random();
//             int position = 0;//random3.nextInt(3);

//         switch (position) {

//             case 0 : 
//                 //haut
//                 if (jetonHaut){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.contenuCaseGrille(abscisses,ordonnees-i,indexShipFromFlotte , p1.getVisuel());
//                         position = 0;
//                     }
//                 }else if (jetonBas){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.contenuCaseGrille(abscisses,ordonnees+i,indexShipFromFlotte , p1.getVisuel());
//                         position = 1;
//                     }
//                 }else if (jetonGauche){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.contenuCaseGrille(abscisses-i,ordonnees,indexShipFromFlotte , p1.getVisuel());
//                         position = 3;
//                     }
//                 }else if (jetonDroit){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.contenuCaseGrille(abscisses+i,ordonnees,indexShipFromFlotte, p1.getVisuel());
//                         position = 2;
//                     }
//                 }

//             break; 

//             case 1 : 
//                 //bas
//                 if (jetonBas){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.tableauJeu[abscisses][ordonnees + i] = p1.getVisuel();
//                         position = 1;
//                     }
//                 }else if (jetonHaut){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.tableauJeu[abscisses][ordonnees - i] = p1.getVisuel();
//                         position = 0;
//                     }
//                 }else if (jetonDroit){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.tableauJeu[abscisses + i][ordonnees] = p1.getVisuel();
//                         position = 2;
//                     }
//                 }else if (jetonGauche){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.tableauJeu[abscisses - i][ordonnees] = p1.getVisuel();
//                         position = 3;
//                     }
//                 }
//             break; 

//             case 2 : 
//                 //droit
//                 if (jetonDroit){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.tableauJeu[abscisses + i][ordonnees] = p1.getVisuel();
//                         position = 2;
//                     }
//                 }else if (jetonGauche){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.tableauJeu[abscisses - i][ordonnees] = p1.getVisuel();
//                         position = 3;
//                     }
//                 }else if (jetonHaut){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.tableauJeu[abscisses][ordonnees - i] = p1.getVisuel();
//                         position = 0;
//                     }
//                 }else if (jetonBas){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.tableauJeu[abscisses][ordonnees + i] = p1.getVisuel();
//                         position = 1;
//                     }
//                 }
//             break; 

//             case 3 : 
//                 //gauche
//                 if (jetonGauche){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.tableauJeu[abscisses - i][ordonnees] = p1.getVisuel();
//                         position = 3;
//                     }
//                 }else if (jetonDroit){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.tableauJeu[abscisses + i][ordonnees] = p1.getVisuel();
//                         position = 2;
//                     }
//                 }else if (jetonHaut){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.tableauJeu[abscisses][ordonnees - i] = p1.getVisuel();
//                         position = 0;
//                     }
//                 }else if (jetonBas){
//                     for (int i = 0; i<p1.getTaille(); i++){
//                         g1.tableauJeu[abscisses][ordonnees + i] = p1.getVisuel();
//                         position = 1;
//                     }
//                 }

//             break;


//         }

//         p1.setX(abscisses);
//         p1.setY(ordonnees);
//         p1.setOrientation(position);

//         return "position : " +position + " abscisses : " +abscisses + " ordonnées : " + ordonnees;

//     } 

    
    
// }
