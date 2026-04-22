// fonctionnalité recherche itinéraire - Amine
public class Trajet {
    private int id;
    private String depart;
    private String destination;
    private int tempsEstime;

    public Trajet(int id, String depart, String destination, int tempsEstime) {
        this.id = id;
        this.depart = depart;
        this.destination = destination;
        this.tempsEstime = tempsEstime;
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

    public void rechercherTrajet() {
        System.out.println("Recherche du trajet " + id + " : " + depart + " -> " + destination + " (temps estimé : " + tempsEstime + " minutes)");
    }
}
