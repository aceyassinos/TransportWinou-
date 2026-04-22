public class Utilisateur {
    private int id;
    private String nom;
    private String email;
    private String motDePasse;

    public Utilisateur(int id, String nom, String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void sInscrire() {
        System.out.println("Utilisateur " + nom + " (" + email + ") est inscrit avec succès.");
    }

    public void seConnecter() {
        System.out.println("Utilisateur " + nom + " s'est connecté avec l'email " + email + ".");
    }
    public void recevoirAlerte(String message) {
    System.out.println("Alerte reçue par " + nom + " : " + message);
    }
    @Override
    public String toString() {
        return "Utilisateur: " + nom + " (" + email + ")";
    }
}
