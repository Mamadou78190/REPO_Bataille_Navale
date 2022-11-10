import java.io.*;

public class Sauvegarder
{
    public static void main( String[] args ) {
        Data d1 = new Data("A",1);
        Data d2 = new Data("B",1);
        Data d3 = new Data("C",1);
        Data d4 = new Data("D",1);

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);

        try {
            FileOutputStream fos = new FileOutputStream("Testgr.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d1);
            oos.writeObject(d2);
            oos.writeObject(d3);
            oos.writeObject(d4);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}