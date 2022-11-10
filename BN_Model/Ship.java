package BN_Model;


public class Ship extends Coordonnees {
    private caracteristiquesBateaux bateau;
    private int orientation;

    

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
    }

