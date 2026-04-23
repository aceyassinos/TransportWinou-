// fonctionnalité administration - Dhia
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Admin {
    private final String nom;
    private final List<Ligne> lignes;

    public Admin(String nom) {
        this.nom = nom != null && !nom.isBlank() ? nom.trim() : "Administrateur";
        this.lignes = new ArrayList<>();
    }

    public Admin(String nom, List<Ligne> lignes) {
        this.nom = nom != null && !nom.isBlank() ? nom.trim() : "Administrateur";
        this.lignes = lignes != null ? new ArrayList<>(lignes) : new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<Ligne> getLignes() {
        return Collections.unmodifiableList(lignes);
    }

    public void gererLigne(Ligne ligne) {
        if (ligne == null) {
            System.out.println(nom + " : aucune ligne fournie pour la gestion.");
            return;
        }
        if (!lignes.contains(ligne)) {
            lignes.add(ligne);
        }
        System.out.println(nom + " gère la ligne " + ligne.getNom() + " (type=" + ligne.getType() + ").");
    }

    public void listerLignes() {
        System.out.println("=== Lignes gérées par " + nom + " ===");
        if (lignes.isEmpty()) {
            System.out.println("Aucune ligne n'est actuellement gérée.");
            return;
        }
        for (Ligne ligne : lignes) {
            System.out.println("- " + ligne.getNom() + " (type=" + ligne.getType() + ")");
        }
    }

    public void consulterStatistiques(int nombreUtilisateurs, List<Alerte> alertes, List<Notification> notifications) {
        int lignesActives = lignes.size();
        int alertesRecues = alertes != null ? alertes.size() : 0;
        int notificationsEnvoyees = notifications != null ? notifications.size() : 0;

        System.out.println("==========================================");
        System.out.println(nom + " consulte les statistiques du système :");
        System.out.println("- Utilisateurs enregistrés : " + nombreUtilisateurs);
        System.out.println("- Lignes actives : " + lignesActives);
        System.out.println("- Alertes en cours : " + alertesRecues);
        System.out.println("- Notifications envoyées : " + notificationsEnvoyees);
        System.out.println("==========================================");

        superviserAlertes(alertes);
    }

    public void superviserAlertes(List<Alerte> alertes) {
        System.out.println("=== Supervision des alertes ===");
        if (alertes == null || alertes.isEmpty()) {
            System.out.println("Aucune alerte à signaler actuellement.");
            return;
        }

        for (Alerte alerte : alertes) {
            if (alerte == null) {
                continue;
            }
            if (estAlerteImportante(alerte)) {
                System.out.println("Incident important détecté :");
                alerte.afficherDetails();
            }
        }
    }

    private boolean estAlerteImportante(Alerte alerte) {
        if (alerte == null || alerte.getType() == null) {
            return false;
        }
        String type = alerte.getType().toLowerCase();
        return type.contains("critique") || type.contains("incident") || type.contains("urgent");
    }
}