package model;
public class Flotte {

    private Ship flotte1[] = new Ship[10];
    private Ship flotte2[] = new Ship[10];


    public Flotte()

    {

        for (int i=0;i<4;i++){
            flotte1[i] = new Ship(caracteristiquesBateaux.sousMarin);
            flotte2[i] = new Ship(caracteristiquesBateaux.sousMarin);
        }

        for (int i=4;i<7;i++){
            flotte1[i] = new Ship(caracteristiquesBateaux.destroyer);
            flotte2[i] = new Ship(caracteristiquesBateaux.destroyer);
        }

        for (int i=7;i<9;i++){
            flotte1[i] = new Ship(caracteristiquesBateaux.croiseur);
            flotte2[i] = new Ship(caracteristiquesBateaux.croiseur);
        }

        for (int i=9;i<10;i++){
            flotte1[i]  = new Ship(caracteristiquesBateaux.cuirasse);
            flotte2[i]  = new Ship(caracteristiquesBateaux.cuirasse);
        }

        for (int i = 0;i<10;i++){
            System.out.println(flotte1[i]);
            System.out.println(flotte2[i]);
        }


    }
}
