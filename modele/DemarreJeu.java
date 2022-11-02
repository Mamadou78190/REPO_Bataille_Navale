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

        grille g2 = new grille(15, 15);

        personnage p11 = new personnage("KK"); 
        personnage p12 = new personnage("LL");
        personnage p13 = new personnage("MM");
        personnage p14 = new personnage("NN");
        personnage p15 = new personnage("OO");
        personnage p16 = new personnage("PP");
        personnage p17 = new personnage("QQ");
        personnage p18 = new personnage("RR");
        personnage p19 = new personnage("SS");
        personnage p20 = new personnage("TT");

        String l = g2.placerNavire(p11);
        String m = g2.placerNavire(p12);
        String n = g2.placerNavire(p13);
        String o = g2.placerNavire(p14);
        String p = g2.placerNavire(p15);
        String q = g2.placerNavire(p16);
        String r = g2.placerNavire(p17);
        String s = g2.placerNavire(p18);
        String t = g2.placerNavire(p19);
        String u = g2.placerNavire(p20);

        public void jouer(){

            g1.afficher();

            System.out.println("//////////////////////////////////////////////////////////////");

            g2.afficher();

        }

        
        
    


    
}
