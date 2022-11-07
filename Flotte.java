package model;
public class Flotte {

    private Ship flotte1[] = new Ship[10];//Flotte ami
    private Ship flotte2[] = new Ship[10];//Flotte enemie


    public Flotte()

    {

        for (int i=0;i<4;i++){//creation de 4 sous-marin
            flotte1[i] = new Ship(caracteristiquesBateaux.sousMarin);
            flotte2[i] = new Ship(caracteristiquesBateaux.sousMarin);
        }

        for (int i=4;i<7;i++){//creation de 3 destroyer
            flotte1[i] = new Ship(caracteristiquesBateaux.destroyer);
            flotte2[i] = new Ship(caracteristiquesBateaux.destroyer);
        }

        for (int i=7;i<9;i++){//creation de 2 croiseur
            flotte1[i] = new Ship(caracteristiquesBateaux.croiseur);
            flotte2[i] = new Ship(caracteristiquesBateaux.croiseur);
        }

        for (int i=9;i<10;i++){//creation de 1 cruirasse
            flotte1[i]  = new Ship(caracteristiquesBateaux.cuirasse);
            flotte2[i]  = new Ship(caracteristiquesBateaux.cuirasse);
        }

        for (int i = 0;i<10;i++){//teste affichage des liste
            System.out.println(flotte1[i]);
            System.out.println(flotte2[i]);
        }


    }
}
