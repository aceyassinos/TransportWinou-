// fonctionnalité suivi temps réel - Yassine
public class GPS {
    public void envoyerPosition(Ligne ligne) {
        if (ligne == null) {
            System.out.println("GPS : aucune ligne fournie pour l'envoi de position.");
            return;
        }
        System.out.println("GPS : position envoyée pour la ligne " + ligne.getNom() + " (type=" + ligne.getType() + ").");
    }

    public void envoyerIncident(String message) {
        System.out.println("GPS : incident signalé -> " + message);
    }
}
