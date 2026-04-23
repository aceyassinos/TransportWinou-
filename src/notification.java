public class notification {
    private int id;
    private String contenu;
    private String date;

    // Constructor
    public notification(int id, String contenu, String date) {
        this.id = id;
        this.contenu = contenu;
        this.date = date;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Method to send notification
    public void envoyer() {
        System.out.println("Notification envoyée: " + contenu + " à " + date);
    }

    // Method to display notification
    public void afficher() {
        System.out.println("========== NOTIFICATION ==========");
        System.out.println("ID: " + id);
        System.out.println("Contenu: " + contenu);
        System.out.println("Date: " + date);
        System.out.println("==================================");
    }
}
