// fonctionnalité recherche itinéraire - Amine
import java.util.Collections;
import java.util.List;

public class Trajet {
    private final int id;
    private final String depart;
    private final String destination;
    private final int tempsEstime;
    private final List<Station> stations;

    public Trajet(int id, String depart, String destination, int tempsEstime, List<Station> stations) {
        this.id = id;
        this.depart = normalize(depart);
        this.destination = normalize(destination);
        this.tempsEstime = tempsEstime;
        this.stations = stations != null ? List.copyOf(stations) : Collections.emptyList();
    }

    public int getId() {
        return id;
    }

    public String getDepart() {
        return depart;
    }

    public String getDestination() {
        return destination;
    }

    public int getTempsEstime() {
        return tempsEstime;
    }

    public List<Station> getStations() {
        return stations;
    }

    public boolean estValide() {
        return !depart.isBlank() && !destination.isBlank() && !depart.equalsIgnoreCase(destination);
    }

    public boolean aStations() {
        return !stations.isEmpty();
    }

    private boolean tempsEstimeValide() {
        return tempsEstime > 0;
    }

    private String normalize(String value) {
        return value != null ? value.trim() : "";
    }

    public int calculerTempsRestant() {
        if (!tempsEstimeValide()) {
            System.out.println("Impossible de calculer le temps restant : temps estimé invalide pour le trajet " + id + ".");
            return 0;
        }
        int tempsRestant = tempsEstime / 2;
        System.out.println("Temps restant estimé pour le trajet " + id + " : " + tempsRestant + " minutes.");
        return tempsRestant;
    }

    public void reserverTrajet(String utilisateurNom) {
        if (!estValide()) {
            System.out.println("Réservation impossible : trajet invalide.");
            return;
        }

        String nomUtilisateur = utilisateurNom != null && !utilisateurNom.isBlank()
                ? utilisateurNom.trim()
                : "Utilisateur inconnu";

        System.out.println("Réservation confirmée pour " + nomUtilisateur + " !");
        afficherResumeTrajet();
    }

    public void rechercherTrajet() {
        if (!estValide()) {
            System.out.println("Erreur : le trajet doit avoir un départ et une destination valides.");
            return;
        }

        afficherResumeTrajet();
        if (!tempsEstimeValide()) {
            System.out.println("  Raison      : temps estimé invalide");
        }
    }

    public void afficherStations() {
        if (!aStations()) {
            System.out.println("Aucune station définie pour le trajet " + id + ".");
            return;
        }

        System.out.println("Stations du trajet " + id + " :");
        for (Station station : stations) {
            if (station != null) {
                System.out.println("- " + station.getNom() + " (" + station.getEmplacement() + ")");
            }
        }
    }

    private void afficherResumeTrajet() {
        System.out.println("============================================");
        System.out.println("Trajet n°" + id + " :");
        System.out.println("  Départ       : " + depart);
        System.out.println("  Destination  : " + destination);
        System.out.println("  Temps estimé : " + (tempsEstimeValide() ? tempsEstime + " minutes" : "non disponible"));
        System.out.println("============================================");
    }

    @Override
    public String toString() {
        return "Trajet{" +
               "id=" + id +
               ", depart='" + depart + '\'' +
               ", destination='" + destination + '\'' +
               ", tempsEstime=" + tempsEstime +
               ", stations=" + stations.size() +
               '}';
    }
}
