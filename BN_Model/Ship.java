package BN_Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Ship extends Coordonnees implements Serializable {
    private caracteristiquesBateaux bateau;
    private int orientation;
    private boolean isDead = false;
    private String stringIsDead = "ALIVE";
    ArrayList<Coordonnees> navireCoordonneesList = new ArrayList<Coordonnees>();
    
    public Ship() {}
    public Ship(caracteristiquesBateaux bateau) {
        
        this.bateau = bateau;
    }

    public int getPuissance(){
       return  bateau.getpuissance();
    }

    public int getTaille(){
        return bateau.getTaille();
    }

    public String getVisuel(){
        return bateau.getVisuel();
    }

    // public int getAbscisse() {
    //     return abscisse;
    // }
    // public void setAbscisse(int abscisse) {
    //   this.abscisse = abscisse;
    // }
    // public int getOrdonnees() {
    //     return ordonnees;
    // }
    // public void setOrdonnees(int ordonnees) {
    //     this.ordonnees = ordonnees;
    // }

    public int getOrientation() {
        return orientation;
    }
    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public ArrayList<Coordonnees> getArrayCoordonneesShip(){
        return navireCoordonneesList;
    }

    public void setArrayCoordonneesShip(ArrayList<Coordonnees> navires) {
        this.navireCoordonneesList = navires;
    }

    public int getCaseShipX(int index){

        return navireCoordonneesList.get(index).getX();

    }

    public int getCaseShipY(int index){

        return navireCoordonneesList.get(index).getY();

    }

    // public Taille getTaille() {
    //     return taille;
    // }
    // public PuissanceDeTire getPuissanceDeTire() {
    //     return puissanceDeTire;
    // }

   // @Override
  //  public String toString() {
   //     return "Ship{" +
     //           bateau.getName()+
       //         "  "+
         //       "taille=" + bateau.getTaille() +
           //     ", puissanceDeTire=" + bateau.getpuissance() +
            //    '}';

<<<<<<< HEAD

    public ArrayList<Coordonnees> getCoordonneesNavire(){

        return navires;

=======
    public ArrayList<Coordonnees> getCoordonneesShip() {
        return navireCoordonneesList;
>>>>>>> Developpement
    }

    public void setCoordonneesShip(int x, int y, Ship bateau) {

        Coordonnees coordonnees = new Coordonnees(x, y);
        navireCoordonneesList.add(coordonnees);

    }

    public Coordonnees getCaseShip (int index){

        return navireCoordonneesList.get(index);

    }

<<<<<<< HEAD
    public boolean isDead(Ship navire, Grille grille){

        int cmpt = 0;
        boolean isDead = false;

        for (int i = 0; i < navire.getTaille(); i++)
        {
            Coordonnees coordonnes = navire.getCaseNavire(i);
            if (grille.tableauJeu[coordonnes.getX()][coordonnes.getY()]==" ## ")
            {
                cmpt++;
            }
        }
        if (cmpt == navire.getTaille())
        {
            isDead = true;
        }
        return isDead;
    }
=======
    public void setIsDead() {
        stringIsDead = "DEAD";
        isDead = true;
    }

>>>>>>> Developpement

    @Override
    public String toString() {
        return bateau.toString()+" / Orientation "+orientation +"/ Coordonnees : "+navireCoordonneesList.toString()+
        " } "+stringIsDead+ "\n";
    }
    
}

