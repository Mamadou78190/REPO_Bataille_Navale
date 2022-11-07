package BN_Model;


public enum caracteristiquesBateaux {// enumeration des caracteristique des bateaux
    croiseur("croiseur",5,4),cuirasse("cuirasse",7,9),destroyer("Destroyer",3,1),sousMarin("sousmarin",1,1);

    private final String name;
    private final int taille;
    private final int puissance;


    public int getTaille(){

        return this.taille;
    }
    public String getName() {
        return this.name;
    }
    public int getpuissance(){
        return this.puissance;
    }

    private caracteristiquesBateaux(String name, int taille, int puissance){
        this.taille =taille;
        this.name = name;
        this.puissance = puissance;
    }

    @Override
    public String toString() {
        return "Caract. sont : "+name+", puissance : "+puissance+", taille : "+taille;
    }
}
