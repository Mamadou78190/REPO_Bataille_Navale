package BN_Controler;

public class BadInputException extends Exception {
    public BadInputException(String message) {
        super("Saisie errone : "+message);
    }
}