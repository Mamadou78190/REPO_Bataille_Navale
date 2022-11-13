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

    public String getStringFlotte()
    {
        String s = new String();
        for (int i=0;i<10;i++)
        {
            s = s + " { N° "+i + " / " +flotte[i];
            
        }
        return s;
    }

    public void isDeadOnArray(Flotte flotte, Grille grille){

        for (int i=0; i<flotte.getFlotteSize(); i++){
            if(flotte.getShipFromFlotte(i).isDead(flotte.getShipFromFlotte(i), grille)){

                for (int j = 0; j < flotte.getShipFromFlotte(i).getTaille(); j++){

                    Coordonnees coordonnes = flotte.getShipFromFlotte(i).getCaseNavire(j);

                    grille.tableauJeu[coordonnes.getX()][coordonnes.getY()] = "DEAD";

                }
            }
        }
    }

}
