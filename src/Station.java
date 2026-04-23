public class Station {
    private int id;
    private String nom;
    private String emplacement;

    // Constructor
    public Station(int id, String nom, String emplacement) {
        this.id = id;
        this.nom = nom;
        this.emplacement = emplacement;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmplacement() {
        return emplacement;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    // Method to display station details
    public void afficherDetails() {
        System.out.println("========== STATION ==========");
        System.out.println("ID: " + id);
        System.out.println("Nom: " + nom);
        System.out.println("Emplacement: " + emplacement);
        System.out.println("=============================");
    }
}
