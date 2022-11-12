package BN_Model;
public class Grille {
    
    public String tableauJeu [][]; 
    private int taille_abscisse;
    private int taille_ordonnees;
    

    public Grille(int taille_abscisse,int taille_ordonnees)
    {
        this.taille_abscisse=taille_abscisse;
        this.taille_ordonnees=taille_ordonnees;
        this.tableauJeu = new String[taille_abscisse][taille_ordonnees];
        // for (int i = 0; i < taille_abscisse; i++) {
        //     for (int j = 0; j < taille_ordonnees; j++) {
        //         cacherCaseGrille(i, j); 
        //     }
        // }
       
    }

   
    public int getTailleAbscisse()
    {
        return taille_abscisse;
    }

    public int getTailleOrdonnees()
    {
        return taille_ordonnees;
    }

    public String getContent(int x,int y) {
        return tableauJeu[x][y];
    }

    public void setContent(int x,int y, int index, String contenu)
    {
        if (index>=0){
            contenu = index+contenu; 
            tableauJeu[x][y] = contenu;

        }
        else{
            tableauJeu[x][y] = contenu;
        }
        
    }

    public void hideContent(int x,int y)
    {
        tableauJeu[x][y] = " ~~ ";
        
    }

    public void initializeGrille()
    {
        for (int i = 0; i < taille_abscisse; i++) {
            for (int j = 0; j < taille_ordonnees; j++) {
                hideContent(i, j); 
            }
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
                    for (int i = 0; i < tableauJeu[0][0].length(); i++) {
                        System.out.print("-");
                    }
                    
                }
                System.out.println("|");
                break;


            case "repereAbscisse": //attention ce calibrage ne fonctionne que pour un repere d'abscisses entre 0 et 100 non inclus
                for (int j = 0; j < taille_abscisse; j++) {  
                    if (tableauJeu[0][0].length()%2==0)
                    {
                        if (j<10)
                        {
                            for (int i = 0; i < tableauJeu[0][0].length()/2; i++) {
                            System.out.print(" ");
                            }
                            System.out.print(j);
                            for (int i = 0; i < tableauJeu[0][0].length()/2; i++) {
                                System.out.print(" ");
                            }                        
                        }  
                        else 
                        {
                            for (int i = 0; i < (tableauJeu[0][0].length()/2)-1; i++) {
                                System.out.print(" ");
                                }
                                System.out.print(j);
                                for (int i = 0; i < (tableauJeu[0][0].length()/2); i++) {
                                    System.out.print(" ");
                                }
                        }
                    }
                    else 
                    {
                        if (j<10)
                        {
                            for (int i = 0; i < tableauJeu[0][0].length()/2; i++) {
                            System.out.print(" ");
                            }
                            System.out.print(j);
                            for (int i = 0; i < tableauJeu[0][0].length()/2; i++) {
                                System.out.print(" ");
                            }   
                            System.out.print(" ");                     
                        }  
                        else 
                        {
                            for (int i = 0; i < (tableauJeu[0][0].length()/2)-1; i++) {
                                System.out.print(" ");
                                }
                                System.out.print(j);
                                for (int i = 0; i < (tableauJeu[0][0].length()/2); i++) {
                                    System.out.print(" ");
                                }
                                System.out.print(" ");
                        }
                    }   
                }
                break;
                
        }
        
    }



    

    
    
}
