package BN_Controler;

import BN_Model.*;
import BN_View.View;


class InputCustoms {
    public void menuInput (int userChoice) throws BadInputException{
        
        if (userChoice < 1 || userChoice > 5) {
            throw new BadInputException("Vous devez saisir un nombre entre 0 et 5");
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
    GameState gameState;
    InputCustoms inputCustoms = new InputCustoms();

    int userChoice;

    public Controller (View view) {
        // super(); //Cree un View null par le biais du constructeur Object. <==> View () {} 
        this.gameState = GameState.MenuGame;
        this.view = view;
        view.linkController(this);
    }

    public void runGame () throws BadInputException { //Fonction qui va appeller le controlleur depuis le main
        switch (gameState) {
            case MenuGame:
            view.showMenu();
            view.askInputForMenu();
            break;
            case TourJoueur:
            System.out.println("Call View for player turn, input for what action to do");
            break;
            case TourIA:
            System.out.println("Call View for IA turn, input for what action to do ");
            break;
            case EndGame:
            System.out.println("Go back to main menu");
            break;
        }

    }

    public void menuInput (int userChoice) throws BadInputException {
        
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
            break;
            default:
            try { inputCustoms.menuInput(userChoice); } 
            catch (BadInputException e) { System.out.println(e.getMessage()); this.runGame();}
        }
    }

    public void startNewGame () {
        gameState = GameState.TourJoueur;
        grilleJoueur.initializeGrille();
        view.showGrilles();
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
}
