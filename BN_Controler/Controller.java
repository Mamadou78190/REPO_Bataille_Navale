package BN_Controler;

import java.util.concurrent.TimeUnit;

import BN_Model.*;
import BN_View.View;


class InputCustoms {
    public void menuInput (int userChoice) throws BadInputException{
        
        if (userChoice < 1 || userChoice > 5) {
            throw new BadInputException("Vous devez saisir un nombre entre 0 et 5");
        }
    } 

    public void actionInput (int userChoice) throws BadInputException{
        
        if (userChoice < -1 || userChoice > 1) {
            throw new BadInputException("Vous devez saisir un nombre entre 0 et 1");
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
            break;
            case 3:
            System.out.println("call showHelp");
            break;
            case 4:
            System.out.println("call exitGame");
            exit=true;
            break;
            default:
            try { inputCustoms.menuInput(userChoice); } 
            catch (BadInputException e) { System.out.println(e.getMessage()); this.runGame();}
        }
    }

    public void startNewGame () {
        grilleJoueur.initializeGrille();
        grilleIA.initializeGrille();  
        gameState = GameState.TourJoueur;
    }

    public void actionInput (int userChoice) throws BadInputException, InterruptedException {
        
        switch (userChoice) {
            case 0:
            System.out.println("call askForMoveBoatInput");
            view.askInputForDeplacement();
            break;
            case 1:
            System.out.println("call askForShootInput");
            view.askInputForShoot();
            break;
            case -1:
            gameState=GameState.MenuGame;
            default:
            try { inputCustoms.actionInput(userChoice); } 
            catch (BadInputException e) { System.out.println(e.getMessage()); this.runGame();}
        }
    }

    public void shootInput (int boatChoice, int xChoice, int yChoice) throws BadInputException, InterruptedException {
        //Gerer l'exception d'un mauvais input
        createShoot (flotteJoueur.getShipFromFlotte(boatChoice), xChoice, yChoice);
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
        // switchingTurn();
        }

    public void switchingTurn() {
        if (gameState==GameState.TourJoueur) {
            gameState=GameState.TourIA;
        }
        else if (gameState==GameState.TourIA) {
            gameState=GameState.TourJoueur;
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
                        if (grille.getContent(j,i) != " ~~ "){
                            grille.setContent(j, i,-1, "BOOM");
                        }else{
                            grille.setContent(j, i,-1, "PLOP");
                        }
                    }
                
                }

                view.showGrilles();
                System.out.println("\nMise a jour de la girlle dans 3");
                for (int i=2; i>=0; i--)
                {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("                              "+i);

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
                        if (grille.getContent(j,i)!= " ~~ "){
                            grille.setContent(j, i,-1, "BOOM");
                        }else{
                            grille.setContent(j, i,-1, "PLOP");
                        }
                    }  
                }
                
                view.showGrilles();
                System.out.println("\nMise a jour de la girlle dans 3");
                for (int i=2; i>=0; i--)
                {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("                              "+i);

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

                if (grille.getContent(shootX, shootY)!= " ~~ "){
                    grille.setContent(shootX, shootY,-1, "BOOM");
                }else{
                    grille.setContent(shootX, shootY,-1, "PLOP");
                }
                
                view.showGrilles();
                System.out.println("\nMise a jour de la girlle dans 3");
                for (int i=2; i>=0; i--)
                {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("                              "+i);

                }

                if (grille.getContent(shootX, shootY)== "BOOM"){
                    grille.setContent(shootX, shootY,-1, " ## ");
                }else{
                    grille.setContent(shootX, shootY,-1, " ~~ ");
                }
                
            break;

        }
        }

    public void moveInput (int boat, String direction) throws BadInputException, InterruptedException {
        
        createMove(boat, direction);
    }

    public void createMove (int boat, String direction){

        if (gameState==GameState.TourJoueur) {
            moveBoat(grilleJoueur, flotteJoueur.getShipFromFlotte(boat), direction);
        } else if (gameState==GameState.TourIA) {
            moveBoat(grilleIA, flotteIA.getShipFromFlotte(boat), direction);
        }

    }

    public void moveBoat(Grille grille, Ship ship, String direction){
      
            int position = ship.getOrientation();
            Damaged damaged = new Damaged();

            if (damaged.navireDamaged(ship, grille) == false){
            if (ship.getTaille() > 1){
    
                switch (position){
                    //verticale
                    case 0 : 
    
                        switch (direction){
    
                            case "bas" : 
                                if (ApparitionBateau.balayageBas(ship, ship.getY(), ship.getX() , grille) >= 1 ){ 
                                    String contenuGrilleB = grille.getContent(ship.getX(), ship.getY());
                                    grille.hideContent(ship.getX(), (ship.getY()-ship.getTaille())+1);
                                    grille.tableauJeu[ship.getX()][(ship.getY() + 1)] = contenuGrilleB;
                                    ship.setY((ship.getY() + 1));
                                    System.out.println("Bateau déplacé en bas");
                                    // grille.afficherGrille();
                                  }else{System.out.println("Impossibilité d'aller plus bas");} 
    
                            break;
    
                            case "haut" : 
    
                                if (ApparitionBateau.balayageHaut(ship, (ship.getY()- (ship.getTaille() - 1)), ship.getX(), grille) >= 1){
                                    String contenuGrilleH = grille.getContent(ship.getX(), ship.getY());
                                    grille.hideContent(ship.getX(), ship.getY());
                                    grille.tableauJeu[ship.getX()][(ship.getY() - ship.getTaille())] = contenuGrilleH;
                                    ship.setY(ship.getY() -1);
                                    System.out.println("Bateau déplacé en haut");
                                    // grille.afficherGrille();
                                }else {System.out.println("Impossibilité d'aller plus haut");}   
    
                            break;
                        }
                    
                    break;
                 
                    case 1 : 
    
                        switch (direction){
    
                            case "bas" : 
    
                                if (ApparitionBateau.balayageBas(ship, (ship.getY() + (ship.getTaille()-1)) , ship.getX(), grille) >= 1){
                                    String contenuGrille = grille.getContent(ship.getX(), ship.getY());
                                    grille.hideContent(ship.getX(), ship.getY());
                                    grille.tableauJeu[ship.getX()][(ship.getY() + ship.getTaille())] = contenuGrille;
                                    ship.setY(ship.getY() + 1);
                                    System.out.println("Bateau déplacé en bas");
                                    // grille.afficherGrille();
                                }else {System.out.println("Impossibilité d'aller plus bas");}
                        
                            break; 
    
                            case "haut" : 
    
                                if(ApparitionBateau.balayageHaut(ship, ship.getY(), ship.getX(), grille) >= 1){
                                    String contenuGrille = grille.getContent(ship.getX(), ship.getY());
                                    grille.hideContent(ship.getX(),(ship.getY()+ship.getTaille()) -1);
                                    grille.tableauJeu[ship.getX()][ship.getY() - 1] = contenuGrille;
                                    ship.setY(ship.getY() - 1);
                                    System.out.println("Bateau déplacé en haut");
                                    // grille.afficherGrille();
                                }else {System.out.println("Impossibilité d'aller plus haut");}
    
                            break; 
                        }
    
                    break;
    
                    case 2 : 
                        switch (direction){
    
                            case "gauche" :
    
                            if (ApparitionBateau.balayageGauche(ship, ship.getY(), ship.getX(), grille) >= 1){
                                String contenuGrille = grille.getContent(ship.getX(), ship.getY());
                                grille.hideContent((ship.getX() + (ship.getTaille()-1)), ship.getY());
                                grille.tableauJeu[ship.getX() - 1][ship.getY()] = contenuGrille;
                                ship.setX(ship.getX() - 1);
                                System.out.println("Bateau déplacé à gauche");
                                // grille.afficherGrille();
                            }else{System.out.println("Impossibilité d'aller à gauche");}
    
                            break;
    
                            case "droite" :
    
                            if(ApparitionBateau.balayageDroite(ship, ship.getY(), ship.getX() +(ship.getTaille() -1), grille) >= 1){
                                String contenuGrille = grille.getContent(ship.getX(), ship.getY());
                                grille.hideContent(ship.getX(), ship.getY());
                                grille.tableauJeu[ship.getX() + ship.getTaille()][ship.getY()] = contenuGrille;
                                ship.setX(ship.getX() + 1);
                                System.out.println("Bateau déplacé à droite");
                                // grille.afficherGrille();
                            }else {System.out.println("Impossibilité d'aller à droite");}
    
                            break;
                        }
    
                    break;
    
                    case 3 : 
    
                    switch (direction){
    
                            case "gauche" : 
    
                            if (ApparitionBateau.balayageGauche(ship, ship.getY(), (ship.getX() - (ship.getTaille() +1)), grille) >= 1){
                                String contenuGrille = grille.getContent(ship.getX(), ship.getY());
                                grille.hideContent(ship.getX(), ship.getY());
                                grille.tableauJeu[ship.getX()-ship.getTaille()][ship.getY()] = contenuGrille;
                                ship.setX(ship.getX() - 1);
                                System.out.println("Bateau déplacé à gauche");
                                // grille.afficherGrille();
                            }else{System.out.println("Impossibilité d'aller à gauche");}
    
                            break;
    
                            case "droite" :
    
                            if(ApparitionBateau.balayageDroite(ship, ship.getY(), ship.getX(), grille) >= 1){
                                String contenuGrille = grille.getContent(ship.getX(), ship.getY());
                                grille.hideContent((ship.getX()-ship.getTaille())+1, ship.getY());
                                grille.tableauJeu[ship.getX() + 1][ship.getY()] = contenuGrille;
                                ship.setX(ship.getX() + 1);
                                System.out.println("Bateau déplacé à droite");
                                // grille.afficherGrille();
                            }else{System.out.println("Impossibilité d'aller à droite");}
    
                            break;
                    }
                    break;
                
                }
    
                } else if (ship.getTaille() == 1){
    
                    switch (direction){
    
                        case "gauche" :
                
                        if (ApparitionBateau.balayageGauche(ship, ship.getY(),ship.getX()-1,grille) == 1){
                            String contenuGrille = grille.getContent(ship.getX(), ship.getY());
                            grille.hideContent(ship.getX(), ship.getY());
                            grille.tableauJeu[ship.getX()-1][ship.getY()] = contenuGrille;
                            System.out.println("Sous-Marin déplacé à gauche");
                            ship.setX(ship.getX()-1);
                            // grille.afficherGrille();
                        }else{System.out.println("Impossibilité d'aller à gauche");}
    
                        break;
    
    
                        case "droite" :
    
                        if(ApparitionBateau.balayageDroite(ship, ship.getY(),ship.getX()+1,grille) == 1){
                            String contenuGrille = grille.getContent(ship.getX(), ship.getY());
                            grille.hideContent(ship.getX(), ship.getY());
                            grille.tableauJeu[ship.getX()+1][ship.getY()] = contenuGrille;
                            System.out.println("Sous-Marin déplacé à droite");
                            ship.setX(ship.getX()+1);
    
                            // grille.afficherGrille();
    
                        }else{System.out.println("Impossibilité d'aller à droite");}
    
                        break;
    
                        case "haut" : 
    
                        if(ApparitionBateau.balayageHaut(ship, ship.getY()-1,ship.getX(),grille) == 1){
                            String contenuGrille = grille.getContent(ship.getX(), ship.getY());
                            grille.hideContent(ship.getX(), ship.getY());
                            grille.tableauJeu[ship.getX()][ship.getY()-1] = contenuGrille;
                            System.out.println("Sous-Marin déplacé en haut");
                            ship.setY(ship.getY()-1);
                            // grille.afficherGrille();
                        }else{System.out.println("Impossibilité d'aller plus haut");}
    
                        break;
    
                        case "bas" :
    
                        if(ApparitionBateau.balayageBas(ship, ship.getY()+1,ship.getX(),grille) ==  1){
                            String contenuGrille = grille.getContent(ship.getX(), ship.getY());
                            grille.hideContent(ship.getX(), ship.getY());
                            grille.tableauJeu[ship.getX()][ship.getY()+1] = contenuGrille;
                            System.out.println("Sous-Marin déplacé en bas");
                            ship.setY(ship.getY()+1);
                            // grille.afficherGrille();
                        }else{System.out.println("Impossibilité d'aller plus bas");}
                    }    
            }
            }else {System.out.println("VOTRE BATEAU EST ENDOMMAGER VOUS NE POUVEZ PAS LE DEPLACER");}      
        }


        public boolean exit(boolean status) {return status=true;}
    }

