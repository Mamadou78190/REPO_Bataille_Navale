package BN_Model;

import java.io.Serializable;

public class Flotte extends Ship implements Serializable {

    private Ship flotte[] = new Ship[10];


    public Flotte()

    {
        super();
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

    public String getStringFlotte()
    {
        String s = new String();
        for (int i=0;i<10;i++)
        {
            s = s + " { N° "+i + " / " +flotte[i];
            
        }
        return s;
    }

}
