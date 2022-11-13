package BN_Model;

import java.util.ArrayList;

public class Ship extends Coordonnees {
    private caracteristiquesBateaux bateau;
    private int orientation;
    ArrayList<Coordonnees> navires = new ArrayList();
    
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

    @Override
    public String toString() {
        return bateau.toString()+", orientation= "+this.getOrientation()+", abscisse= "+this.getX()+", ordonnees= "+this.getY();
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

    public ArrayList getCoordonneesNavire(){
        return navires;
    }


    public void setNavires(int x, int y, Ship bateau) {

        Coordonnees coordonnees = new Coordonnees(x, y);
        navires.add(coordonnees);

    }

    public Coordonnees getCaseNavire (int index){

        return navires.get(index);

    }

    public boolean isDead(Ship navire, Grille grille){

        int cmpt = 0;
        boolean isDead = false;

        for (int i = 0; i < navire.getTaille(); i++)
        {
            Coordonnees coordonnes = navire.getCaseNavire(i);
            if (grille.grilleJeu[coordonnes.getX()][coordonnes.getY()]==" ## ")
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
    
}

