public class Alerte {
    private int id;
    private String type;
    private String message;

    // Constructor
    public Alerte(int id, String type, String message) {
        this.id = id;
        this.type = type;
        this.message = message;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Method to send alert
    public void envoyerAlerte() {
        System.out.println("Alerte envoyée : " + type + " - " + message);
    }

    // Method to display alert details
    public void afficherDetails() {
        System.out.println("========== ALERTE ==========");
        System.out.println("ID: " + id);
        System.out.println("Type: " + type);
        System.out.println("Message: " + message);
        System.out.println("============================");
    }
}