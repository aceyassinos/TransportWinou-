// fonctionnalité suivi temps réel - Yassine
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GPS {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private int incidentCounter = 1;

    public void envoyerPosition(Ligne ligne) {
        if (ligne == null) {
            System.out.println("GPS : aucune ligne fournie pour l'envoi de position.");
            return;
        }

        synchroniserPosition(ligne, "Position actuelle synchronisée");
    }

    private void synchroniserPosition(Ligne ligne, String position) {
        ligne.mettreAJourPosition(position);
        System.out.println("GPS : position envoyée pour la ligne " + ligne.getNom() + " (type=" + ligne.getType() + ").");
        ligne.afficherPosition();
    }

    public void envoyerIncident(String message) {
        if (message == null || message.isBlank()) {
            System.out.println("GPS : incident invalide, aucun message fourni.");
            return;
        }

        Alerte alerte = creerAlerte(message);
        alerte.envoyerAlerte();

        Notification notification = creerNotification(alerte);
        notification.envoyer();
        notification.afficher();
    }

    private Alerte creerAlerte(String message) {
        return new Alerte(incidentCounter++, "Incident GPS", message.trim());
    }

    private Notification creerNotification(Alerte alerte) {
        String date = LocalDateTime.now().format(DATE_FORMATTER);
        String contenu = "Alerte générée : " + alerte.getType() + " - " + alerte.getMessage();
        return new Notification(alerte.getId(), contenu, date);
    }
}
