import modele.grille;
import modele.personnage;

public class App {
    public static void main(String[] args) throws Exception {

        grille g1 = new grille(15, 15);
        personnage p1 = new personnage("AA"); 
        personnage p2 = new personnage("BB");
        personnage p3 = new personnage("CC");
        personnage p4 = new personnage("DD");
        personnage p5 = new personnage("EE");
        personnage p6 = new personnage("FF");
        personnage p7 = new personnage("GG");
        personnage p8 = new personnage("HH");


        int a = g1.balayageCollision("gauche", p1, 4,4);
        g1.placerNavire(p1);
        g1.placerNavire(p2);
        g1.placerNavire(p3);
        g1.placerNavire(p4);
        g1.placerNavire(p5);
        g1.placerNavire(p6);
        g1.placerNavire(p7);
        //g1.placerNavire(p8);



        g1.afficher();
        System.out.println(a);

    }
} 