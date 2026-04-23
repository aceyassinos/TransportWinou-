import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("🚍 TRANSPORTWINOU - SIMULATION COMPLÈTE 🚍");
        System.out.println("==========================================");

        // 1. Utilisateur s'inscrit et se connecte
        System.out.println("\n📝 SCÉNARIO 1: INSCRIPTION ET CONNEXION UTILISATEUR");
        System.out.println("--------------------------------------------------");
        Utilisateur utilisateur = new Utilisateur(1, "Alice Dupont", "alice@example.com", "motdepasse123");

        boolean inscriptionReussie = utilisateur.sInscrire();
        if (inscriptionReussie) {
            boolean connexionReussie = utilisateur.seConnecter("alice@example.com", "motdepasse123");
            if (connexionReussie) {
                System.out.println("✅ Utilisateur connecté avec succès!");
            }
        }

        // 2. Recherche de trajet
        System.out.println("\n🗺️ SCÉNARIO 2: RECHERCHE DE TRAJET");
        System.out.println("-----------------------------------");
        List<Station> stationsTrajet = new ArrayList<>();
        stationsTrajet.add(new Station(1, "Station Centrale", "Centre-ville"));
        stationsTrajet.add(new Station(2, "Place de la Gare", "Centre-ville"));
        stationsTrajet.add(new Station(3, "Parc des Expositions", "Périphérie"));

        Trajet trajet = new Trajet(301, "Station Centrale", "Parc des Expositions", 18, stationsTrajet);
        trajet.rechercherTrajet();
        trajet.afficherStations();

        utilisateur.consulterTrajet(trajet);

        // 3. GPS envoie des mises à jour de position
        System.out.println("\n📍 SCÉNARIO 3: MISES À JOUR GPS");
        System.out.println("-------------------------------");
        Ligne ligne = new Ligne(101, "Ligne Express A", "Bus");
        GPS gps = new GPS();

        ligne.afficherPosition();
        gps.envoyerPosition(ligne);

        // Simulation de réception de position par la ligne
        ligne.recevoirPosition(gps, "Arrêt suivant : Place de la Gare");

        // 4. Incident génère une Alerte
        System.out.println("\n🚨 SCÉNARIO 4: INCIDENT ET GÉNÉRATION D'ALERTE");
        System.out.println("---------------------------------------------");
        gps.envoyerIncident("Accident signalé sur la ligne Express A - Déviation mise en place");

        // 5. L'Alerte crée une Notification
        System.out.println("\n📢 SCÉNARIO 5: CRÉATION DE NOTIFICATION À PARTIR D'ALERTE");
        System.out.println("------------------------------------------------------");
        Alerte alerte = new Alerte(201, "Incident Critique", "Accident sur ligne Express A - Bus dévié");
        alerte.envoyerAlerte();
        alerte.afficherDetails();

        // Création de notification à partir de l'alerte
        String dateNotification = "2026-04-23 14:30:00";
        Notification notification = alerte.genererNotification(dateNotification);
        notification.envoyer();
        notification.afficher();

        // 6. L'Utilisateur reçoit la Notification
        System.out.println("\n👤 SCÉNARIO 6: RÉCEPTION DE NOTIFICATION PAR UTILISATEUR");
        System.out.println("------------------------------------------------------");
        utilisateur.recevoirNotification(notification);

        // 7. L'Admin gère les lignes et consulte les statistiques
        System.out.println("\n👨‍💼 SCÉNARIO 7: GESTION ADMINISTRATEUR");
        System.out.println("--------------------------------------");
        Admin admin = new Admin("Directeur Transport", List.of(ligne));
        admin.listerLignes();

        // Création d'une liste d'alertes pour la supervision
        List<Alerte> alertes = List.of(alerte);
        admin.consulterStatistiques(124, alertes, List.of(notification));

        // Simulation de réservation de trajet
        System.out.println("\n🎫 SCÉNARIO BONUS: RÉSERVATION DE TRAJET");
        System.out.println("----------------------------------------");
        trajet.reserverTrajet(utilisateur.getNom());

        System.out.println("\n==========================================");
        System.out.println("✅ SIMULATION TRANSPORTWINOU TERMINÉE ✅");
        System.out.println("==========================================");
    }
}