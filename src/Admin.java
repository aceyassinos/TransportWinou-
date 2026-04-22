// fonctionnalité administration - Dhia
public class Admin {
    private String nom;

    public Admin(String nom) {
        this.nom = nom;
    }

    public void gererLignes(Ligne ligne) {
        if (ligne == null) {
            System.out.println(nom + " : aucune ligne fournie pour la gestion.");
        } else {
            System.out.println(nom + " gère la ligne " + ligne.getNom() + " (type=" + ligne.getType() + ").");
        }
    }

    public void consulterStatistiques() {
        System.out.println(nom + " consulte les statistiques du système...");
    }
}
