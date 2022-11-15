

// import java.util.Scanner;
// import java.io.*;
// import BN_Model.*;

import BN_Controler.*;
import BN_View.*;

public class MainForTest {
    public static void main(String[] args) throws BadInputException, InterruptedException {

        Controller ToRun = new Controller(new View());
        do {
           ToRun.runGame();
        } while (!ToRun.exit);

    }
    
}
