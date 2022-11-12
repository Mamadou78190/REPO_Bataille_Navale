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
        
        System.out.println();

        for (int i = 0; i < controller.getGrilleTailleOrdonnees(); i++) {
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
            for (int j = 0; j < controller.getGrilleTailleAbscisse(); j++) {
                
                System.out.print("|");
                System.out.print(controller.getGrilleJoueurContent(j, i));
                
            }
            ////////////////////////////////

            showSeparationLine();
        }
    }

    public void showSeparationLine() {
        System.out.println("|");
            System.out.print("   ");
                for (int k = 0; k < controller.getGrilleTailleAbscisse(); k++) {
                    System.out.print("|");
                    for (int i = 0; i < controller.getGrilleJoueurContent(0,0).length(); i++) {
                        System.out.print("-");
                    }
                    
                }
                System.out.println("|");
    }


}
