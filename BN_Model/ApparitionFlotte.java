package BN_Model;
import java.util.Random;

public class ApparitionFlotte{

    public static int balayageHaut(Ship p1, int ordonnees, int abscisses, Grille g1){

        int cmpt = 0;
                for (int i= 0; i<p1.getTaille(); i++){
                    if (((ordonnees) - i) >= 0 && g1.grilleJeu [abscisses][ordonnees-i] == " ~~ "){
                      cmpt = cmpt +1;
                    }else{cmpt = cmpt;} 
                }
        return cmpt; 

    }

    public static int balayageBas(Ship p1, int ordonnees, int abscisses, Grille g1){
        int cmpt = 0;

        for (int i= 0; i<p1.getTaille(); i++){
            if (((ordonnees)+i) <= (g1.getTailleAbscisse()-1) && g1.grilleJeu [abscisses][ordonnees+i] == " ~~ "){
                cmpt = cmpt+1;
            }else {cmpt = cmpt;}
        }
        return cmpt;
    }

    public static int balayageGauche(Ship p1, int ordonnees, int abscisses, Grille g1){
        int cmpt = 0;

        for (int i= 0; i<p1.getTaille(); i++){
            if (((abscisses)- i ) >= 0 && g1.grilleJeu [abscisses-i][ordonnees] == " ~~ "){
                    cmpt = cmpt + 1;
            }else {cmpt = cmpt;}
        }

        return cmpt;
    }

    public static int balayageDroite(Ship p1, int ordonnees, int abscisses, Grille g1){
        int cmpt = 0;

        for (int i= 0; i<p1.getTaille(); i++){
            if (((abscisses)+i) <= (g1.getTailleAbscisse()-1) && g1.grilleJeu [abscisses+i][ordonnees] == " ~~ "){
                cmpt = cmpt + 1;
           }else {cmpt = cmpt;}
       }

        return cmpt;
    }
     
    public String flotteGrille(Grille g1, Ship p1){

        //Coordonnées aléatoires
		Random random = new Random();
		Random random2 = new Random();
		int abscisses;
		int ordonnees;
        boolean z = false; 
        boolean jetonBas = false;
        boolean jetonHaut = false;
        boolean jetonGauche = false;
        boolean jetonDroit = false;


    
            do {

              abscisses = random.nextInt(g1.getTailleAbscisse());
		      ordonnees = random2.nextInt(g1.getTailleOrdonnees());

                if (balayageBas(p1, ordonnees, abscisses, g1) == p1.getTaille()){
                    jetonBas = true;
                    z = true;
                } if (balayageDroite(p1, ordonnees, abscisses, g1) == p1.getTaille()){
                    jetonDroit = true;
                    z = true;
                } if (balayageGauche(p1, ordonnees, abscisses, g1) == p1.getTaille()){
                    jetonGauche = true;
                    z = true;
                } if (balayageHaut(p1, ordonnees, abscisses, g1) == p1.getTaille()){
                    jetonHaut = true;
                    z = true;
                }
            }while(z == false);


            Random random3 = new Random();
            int position = random3.nextInt(3);

        switch (position) {

            case 0 : 
                //haut
                if (jetonHaut == true){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[abscisses][ordonnees - i] = p1.getVisuel();
                        position = 0;
                    }
                }else if (jetonBas){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[abscisses][ordonnees + i] = p1.getVisuel();
                        position = 1;
                    }
                }else if (jetonGauche){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[abscisses - i][ordonnees] = p1.getVisuel();
                        position = 3;
                    }
                }else if (jetonDroit){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[abscisses + i][ordonnees] = p1.getVisuel();
                        position = 2;
                    }
                }

            break; 

            case 1 : 
                //bas
                if (jetonBas){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[abscisses][ordonnees + i] = p1.getVisuel();
                        position = 1;
                    }
                }else if (jetonHaut){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[abscisses][ordonnees - i] = p1.getVisuel();
                        position = 0;
                    }
                }else if (jetonDroit){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[abscisses + i][ordonnees] = p1.getVisuel();
                        position = 2;
                    }
                }else if (jetonGauche){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[abscisses - i][ordonnees] = p1.getVisuel();
                        position = 3;
                    }
                }
            break; 

            case 2 : 
                //droit
                if (jetonDroit){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[abscisses + i][ordonnees] = p1.getVisuel();
                        position = 2;
                    }
                }else if (jetonGauche){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[abscisses - i][ordonnees] = p1.getVisuel();
                        position = 3;
                    }
                }else if (jetonHaut){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[p1.getX()][p1.getY() - i] = p1.getVisuel();
                        position = 0;
                    }
                }else if (jetonBas){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[abscisses][ordonnees + i] = p1.getVisuel();
                        position = 1;
                    }
                }
            break; 

            case 3 : 
                //gauche
                if (jetonGauche){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[abscisses - i][ordonnees] = p1.getVisuel();
                        position = 3;
                    }
                }else if (jetonDroit){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[abscisses + i][ordonnees] = p1.getVisuel();
                        position = 2;
                    }
                }else if (jetonHaut){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[p1.getX()][p1.getY() - i] = p1.getVisuel();
                        position = 0;
                    }
                }else if (jetonBas){
                    for (int i = 0; i<p1.getTaille(); i++){
                        g1.grilleJeu[abscisses][ordonnees + i] = p1.getVisuel();
                        position = 1;
                    }
                }

            break;


        }

        p1.setX(abscisses);
        p1.setY(ordonnees);
        p1.setOrientation(position);

        return "position : " +position + " abscisses : " +abscisses + " ordonnées : " + ordonnees;

    } 

    
    
}
