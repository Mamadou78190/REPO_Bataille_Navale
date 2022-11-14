package BN_Model;


public class Shoot extends Coordonnees {

    int puissance;
    
    public Shoot(int x, int y, int puissance) {
        super(x, y);
        this.puissance = puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public int getPuissance() {
        return puissance;
    }

}
