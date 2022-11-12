package BN_Model;

import java.util.concurrent.TimeUnit;

public class Shoot extends Coordonnees {

    int puissance;

    public Shoot(int x, int y, int puissance) {
        super(x,y);
        this.puissance = puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }
    public int getPuissance() {
        return puissance;
    }

    public void setImpact (Grille grille) throws InterruptedException
    {
        
        int shootX = this.getX();
        int shootY = this.getY();

        // Gestion des bords de la grille
        if (this.getY()>=grille.getTailleOrdonnees()-1 )
        {
            shootY=this.getY()-1;
        }
        else if (this.getY()<=0 && puissance==9)
        {
            shootY=this.getY()+1;
        }

        if (this.getX()>=grille.getTailleAbscisse()-1)
        {
            shootX=this.getX()-1;
        }
        else if (this.getX()<=0 && puissance==9)
        {
            shootX=this.getX()+1;
        }
        /////////////////////////////////////////////////

        // switch (puissance)
        // {
        //     case 9:
        //         for (int i=shootY-1; i<=shootY+1; i++)
        //         {
        //             for (int j=shootX-1; j<=shootX+1; j++)
        //             {
        //                 if (grille.grilleJeu[j][i] != " ~~ "){
        //                     grille.afficherCaseGrille(j, i,-1, "BOOM");
        //                 }else{
        //                     grille.afficherCaseGrille(j, i,-1, "PLOP");
        //                 }
        //             }
                
        //         }
        //         grille.afficherGrille();

        //         for (int i=shootY-1; i<=shootY+1; i++)
        //         {
        //             for (int j=shootX-1; j<=shootX+1; j++)
        //             {
        //                 if (grille.grilleJeu[j][i] == "BOOM"){
        //                     grille.afficherCaseGrille(j, i,-1, " ## ");
        //                 }else{
        //                     grille.afficherCaseGrille(j, i,-1, " ~~ ");
        //                 }
        //             }
        //         }
        //         grille.afficherGrille();

        //     break;

        //     case 4:
        //         for (int i=shootY; i<=shootY+1; i++)
        //         {
        //             for (int j=shootX; j<=shootX+1; j++)
        //             {
        //                 if (grille.grilleJeu[j][i]!= " ~~ "){
        //                     grille.afficherCaseGrille(j, i,-1, "BOOM");
        //                 }else{
        //                     grille.afficherCaseGrille(j, i,-1, "PLOP");
        //                 }
        //             }  
        //         }
        //         grille.afficherGrille();

        //         for (int i=shootY; i<=shootY+1; i++)
        //         {
        //             for (int j=shootX; j<=shootX+1; j++)
        //             {
        //                 if (grille.grilleJeu[j][i]== "BOOM"){
        //                     grille.afficherCaseGrille(j, i,-1, " ## ");
        //                 }else{
        //                     grille.afficherCaseGrille(j, i,-1, " ~~ ");
        //                 }
        //             }
        //         }
        //         grille.afficherGrille();

        //     break;

        //     case 1:

        //         if (grille.grilleJeu[x][y]!= " ~~ "){
        //             grille.afficherCaseGrille(x, y,-1, "BOOM");
        //         }else{
        //             grille.afficherCaseGrille(x, y,-1, "PLOP");
        //         }
        //         grille.afficherGrille();

        //         if (grille.grilleJeu[x][y]== "BOOM"){
        //             grille.afficherCaseGrille(x, y,-1, " ## ");
        //         }else{
        //             grille.afficherCaseGrille(x, y,-1, " ~~ ");
        //         }
        //         grille.afficherGrille();
        //     break;

        //     default:
            
        //     for (int i=0; i<grille.getTailleOrdonnees(); i++)
        //     {
        //         for (int j=0; j<grille.getTailleAbscisse(); j++)
        //         {
        //             grille.afficherCaseGrille(j, i,-1, "XXXX");
        //         }
        //     }
        //     grille.afficherGrille();
        //     System.out.println("\n\nLa puissance d'impact est atomique, vous avez detruit nos radars !!");
        //     System.out.println("\nRetablissement du signal dans 5");
        //     for (int i=4; i>=0; i--)
        //     {
        //         TimeUnit.SECONDS.sleep(1);
        //         System.out.println("                              "+i);

        //     }
        //     grille.reinitialisationGrille();
        //     break;

        // }
        // }
    
}
