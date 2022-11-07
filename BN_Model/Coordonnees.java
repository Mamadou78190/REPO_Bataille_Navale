package BN_Model;

import java.util.concurrent.TimeUnit;

public class Coordonnees {
    protected int x;
    protected int y;

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
    public void setImpact (Coordonnees tir,int puissance, Grille grille) throws InterruptedException
    {
        
        int xTir = tir.getX();
        int yTir = tir.getY();

        // Gestion des bords de la grille
        if (tir.getY()>=grille.getTailleOrdonnees()-1 )
        {
            yTir=tir.getY()-1;
        }
        else if (tir.getY()<=0 && puissance==9)
        {
            yTir=tir.getY()+1;
        }

        if (tir.getX()>=grille.getTailleAbscisse()-1)
        {
            xTir=tir.getX()-1;
        }
        else if (tir.getX()<=0 && puissance==9)
        {
            xTir=tir.getX()+1;
        }
        /////////////////////////////////////////////////

        switch (puissance)
        {
            case 9:
            for (int i=yTir-1; i<=yTir+1; i++)
            {
                for (int j=xTir-1; j<=xTir+1; j++)
                {
                    grille.afficherCaseGrille(j, i, "BOOM");
                }
            }
            break;

            case 4:
            for (int i=yTir; i<=yTir+1; i++)
            {
                for (int j=xTir; j<=xTir+1; j++)
                {
                    grille.afficherCaseGrille(j, i, "BOOM");
                }
            }
            break;

            case 1:
            grille.afficherCaseGrille(x, y, "BOOM");
            break;

            default:
            
            for (int i=0; i<grille.getTailleOrdonnees(); i++)
            {
                for (int j=0; j<grille.getTailleAbscisse(); j++)
                {
                    grille.afficherCaseGrille(j, i, "XXXX");
                }
            }
            grille.afficherGrille();
            System.out.println("\n\nLa puissance d'impact est atomique, vous avez detruit nos radars !!");
            System.out.println("\nRetablissement du signal dans 5");
            for (int i=4; i>=0; i--)
            {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("                              "+i);

            }
            grille.reinitialisationGrille();
            break;

        }
    }
}