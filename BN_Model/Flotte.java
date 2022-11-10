package BN_Model;
public class Flotte {

    private Ship flotte[] = new Ship[10];//Flotte ami


    public Flotte()

    {

        for (int i=0;i<4;i++){//creation de 4 sous-marin
            flotte[i] = new Ship(caracteristiquesBateaux.sousMarin);
        }

        for (int i=4;i<7;i++){//creation de 3 destroyer
            flotte[i] = new Ship(caracteristiquesBateaux.destroyer);
        }

        for (int i=7;i<9;i++){//creation de 2 croiseur
            flotte[i] = new Ship(caracteristiquesBateaux.croiseur);
        }

        for (int i=9;i<10;i++){//creation de 1 cuirasse
            flotte[i] = new Ship(caracteristiquesBateaux.cuirasse);
        }

    }

    public int getFlotteSize() {
        return flotte.length;
    }

    public Ship getShipFromFlotte(int index) {
        return flotte[index];
    }

    public void afficherFlotte()
    {
        for (int i=0;i<10;i++)
        {
            System.out.println("Numero du bateau : "+i + "  " +flotte[i]);
            
        }
    }

}
