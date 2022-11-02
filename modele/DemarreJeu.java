package modele;

import modele.grille;
import modele.personnage;

public class DemarreJeu {

        grille g1 = new grille(15, 15);

        personnage p1 = new personnage("AA"); 
        personnage p2 = new personnage("BB");
        personnage p3 = new personnage("CC");
        personnage p4 = new personnage("DD");
        personnage p5 = new personnage("EE");
        personnage p6 = new personnage("FF");
        personnage p7 = new personnage("GG");
        personnage p8 = new personnage("HH");
        personnage p9 = new personnage("II");
        personnage p10 = new personnage("JJ");

        String b = g1.placerNavire(p1);
        String c = g1.placerNavire(p2);
        String d = g1.placerNavire(p3);
        String e = g1.placerNavire(p4);
        String f = g1.placerNavire(p5);
        String g = g1.placerNavire(p6);
        String h = g1.placerNavire(p7);
        String i = g1.placerNavire(p8);
        String j = g1.placerNavire(p9);
        String k = g1.placerNavire(p10);

        public void jouer(){

            g1.afficher();

        System.out.println("A -> |"+b);
        System.out.println("B -> |" +c);
        System.out.println("C -> |"+d);
        System.out.println("D -> |"+e);
        System.out.println("E -> |"+f);
        System.out.println("F -> |"+g);
        System.out.println("G -> |"+h);
        System.out.println("H -> |"+i);
        System.out.println("I -> |"+j);
        System.out.println("J -> |"+k);
        }

    


    
}
