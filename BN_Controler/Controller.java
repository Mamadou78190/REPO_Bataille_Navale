package BN_Controler;
import BN_Model.*;




public class Controller {
    enum GameState {
        MenuGame, TourJoueur, TourIA, EndGame
    }

    Flotte flotteJoueur = new Flotte();
    Flotte flotteIA = new Flotte();
    Grille grilleJoueur = new Grille(15,15);
    Grille grilleIA = new Grille(15,15);
    GameState gameState;

    public Controller () {
        // super(); etait dans le tuto. valable, mais pourquoi ?
        this.gameState = GameState.MenuGame;
    }

    public void runGame () { //Fonction qui va appeller le controlleur depuis le main
        switch (gameState) {
            case MenuGame:
            System.out.println("Call View for prompt MenuChoice");
            break;
            case TourJoueur:
            System.out.println("Call View for player turn, input for what action to do");
            break;
            case TourIA:
            System.out.println("Call View for IA turn, input for what action to do ");
            break;
        }

    }

    public void startNewGame () {
        gameState = GameState.TourJoueur;
        
    }
}
