// fonctionnalité suivi temps réel - Yassine
public class Ligne {
    private int id;
    private String nom;
    private String type;

    public Ligne(int id, String nom, String type) {
        this.id = id;
        this.nom = nom;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public void afficherPosition() {
        System.out.println("Ligne " + nom + " (" + type + ") est actuellement en position active.");
    }

    public void afficherTempsArrivee() {
        System.out.println("Ligne " + nom + " arrivera bientôt. Temps estimé : 5 minutes.");
    }
}
    