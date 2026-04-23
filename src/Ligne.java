// fonctionnalité suivi temps réel - Yassine
public class Ligne {
    private final int id;
    private final String nom;
    private final String type;
    private String position;

    public Ligne(int id, String nom, String type) {
        this.id = id;
        this.nom = normalize(nom, "Ligne inconnue");
        this.type = normalize(type, "Type inconnu");
        this.position = "Position inconnue";
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

    public String getPosition() {
        return position;
    }

    public void mettreAJourPosition(String nouvellePosition) {
        if (!estPositionValide(nouvellePosition)) {
            this.position = "Position inconnue";
            return;
        }
        this.position = nouvellePosition.trim();
    }

    public void recevoirPosition(GPS gps, String nouvellePosition) {
        if (gps == null) {
            System.out.println("Ligne " + nom + " : GPS introuvable pour la mise à jour de position.");
            return;
        }
        System.out.println("Ligne " + nom + " reçoit une mise à jour de position depuis " + gps.getClass().getSimpleName() + ".");
        mettreAJourPosition(nouvellePosition);
        afficherPosition();
    }

    public void afficherPosition() {
        System.out.println("Ligne " + nom + " (" + type + ") est actuellement à : " + position + ".");
    }

    public void afficherTempsArrivee() {
        int estimation = calculerTempsArrivee();
        System.out.println("Ligne " + nom + " arrivera bientôt. Temps estimé : " + estimation + " minutes.");
    }

    private boolean estPositionValide(String position) {
        return position != null && !position.isBlank() && !position.trim().isEmpty();
    }

    private int calculerTempsArrivee() {
        int baseMin = 4;
        int variation = (int) (Math.random() * 10); // 0 à 9 minutes
        return baseMin + variation;
    }

    private String normalize(String value, String fallback) {
        if (value == null || value.isBlank()) {
            return fallback;
        }
        String normalized = value.trim();
        return normalized.isEmpty() ? fallback : normalized;
    }
}
    