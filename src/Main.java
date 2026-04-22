public class Main {
    public static void main(String[] args) {
        Utilisateur utilisateur = new Utilisateur(1, "Alice", "alice@example.com", "motdepasse123");
        utilisateur.sInscrire();
        utilisateur.seConnecter();

        System.out.println("----------------------");

        Ligne ligne = new Ligne(101, "Ligne A", "Bus");
        ligne.afficherPosition();
        ligne.afficherTempsArrivee();

        GPS gps = new GPS();
        gps.envoyerPosition(ligne);
        gps.envoyerIncident("Retard de trafic signalé sur la ligne A.");

        System.out.println("----------------------");

        Trajet trajet = new Trajet(301, "Station Centrale", "Parc des Expositions", 18);
        trajet.rechercherTrajet();

        System.out.println("----------------------");

        Alerte alerte = new Alerte(201, "Sécurité", "Veuillez porter un masque dans les transports.");
        alerte.envoyerAlerte();
        utilisateur.recevoirAlerte(alerte.getMessage());

        System.out.println("----------------------");

        Admin admin = new Admin("Administrateur");
        admin.gererLignes(ligne);
        admin.consulterStatistiques();

        System.out.println("----------------------");
        System.out.println("Simulation TransportWinou terminée.");
    }
}