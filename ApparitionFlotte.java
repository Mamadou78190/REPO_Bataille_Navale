import java.util.Random;

public class ApparitionFlotte{

    public static int balayageHaut(Navire p1, int ordonnees, int abscisses, Grille g1){

        int cmpt = 0;
                for (int i= 0; i<p1.taille; i++){
                    if (((ordonnees) - i) >= 0 && g1.grilleJeu [abscisses][ordonnees-i] == " ~~ "){
                      cmpt = cmpt +1;
                    }else{cmpt = cmpt;} 
                }
        return cmpt; 

    }

    public static int balayageBas(Navire p1, int ordonnees, int abscisses, Grille g1){
        int cmpt = 0;

        for (int i= 0; i<p1.taille; i++){
            if (((ordonnees)+i) <= (g1.getTailleAbscisse()-1) && g1.grilleJeu [abscisses][ordonnees+i] == " ~~ "){
                cmpt = cmpt+1;
            }else {cmpt = cmpt;}
        }
        return cmpt;
    }

    public static int balayageGauche(Navire p1, int ordonnees, int abscisses, Grille g1){
        int cmpt = 0;

        for (int i= 0; i<p1.taille; i++){
            if (((abscisses)- i ) >= 0 && g1.grilleJeu [abscisses-i][ordonnees] == " ~~ "){
                    cmpt = cmpt + 1;
            }else {cmpt = cmpt;}
        }

        return cmpt;
    }

    public static int balayageDroite(Navire p1, int ordonnees, int abscisses, Grille g1){
        int cmpt = 0;

        for (int i= 0; i<p1.taille; i++){
            if (((abscisses)+i) <= (g1.getTailleAbscisse()-1) && g1.grilleJeu [abscisses+i][ordonnees] == " ~~ "){
                cmpt = cmpt + 1;
           }else {cmpt = cmpt;}
       }

        return cmpt;
    }
     
    public String flotteGrille(Grille g1, Navire p1){

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

              abscisses = 3;//random.nextInt(g1.getTailleAbscisse());
		      ordonnees = 3;//random2.nextInt(g1.getTailleOrdonnees());

                if (balayageBas(p1, ordonnees, abscisses, g1) == p1.taille){
                    jetonBas = true;
                    z = true;
                } if (balayageDroite(p1, ordonnees, abscisses, g1) == p1.taille){
                    jetonDroit = true;
                    z = true;
                } if (balayageGauche(p1, ordonnees, abscisses, g1) == p1.taille){
                    jetonGauche = true;
                    z = true;
                } if (balayageHaut(p1, ordonnees, abscisses, g1) == p1.taille){
                    jetonHaut = true;
                    z = true;
                }
            }while(z == false);


            Random random3 = new Random();
            int position = 3;//random3.nextInt(3);

        switch (position) {

            case 0 : 
                //haut
                if (jetonHaut == true){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[abscisses][ordonnees - i] = p1.caractere;
                        position = 0;
                    }
                }else if (jetonBas){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[abscisses][ordonnees + i] = p1.caractere;
                        position = 1;
                    }
                }else if (jetonGauche){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[abscisses - i][ordonnees] = p1.caractere;
                        position = 3;
                    }
                }else if (jetonDroit){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[abscisses + i][ordonnees] = p1.caractere;
                        position = 2;
                    }
                }

            break; 

            case 1 : 
                //bas
                if (jetonBas){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[abscisses][ordonnees + i] = p1.caractere;
                        position = 1;
                    }
                }else if (jetonHaut){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[abscisses][ordonnees - i] = p1.caractere;
                        position = 0;
                    }
                }else if (jetonDroit){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[abscisses + i][ordonnees] = p1.caractere;
                        position = 2;
                    }
                }else if (jetonGauche){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[abscisses - i][ordonnees] = p1.caractere;
                        position = 3;
                    }
                }
            break; 

            case 2 : 
                //droit
                if (jetonDroit){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[abscisses + i][ordonnees] = p1.caractere;
                        position = 2;
                    }
                }else if (jetonGauche){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[abscisses - i][ordonnees] = p1.caractere;
                        position = 3;
                    }
                }else if (jetonHaut){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[p1.getAbscisse()][p1.getOrdonnees() - i] = p1.caractere;
                        position = 0;
                    }
                }else if (jetonBas){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[abscisses][ordonnees + i] = p1.caractere;
                        position = 1;
                    }
                }
            break; 

            case 3 : 
                //gauche
                if (jetonGauche){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[abscisses - i][ordonnees] = p1.caractere;
                        position = 3;
                    }
                }else if (jetonDroit){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[abscisses + i][ordonnees] = p1.caractere;
                        position = 2;
                    }
                }else if (jetonHaut){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[p1.getAbscisse()][p1.getOrdonnees() - i] = p1.caractere;
                        position = 0;
                    }
                }else if (jetonBas){
                    for (int i = 0; i<p1.taille; i++){
                        g1.grilleJeu[abscisses][ordonnees + i] = p1.caractere;
                        position = 1;
                    }
                }

            break;


        }

        p1.setAbscisse(abscisses);
        p1.setOrdonnees(ordonnees);
        p1.setPosition(position);

        return "position : " +position + " abscisses : " +abscisses + " ordonnées : " + ordonnees;

    } 

    
    
}
