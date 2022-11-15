
package BN_Model;

public class Damaged {

    public boolean navireDamaged(Ship navire, Grille grille){

        boolean status = false;

        for (int i = 0; i < navire.getTaille(); i++){

            Coordonnees coordonnes = navire.getCaseShip(i);

            if (grille.tableauJeu[coordonnes.getX()][coordonnes.getY()]==" ## " || grille.tableauJeu[coordonnes.getX()][coordonnes.getY()]=="DEAD"){
                status = true;
            }
        }
        return status;
    }
}
    



                



    


