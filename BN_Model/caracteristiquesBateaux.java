package BN_Model;


public enum caracteristiquesBateaux {// enumeration des caracteristique des bateaux
    croiseur("croiseur",5,4, " CR "),cuirasse("cuirasse",7,9, " CU "),destroyer("Destroyer",3,1," DS "),sousMarin("sousmarin",1,1, " SM ");

    private final String name;
    private final int taille;
    private final int puissance;
    private final String visuel;

    public String getVisuel() {
        return visuel;
    }
    



    public int getTaille(){

        return this.taille;
    }
    public String getName() {
        return this.name;
    }
    public int getpuissance(){
        return this.puissance;
    }

    private caracteristiquesBateaux(String name, int taille, int puissance, String visuel){
        this.taille =taille;
        this.name = name;
        this.puissance = puissance;
        this.visuel = visuel;
    }

    @Override
    public String toString() {
        return "Caract. sont : "+name+", puissance : "+puissance+", taille : "+taille + " visuel : " +visuel;
    }
}
