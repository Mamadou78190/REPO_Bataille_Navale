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
}
