public class Grille {

    public String grilleJeu [][]; 
    private int taille_abscisse;
    private int taille_ordonnees;
    

    public Grille(int taille_abscisse,int taille_ordonnees)
    {
        this.taille_abscisse=taille_abscisse;
        this.taille_ordonnees=taille_ordonnees;
        this.grilleJeu = new String[taille_abscisse][taille_ordonnees];
        for (int i = 0; i < taille_abscisse; i++) {
            for (int j = 0; j < taille_ordonnees; j++) {
                cacherCaseGrille(i, j); 
            }
        }
       
    }

   
    public int getTailleAbscisse()
    {
        return taille_abscisse;
    }

    public int getTailleOrdonnees()
    {
        return taille_ordonnees;
    }


    public void reinitialisationGrille()
    {
        for (int i = 0; i < taille_abscisse; i++) {
            for (int j = 0; j < taille_ordonnees; j++) {
                cacherCaseGrille(i, j); 
            }
        }
    }

    public void afficherGrille() 
    {
        
        System.out.print("\n\ny--x");

        calibrageGrilleSuivantNombreCaracteresDansCase("repereAbscisse");
        
        System.out.println();

        for (int i = 0; i < taille_ordonnees; i++) {
            //affichage du repere y 
            if (i<10)
            {
                System.out.print(i+"  ");
            }
            else
            {
                System.out.print(i+" ");
            }
            ////////////////////////////////

            //affichage grille
            for (int j = 0; j < taille_abscisse; j++) {
                
                System.out.print("|");
                System.out.print(grilleJeu[j][i]);
                
            }
            ////////////////////////////////

            calibrageGrilleSuivantNombreCaracteresDansCase("separationHorizontale");
        }
    }

    public void calibrageGrilleSuivantNombreCaracteresDansCase (String situation)
    {
        switch (situation) 
        {
            case "separationHorizontale":
            System.out.println("|");
            System.out.print("   ");
                for (int k = 0; k < taille_abscisse; k++) {
                    System.out.print("|");
                    for (int i = 0; i < grilleJeu[0][0].length(); i++) {
                        System.out.print("-");
                    }
                    
                }
                System.out.println("|");
                break;


            case "repereAbscisse": //attention ce calibrage ne fonctionne que pour un repere d'abscisses entre 0 et 100 non inclus
                for (int j = 0; j < taille_abscisse; j++) {  
                    if (grilleJeu[0][0].length()%2==0)
                    {
                        if (j<10)
                        {
                            for (int i = 0; i < grilleJeu[0][0].length()/2; i++) {
                            System.out.print(" ");
                            }
                            System.out.print(j);
                            for (int i = 0; i < grilleJeu[0][0].length()/2; i++) {
                                System.out.print(" ");
                            }                        
                        }  
                        else 
                        {
                            for (int i = 0; i < (grilleJeu[0][0].length()/2)-1; i++) {
                                System.out.print(" ");
                                }
                                System.out.print(j);
                                for (int i = 0; i < (grilleJeu[0][0].length()/2); i++) {
                                    System.out.print(" ");
                                }
                        }
                    }
                    else 
                    {
                        if (j<10)
                        {
                            for (int i = 0; i < grilleJeu[0][0].length()/2; i++) {
                            System.out.print(" ");
                            }
                            System.out.print(j);
                            for (int i = 0; i < grilleJeu[0][0].length()/2; i++) {
                                System.out.print(" ");
                            }   
                            System.out.print(" ");                     
                        }  
                        else 
                        {
                            for (int i = 0; i < (grilleJeu[0][0].length()/2)-1; i++) {
                                System.out.print(" ");
                                }
                                System.out.print(j);
                                for (int i = 0; i < (grilleJeu[0][0].length()/2); i++) {
                                    System.out.print(" ");
                                }
                                System.out.print(" ");
                        }
                    }   
                }
                break;
                
        }
        
    }



    public void afficherCaseGrille(int x,int y, String quoiAfficher)
    {
        grilleJeu[x][y] = quoiAfficher;
        
    }

    public void cacherCaseGrille(int x,int y)
    {
        grilleJeu[x][y] = " ~~ ";
        
    }
    
}
