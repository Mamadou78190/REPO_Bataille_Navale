package BN_View;

import java.util.Scanner;

import BN_Controler.*;

public class View {
    Scanner UserInput = new Scanner(System.in);
    Controller controller;

    public View() {}

    public void askInputForMenu () throws BadInputException {
        System.out.println("\nWhat would you like to do ? Enter a number : ");    
        int input = UserInput.nextInt();
        controller.menuInput(input);
    }

    public void linkController(Controller control) {
        this.controller = control;
    }

    public void showMenu () {
        System.out.println( "\n1 - Start a New Game"+
                            "\n2 - Load an existing Game"+
                            "\n3 - Show help"+
                            "\n4 - Exit Game");
    }

    public void showGrilles() { 
        
        System.out.print("\n\ny--x");

        for (int j = 0; j < controller.getGrilleTailleAbscisse(); j++) {  
            if (controller.getGrilleJoueurContent(0, 0).length()%2==0)
            {
                if (j<10)
                {
                    for (int i = 0; i < controller.getGrilleJoueurContent(0, 0).length()/2; i++) {
                    System.out.print(" ");
                    }
                    System.out.print(j);
                    for (int i = 0; i < controller.getGrilleJoueurContent(0, 0).length()/2; i++) {
                        System.out.print(" ");
                    }                        
                }  
                else 
                {
                    for (int i = 0; i < (controller.getGrilleJoueurContent(0, 0).length()/2)-1; i++) {
                        System.out.print(" ");
                        }
                        System.out.print(j);
                        for (int i = 0; i < (controller.getGrilleJoueurContent(0, 0).length()/2); i++) {
                            System.out.print(" ");
                        }
                }
            }
            else 
            {
                if (j<10)
                {
                    for (int i = 0; i < controller.getGrilleJoueurContent(0, 0).length()/2; i++) {
                    System.out.print(" ");
                    }
                    System.out.print(j);
                    for (int i = 0; i < controller.getGrilleJoueurContent(0, 0).length()/2; i++) {
                        System.out.print(" ");
                    }   
                    System.out.print(" ");                     
                }  
                else 
                {
                    for (int i = 0; i < (controller.getGrilleJoueurContent(0, 0).length()/2)-1; i++) {
                        System.out.print(" ");
                        }
                        System.out.print(j);
                        for (int i = 0; i < (controller.getGrilleJoueurContent(0, 0).length()/2); i++) {
                            System.out.print(" ");
                        }
                        System.out.print(" ");
                }
            }   
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Affichage repere abscisses 2eme grille IA
        System.out.print("\t\ty--x");

        for (int j = 0; j < controller.getGrilleTailleAbscisse(); j++) {  
            if (controller.getGrilleIAContent(0, 0).length()%2==0)
            {
                if (j<10)
                {
                    for (int i = 0; i < controller.getGrilleIAContent(0, 0).length()/2; i++) {
                    System.out.print(" ");
                    }
                    System.out.print(j);
                    for (int i = 0; i < controller.getGrilleIAContent(0, 0).length()/2; i++) {
                        System.out.print(" ");
                    }                        
                }  
                else 
                {
                    for (int i = 0; i < (controller.getGrilleIAContent(0, 0).length()/2)-1; i++) {
                        System.out.print(" ");
                        }
                        System.out.print(j);
                        for (int i = 0; i < (controller.getGrilleIAContent(0, 0).length()/2); i++) {
                            System.out.print(" ");
                        }
                }
            }
            else 
            {
                if (j<10)
                {
                    for (int i = 0; i < controller.getGrilleIAContent(0, 0).length()/2; i++) {
                    System.out.print(" ");
                    }
                    System.out.print(j);
                    for (int i = 0; i < controller.getGrilleIAContent(0, 0).length()/2; i++) {
                        System.out.print(" ");
                    }   
                    System.out.print(" ");                     
                }  
                else 
                {
                    for (int i = 0; i < (controller.getGrilleIAContent(0, 0).length()/2)-1; i++) {
                        System.out.print(" ");
                        }
                        System.out.print(j);
                        for (int i = 0; i < (controller.getGrilleIAContent(0, 0).length()/2); i++) {
                            System.out.print(" ");
                        }
                        System.out.print(" ");
                }
            }   
        }

        
        System.out.println();


        for (int i = 0; i < controller.getGrilleTailleOrdonnees(); i++) {
            //affichage du repere y due Joueur
            if (i<10)
            {
                System.out.print(i+"  ");
            }
            else
            {
                System.out.print(i+" ");
            }
            ////////////////////////////////

            //affichage grille JOUEUR
            for (int j = 0; j < controller.getGrilleTailleAbscisse(); j++) {
                
                System.out.print("|");
                System.out.print(controller.getGrilleJoueurContent(j, i));
                
            }
            System.out.print("|");
            ////////////////////////////////

            System.out.print("\t\t");

            //affichage du repere y de IA
            if (i<10)
            {
                System.out.print(i+"  ");
            }
            else
            {
                System.out.print(i+" ");
            }
            ////////////////////////////////

            //affichage grille IA
            for (int j = 0; j < controller.getGrilleTailleAbscisse(); j++) {
                
                System.out.print("|");
                System.out.print(controller.getGrilleIAContent(j, i));
                
            }
            ////////////////////////////////
            System.out.println("|");
            
            showSeparationLine();
            System.out.print("\t\t");
            showSeparationLine();
            System.out.println();

        }
    }

    public void showSeparationLine() {
        
            System.out.print("   ");
                for (int k = 0; k < controller.getGrilleTailleAbscisse(); k++) {
                    System.out.print("|");
                    for (int i = 0; i < controller.getGrilleJoueurContent(0,0).length(); i++) {
                        System.out.print("-");
                    }
                    
                }
                System.out.print("|");
    }


}
