package BN_Model;


public class Coordonnees {
    protected int x;
    protected int y;


    public Coordonnees()
    {}
    public Coordonnees (int x, int y)
    {
        // super();
        this.x=x;
        this.y=y;
    }

    public void setXY (int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public void setX (int x)
    {
        this.x=x;
    }

    public int getX ()
    {
        return this.x;
    }

    public void setY (int y)
    {
        this.y=y;
    }

    public int getY ()
    {
        return this.y;
    }
    

    // ATTRIBUER CETTE METHODE DANS UNE CLASSE QUI LUI CONVIENT MIEUX
    
}