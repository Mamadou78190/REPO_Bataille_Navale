import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ChargerFichier {

    public static void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("Sauvegarde.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            System.out.println(o);
            o = ois.readObject();
            System.out.println(o);
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
}
