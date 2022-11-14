package BN_Controler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import BN_Model.*;
import BN_View.View;


class InputCustoms {
    public void menuInputCustoms (int userChoice) throws BadInputException{
        
        if (userChoice < 1 || userChoice > 5) {
            throw new BadInputException("Vous devez saisir un nombre entre 0 et 5");
        }
    } 

    public void actionInputCustoms (int userChoice) throws BadInputException{
        
        if (userChoice < -1 || userChoice > 1) {
            throw new BadInputException("Vous devez saisir un nombre entre 0 et 1");
        }
    }
    
    public void shootInputCustoms (int shipIndex, int x, int y, Flotte flotte, Grille grille) throws BadInputException {
        if (shipIndex < 0 || shipIndex > flotte.getFlotteSize()) {
            throw new BadInputException("Vous devez selectionner un de vos navires par son Numero ! ");
        } else if (x < 0 || x > grille.getTailleAbscisse()) {
            throw new BadInputException("Vous devez selectionner une coordonnee X entre 0 et "+ grille.getTailleAbscisse());
        } else if (y < 0 || y > grille.getTailleOrdonnees()) {
            throw new BadInputException("Vous devez selectionner une coordonnee Y entre 0 et "+ grille.getTailleAbscisse());
        }
    }
}

public class Controller {
    enum GameState {
        MenuGame, TourJoueur, TourIA, EndGame
    }

    View view;
    Flotte flotteJoueur = new Flotte();
    Flotte flotteIA = new Flotte();
    Grille grilleJoueur = new Grille(15,15);
    Grille grilleIA = new Grille(15,15);
    Shoot shoot;
    Coordonnees coordonnees;
    public Boolean exit = false;
    
    GameState gameState;
    InputCustoms inputCustoms = new InputCustoms();

    int userChoice;

    public Controller (View view) {
        // super(); //Cree un View null par le biais du constructeur Object. <==> View () {} 
        this.gameState = GameState.MenuGame;
        this.view = view;
        view.linkController(this);
    }

    public void runGame () throws BadInputException, InterruptedException { //Fonction qui va appeller le controlleur depuis le main
        switch (gameState) {
            case MenuGame:
            view.showMenu();
            view.askInputForMenu();
            break;
            case TourJoueur:
            System.out.println("Call View for player turn, input for what action to do");
            view.showGrilles();
            view.showFlotte(flotteJoueur.getStringFlotte());
            view.askInputForAction(); 
            break;
            case TourIA:
            System.out.println("Call View for IA turn, input for what action to do ");
            startShootAction (0, 0, 0);
            // view.showGrilles();
            break;
            case EndGame:
            System.out.println("Go back to main menu");
            break;
        }

    }

    public void menuInput (int userChoice) throws BadInputException, InterruptedException {
        
        switch (userChoice) {
            case 1:
            System.out.println("call Start a New Game");
            startNewGame();
            break;
            case 2:
            System.out.println("call Load a New Game");
            chargement();
            break;
            case 3:
            System.out.println("call showHelp");
            break;
            case 4:
            System.out.println("call exitGame");
            exit=true;
            break;
            default:
            try { inputCustoms.menuInputCustoms(userChoice); } 
            catch (BadInputException e) { System.out.println(e.getMessage()); this.runGame();}
        }
    }

    public void switchingTurn() {
        if (gameState==GameState.TourJoueur) {
            gameState=GameState.TourIA;
        }
        else if (gameState==GameState.TourIA) {
            gameState=GameState.TourJoueur;
        }
    }

    public void startNewGame () {
        grilleJoueur.initializeGrille();
        grilleIA.initializeGrille(); 
        apparitionFlotteOnGrille(flotteIA, grilleIA);
        apparitionFlotteOnGrille(flotteJoueur, grilleJoueur); 
        gameState = GameState.TourJoueur;
    }

    public void startShootAction (int shipIndex, int x, int y) throws InterruptedException {
        Random randomShootX = new Random();
        Random randomShootY = new Random();
        Random randomShootShipIndex = new Random();
        
        if (gameState==GameState.TourJoueur) {
        createShoot (flotteJoueur.getShipFromFlotte(shipIndex), x, y);
        checkIfAShipIsDead(flotteIA, grilleIA);
        } else if (gameState==GameState.TourIA) {
            int xIA = randomShootX.nextInt(grilleIA.getTailleAbscisse());
            int yIA = randomShootY.nextInt(grilleIA.getTailleOrdonnees());
            int indexShipFromFlotteIA = randomShootShipIndex.nextInt(flotteIA.getFlotteSize());
            createShoot (flotteIA.getShipFromFlotte(indexShipFromFlotteIA), xIA, yIA);
            checkIfAShipIsDead(flotteJoueur, grilleJoueur);
        }
        switchingTurn(); //toggle comment when on dbg
    }

    public void actionInput (int userChoice) throws BadInputException, InterruptedException {
        
        switch (userChoice) {
            case 0:
            System.out.println("call askForMoveBoatInput");
            break;
            case 1:
            System.out.println("call askForShootInput");
            view.askInputForShoot();
            break;
            case 2:
            System.out.println("call saveMethod");
            sauvegarder();
            break;
            case -1:
            gameState=GameState.MenuGame;
            default:
            try { inputCustoms.actionInputCustoms(userChoice); } 
            catch (BadInputException e) { System.out.println(e.getMessage());}
        }
    }

    public void shootInput (int boatChoice, int xChoice, int yChoice) throws BadInputException, InterruptedException {
        try {
            inputCustoms.shootInputCustoms(boatChoice, xChoice, yChoice, flotteJoueur, grilleIA);
            startShootAction(boatChoice, xChoice, yChoice);
        } catch (BadInputException e) {System.out.println(e.getMessage()); }
    }

    public void createShoot (Ship boat, int x, int y) throws InterruptedException {
        // shoot.setX=x;
        // shoot.setY=y;
        // shoot.setPuissance(boat.getPuissance)
        shoot = new Shoot (x,y,boat.getPuissance());
        if (gameState==GameState.TourJoueur) {
            setShootImpact(shoot,grilleIA);
        } else if (gameState==GameState.TourIA) {
            setShootImpact(shoot,grilleJoueur);
        }
        
        }
    
    public void setShootImpact(Shoot shoot, Grille grille) throws InterruptedException {
        int shootX = shoot.getX();
        int shootY = shoot.getY();

        // Gestion des bords de la grille
        //userInput y = 14
        if (shoot.getY()>=grille.getTailleOrdonnees()-1 && (shoot.getPuissance()==4 || shoot.getPuissance()==9) )
        {
            shootY=shoot.getY()-1;
        }
        else if (shoot.getY()<=0 && shoot.getPuissance()==9)
        {
            shootY=shoot.getY()+1;
        }

        //userInput x = 14
        if (shoot.getX()>=grille.getTailleAbscisse()-1 && (shoot.getPuissance()==4 || shoot.getPuissance()==9))
        {
            shootX=shoot.getX()-1;
        }
        else if (shoot.getX()<=0 && shoot.getPuissance()==9)
        {
            shootX=shoot.getX()+1;
        }
        /////////////////////////////////////////////////

        switch (shoot.getPuissance())
        {
            case 9:
                for (int i=shootY-1; i<=shootY+1; i++)
                {
                    for (int j=shootX-1; j<=shootX+1; j++)
                    {
                        if (grille.getContent(j,i) == "DEAD") {
                            // does nothing, just keep it dead
                        } else if (grille.getContent(j,i) != " ~~ "){
                            grille.setContent(j, i,-1, "BOOM");
                        } else {
                            grille.setContent(j, i,-1, "PLOP");
                        }
                    }
                
                }

                view.showGrilles();
                System.out.println("\nMise a jour des grilles dans 3");
                for (int i=2; i>=0; i--)
                {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("                             "+i);

                }

                for (int i=shootY-1; i<=shootY+1; i++)
                {
                    for (int j=shootX-1; j<=shootX+1; j++)
                    {
                        if (grille.getContent(j,i) == "BOOM"){
                            grille.setContent(j, i,-1, " ## ");
                        }else{
                            grille.setContent(j, i,-1, " ~~ ");
                        }
                    }
                }
                

            break;

            case 4:
                for (int i=shootY; i<=shootY+1; i++)
                {
                    for (int j=shootX; j<=shootX+1; j++)
                    {
                        if (grille.getContent(j,i) == "DEAD") {
                            // does nothing, just keep it dead
                        } else if (grille.getContent(j,i)!= " ~~ "){
                            grille.setContent(j, i,-1, "BOOM");
                        }else{
                            grille.setContent(j, i,-1, "PLOP");
                        }
                    }  
                }
                
                view.showGrilles();
                System.out.println("\nMise a jour des grilles dans 3");
                for (int i=2; i>=0; i--)
                {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("                             "+i);

                }

                for (int i=shootY; i<=shootY+1; i++)
                {
                    for (int j=shootX; j<=shootX+1; j++)
                    {
                        if (grille.getContent(j,i)== "BOOM"){
                            grille.setContent(j, i,-1, " ## ");
                        }else{
                            grille.setContent(j, i,-1, " ~~ ");
                        }
                    }
                }
                

            break;

            case 1:

                if (grille.getContent(shootX,shootY) == "DEAD") {
                    // does nothing, just keep it dead
                } else if (grille.getContent(shootX, shootY)!= " ~~ "){
                    grille.setContent(shootX, shootY,-1, "BOOM");
                }else{
                    grille.setContent(shootX, shootY,-1, "PLOP");
                }
                
                view.showGrilles();
                System.out.println("\nMise a jour des grilles dans 3");
                for (int i=2; i>=0; i--)
                {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("                             "+i);

                }

                if (grille.getContent(shootX, shootY)== "BOOM"){
                    grille.setContent(shootX, shootY,-1, " ## ");
                }else{
                    grille.setContent(shootX, shootY,-1, " ~~ ");
                }
                
            break;

        }
    }

    public static int balayageBoatVersHaut(Ship ship, int ordonnees, int abscisses, Grille grille){

        int cmpt = 0;
        int y = 0;
        for (int i= 0; i<ship.getTaille(); i++){
            y = ordonnees - i;
            if (y >= 0 && grille.getContent(abscisses, y) == " ~~ "){
                cmpt = cmpt +1;
            }
        }
        return cmpt; 

    }

    public static int balayageBoatVersBas(Ship ship, int ordonnees, int abscisses, Grille grille){
        int cmpt = 0;
        int y = 0;
        for (int i= 0; i<ship.getTaille(); i++){
            y = ordonnees + i;
            if (y <= (grille.getTailleAbscisse()-1) && grille.getContent(abscisses,y) == " ~~ "){
                cmpt = cmpt+1;
            }
        }
        return cmpt;
    }

    public static int balayageBoatVersGauche(Ship ship, int ordonnees, int abscisses, Grille grille){
        int cmpt = 0;
        int x = 0;

        for (int i= 0; i<ship.getTaille(); i++){
            x = abscisses -i;
            if (x >= 0 && grille.getContent(x, ordonnees) == " ~~ "){
                    cmpt = cmpt + 1;
            }
        }

        return cmpt;
    }

    public static int balayageBoatVersDroite(Ship ship, int ordonnees, int abscisses, Grille grille){
        int cmpt = 0;
        int x = 0;
        for (int i= 0; i<ship.getTaille(); i++){
            x = abscisses + i;
            if (x <= (grille.getTailleAbscisse()-1) && grille.getContent(x, ordonnees) == " ~~ "){
                cmpt = cmpt + 1;
           }
       }

        return cmpt;
    }

    public void apparitionFlotteOnGrille (Flotte flotte, Grille grille){
        // better chance of infinite loop if cuirasse (9cases) is the last to spawn rather than if it is the first to spawn
        for (int i = flotte.getFlotteSize()-1; i >= 0; i--) {
            randomApparitionForBoatOnGrille(flotte.getShipFromFlotte(i), grille, i);
         }
    }

    public void randomApparitionForBoatOnGrille (Ship ship, Grille grille, int indexOfBoat) {
        boolean disponibilite = false; 
        boolean jetonBas = false;
        boolean jetonHaut = false;
        boolean jetonGauche = false;
        boolean jetonDroit = false;
        Random randomAbscisse = new Random();
		Random randomOrdonnee = new Random();
        Random randomPosition = new Random();
        int abscisses = randomAbscisse.nextInt(grille.getTailleAbscisse());
        int ordonnees = randomOrdonnee.nextInt(grille.getTailleOrdonnees());
        int position = randomPosition.nextInt(3);

        do {
            if (balayageBoatVersBas(ship, ordonnees, abscisses, grille) == ship.getTaille()){
                jetonBas = true;
                disponibilite = true;
            } if (balayageBoatVersDroite(ship, ordonnees, abscisses, grille) == ship.getTaille()){
                jetonDroit = true;
                disponibilite = true;
            } if (balayageBoatVersGauche(ship, ordonnees, abscisses, grille) == ship.getTaille()){
                jetonGauche = true;
                disponibilite = true;
            } if (balayageBoatVersHaut(ship, ordonnees, abscisses, grille) == ship.getTaille()){
                jetonHaut = true;
                disponibilite = true;
            } if (!disponibilite) {
                abscisses = randomAbscisse.nextInt(grille.getTailleAbscisse());
                ordonnees = randomOrdonnee.nextInt(grille.getTailleOrdonnees());
            }
        } while (disponibilite==false);

        switch (position) {

            case 0 : 
                //haut
                if (jetonHaut){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses,ordonnees-i,indexOfBoat , ship.getVisuel());
                        position = 0;
                        ship.setCoordonneesShip(abscisses, ordonnees-i, ship);
                    }
                }else if (jetonBas){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses,ordonnees+i,indexOfBoat , ship.getVisuel());
                        position = 1;
                        ship.setCoordonneesShip(abscisses, ordonnees+i, ship);
                    }
                }else if (jetonGauche){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses-i,ordonnees,indexOfBoat , ship.getVisuel());
                        position = 3;
                        ship.setCoordonneesShip(abscisses-i, ordonnees, ship);
                    }
                }else if (jetonDroit){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses+i,ordonnees,indexOfBoat, ship.getVisuel());
                        position = 2;
                        ship.setCoordonneesShip(abscisses+i, ordonnees, ship);
                    }
                }

            break; 

            case 1 : 
                //bas
                if (jetonBas){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses,ordonnees+i,indexOfBoat, ship.getVisuel());
                        position = 1;
                        ship.setCoordonneesShip(abscisses, ordonnees+i, ship);
                    }
                }else if (jetonHaut){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses,ordonnees-i,indexOfBoat, ship.getVisuel());
                        position = 0;
                        ship.setCoordonneesShip(abscisses, ordonnees-i, ship);
                    }
                }else if (jetonDroit){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses+i,ordonnees,indexOfBoat, ship.getVisuel());
                        position = 2;
                        ship.setCoordonneesShip(abscisses+i, ordonnees, ship);
                    }
                }else if (jetonGauche){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses-i,ordonnees,indexOfBoat, ship.getVisuel());
                        position = 3;
                        ship.setCoordonneesShip(abscisses-i, ordonnees, ship);
                    }
                }
            break; 

            case 2 : 
                //droit
                if (jetonDroit){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses+i,ordonnees,indexOfBoat, ship.getVisuel());
                        position = 2;
                        ship.setCoordonneesShip(abscisses+i, ordonnees, ship);
                    }
                }else if (jetonGauche){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses-i,ordonnees,indexOfBoat, ship.getVisuel());
                        position = 3;
                        ship.setCoordonneesShip(abscisses-i, ordonnees, ship);
                    }
                }else if (jetonHaut){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses,ordonnees-i,indexOfBoat, ship.getVisuel());
                        position = 0;
                        ship.setCoordonneesShip(abscisses, ordonnees-i, ship);
                    }
                }else if (jetonBas){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses,ordonnees+i,indexOfBoat, ship.getVisuel());
                        position = 1;
                        ship.setCoordonneesShip(abscisses, ordonnees+i, ship);
                    }
                }
            break; 

            case 3 : 
                //gauche
                if (jetonGauche){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses-i,ordonnees,indexOfBoat, ship.getVisuel());
                        position = 3;
                        ship.setCoordonneesShip(abscisses-i, ordonnees, ship);
                    }
                }else if (jetonDroit){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses+i,ordonnees,indexOfBoat, ship.getVisuel());
                        position = 2;
                        ship.setCoordonneesShip(abscisses+i, ordonnees, ship);
                    }
                }else if (jetonHaut){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses,ordonnees-i,indexOfBoat, ship.getVisuel());
                        position = 0;
                        ship.setCoordonneesShip(abscisses, ordonnees-i, ship);
                    }
                }else if (jetonBas){
                    for (int i = 0; i<ship.getTaille(); i++){
                        grille.setContent(abscisses,ordonnees+i,indexOfBoat, ship.getVisuel());
                        position = 1;
                        ship.setCoordonneesShip(abscisses, ordonnees+i, ship);
                    }
                }
            break;
        }
    }

    public void checkIfAShipIsDead (Flotte flotte, Grille grille) {
        boolean status = false;
        for (int i = 0 ; i < flotte.getFlotteSize() ; i++) {
            status = isShipDead(flotte.getShipFromFlotte(i), grille);
            if (status) {
                setDeadShipOnGrille(flotte.getShipFromFlotte(i), grille);
            }
        }
    }
    public boolean isShipDead(Ship ship, Grille grille){

        int cmpt = 0;
        boolean isDead = false;

        for (int i = 0; i < ship.getTaille(); i++)
        {
            Coordonnees coordonnes = ship.getCaseShip(i);
            if (grille.getContent(coordonnes.getX(),coordonnes.getY())==" ## ")
            {
                cmpt++;
            }
        }
        if (cmpt == ship.getTaille())
        {
            ship.setIsDead();
            isDead = true;
        }
        return isDead;
    }
    
    public void setDeadShipOnGrille (Ship ship, Grille grille) {
        for (int i = 0 ; i < ship.getTaille() ; i++) {
            coordonnees = ship.getCaseShip(i);
            grille.setContent(coordonnees.getX(), coordonnees.getY(), -1, "DEAD");
        }
    }
    // les deux grilles dont la même taille que ce soit en abscisse ou en ordonnee, donc autant les généraliser à une grille
    public int getGrilleTailleAbscisse()
    {
        return grilleJoueur.getTailleAbscisse();
    }
    public int getGrilleTailleOrdonnees()
    {
        return grilleJoueur.getTailleOrdonnees();
    }
    /////////////////////////////////////////////////
    
    // ce qui n'est pas le cas ici car le contenu de chaque grille n'est pas la même
    public String getGrilleJoueurContent(int x, int y) {
        return grilleJoueur.getContent(x,y);
    }
    public String getGrilleIAContent(int x, int y) {
        return grilleIA.getContent(x,y);
    }
    /////////////////////////////////////////////////


    public void sauvegarder (){
        try {
            FileOutputStream fos = new FileOutputStream("Save/Sauvegarde.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(grilleJoueur);
            oos.writeObject(grilleIA);
            oos.writeObject(flotteIA);
            oos.writeObject(flotteJoueur);
            oos.writeObject(gameState);
            oos.close();
            fos.close();
            view.showSaveComplete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void chargement(){
        try {
            FileInputStream fis = new FileInputStream("Save/Sauvegarde.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            grilleJoueur = (Grille) ois.readObject();
            grilleIA = (Grille) ois.readObject();
            view.showGrilles();
            //o = ois.readObject();
            //System.out.println(o);
            //o = ois.readObject();
            //System.out.println(o);
            //o = ois.readObject();
            //System.out.println(o);
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public boolean exit(boolean status) {return status=true;}
    }

