// ajout authentification - Khalil
public class Utilisateur {
    private final int id;
    private final String nom;
    private final String email;
    private final String motDePasse;

    public Utilisateur(int id, String nom, String email, String motDePasse) {
        this.id = id;
        this.nom = nom != null ? nom : "";
        this.email = email != null ? email.trim() : "";
        this.motDePasse = motDePasse != null ? motDePasse : "";
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

    public boolean sInscrire() {
        boolean isValidEmail = email != null && !email.isBlank();
        if (isValidEmail) {
            System.out.println("Utilisateur " + nom + " (" + email + ") est inscrit avec succès.");
        } else {
            System.out.println("Inscription échouée : email invalide.");
        }
        return isValidEmail;
    }

    public boolean seConnecter(String email, String motDePasse) {
        if (email == null || email.isBlank() || motDePasse == null || motDePasse.isBlank()) {
            System.out.println("Connexion échouée : email ou mot de passe invalide.");
            return false;
        }

        if (this.email.equals(email) && this.motDePasse.equals(motDePasse)) {
            System.out.println("Utilisateur " + nom + " s'est connecté avec l'email " + email + ".");
            return true;
        } else {
            System.out.println("Connexion échouée pour " + email + ".");
            return false;
        }
    }

    public void recevoirNotification(Notification notif) {
        if (notif == null) {
            System.out.println("Notification invalide pour " + nom + ".");
            return;
        }
        System.out.println("Notification reçue par " + nom + " :");
        notif.afficher();
    }

    public void consulterTrajet(Trajet trajet) {
        if (trajet == null) {
            System.out.println("Trajet invalide pour " + nom + ".");
            return;
        }
        System.out.println("Utilisateur " + nom + " consulte le trajet : " + trajet.getDepart() + " -> " + trajet.getDestination() + ".");
    }

    @Override
    public String toString() {
        return "Utilisateur {\n" +
               "  id: " + id + ",\n" +
               "  nom: '" + nom + "',\n" +
               "  email: '" + email + "'\n" +
               "}";
    }
}
// contribution Khalil - amélioration Sprint 2
