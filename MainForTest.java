

// import java.util.Scanner;
// import java.io.*;
// import BN_Model.*;

import BN_Controler.*;
import BN_View.*;

public class MainForTest {
    public static void main(String[] args) throws BadInputException {

        Controller ToRun = new Controller(new View());
        ToRun.runGame();


        // Grille g1 = new Grille(15,15);
        // Flotte flotte = new Flotte();
        // ApparitionFlotte AP = new ApparitionFlotte();
        //  for (int i = 0; i < flotte.getFlotteSize(); i++) {
        //    AP.flotteGrille(g1,flotte.getShipFromFlotte(i),i);
        // }
        // g1.afficherGrille();
        // flotte.afficherFlotte();
        // for (int i = 0; i < 8; i++) {
        // deplacementUser(g1, flotte);
        // }

    }


    // public static void deplacementUser (Grille g1, Flotte flotte){

    //      Scanner ship = new Scanner(System.in);
    //      System.out.println("Quel navire souhaitez-vous bouger ? ");
    //      int Navire = ship.nextInt();


    //     Scanner deplacement = new Scanner(System.in);
    //     DeplacementNavire DN = new DeplacementNavire();
   
    //      System.out.println("OÃ¹ souhaitez-vous bouger votre bateau");
    //      String deplacementV = deplacement.nextLine(); 
    //      DN.deplacementNavire(g1, flotte.getShipFromFlotte(Navire), deplacementV);

    // }
    
}
