package BN_View;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import BN_Controler.*;

public class View {
    Scanner UserInput = new Scanner(System.in);
    int input;
    Controller controller;

    public View() {}

    public void askInputForMenu () throws BadInputException, InterruptedException {
        System.out.println("\nWhat would you like to do ? Enter a number : ");    
        input = UserInput.nextInt();
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

    public void showFlotte (String flotte) {
        System.out.println("\n\nVOTRE FLOTTE\n"+flotte);
    }

    public void showSaveComplete () {
        System.out.println("\nSave complete !");
    }

    public void askInputForAction () throws BadInputException, InterruptedException {
        System.out.println( "\nWhat action would you like to do ?"+
                            "\n\t0  Deplacer un bateau"+
                            "\n\t1  Tirer sur la grille adverse"+
                            "\n\t2  Save the game"+
                            "\n\t-1 Go back to Main Menu");
        input = UserInput.nextInt();
        controller.actionInput(input);
    }

    public void askInputForShoot () throws BadInputException, InterruptedException {
        System.out.print( "\nWhich boat are you choosing from 0 to 9 ?  Select ship : ");
        input = UserInput.nextInt();
        System.out.print( "\nWhere would you like to shoot ?            Select X : ");
        int inputx = UserInput.nextInt();
        System.out.print( "\n                                           Select Y : ");
        int inputy = UserInput.nextInt();
        controller.shootInput(input, inputx, inputy);
    }


    public void showGrilles() { 
        System.out.println("\n\nGRILLE JOUEUR \t\t\t\t\t\t\t\t\t\tGRILLE IA");
        //Affichage repere abscisses 1ere grille IA
        System.out.print("y--x");

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

        //affichage ligne par ligne des 2 tableaux
        for (int i = 0; i < controller.getGrilleTailleOrdonnees(); i++) {
            //affichage du repere y du Joueur
            if (i<10)
            {
                System.out.print(i+"  ");
            }
            else
            {
                System.out.print(i+" ");
            }

            //affichage grille JOUEUR
            for (int j = 0; j < controller.getGrilleTailleAbscisse(); j++) {
                
                System.out.print("|");
                System.out.print(controller.getGrilleJoueurContent(j, i));
                
            }
            System.out.print("|");

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

            //affichage grille IA
            for (int j = 0; j < controller.getGrilleTailleAbscisse(); j++) {
                
                System.out.print("|");
                System.out.print(controller.getGrilleIAContent(j, i));
                
            }
            System.out.println("|");

            //affichage des lignes de séparations
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

    public void showTemporisation (int delayInSeconds, String message) throws InterruptedException {
        System.out.println("\n"+message+"\t"+delayInSeconds);
                for (int i=delayInSeconds-1; i>=0; i--)
                {
                    TimeUnit.SECONDS.sleep(1);
                    for (int j = 0 ; j < message.length() ; j++) {
                        System.out.print(" ");
                    }
                    System.out.println("\t"+i);
                }
    }

}
