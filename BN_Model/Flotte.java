package BN_Model;
public class Flotte {

    private Ship flotte[] = new Ship[10];//Flotte ami


    public Flotte()

    {

        for (int i=0;i<4;i++){//creation de 4 sous-marin
            flotte[i] = new Ship(0,0,caracteristiquesBateaux.sousMarin);
        }

        for (int i=4;i<7;i++){//creation de 3 destroyer
            flotte[i] = new Ship(0,0,caracteristiquesBateaux.destroyer);
        }

        for (int i=7;i<9;i++){//creation de 2 croiseur
            flotte[i] = new Ship(0,0,caracteristiquesBateaux.croiseur);
        }

    }

    public void afficherFlotte()
    {
        for (int i=0;i<10;i++)
        {
            System.out.println(flotte[i]);
        }
    }

}
