public class Alerte {
    private final int id;
    private final String type;
    private final String message;

    // Constructor
    public Alerte(int id, String type, String message) {
        this.id = id;
        this.type = normalize(type, "Type inconnu");
        this.message = normalize(message, "Message indisponible");
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

    // Method to check if alert is critical
    public boolean estCritique() {
        if (type == null) return false;
        String typeLower = type.toLowerCase();
        return typeLower.contains("critique") || typeLower.contains("urgent") ||
               typeLower.contains("incident") || typeLower.contains("panne");
    }

    // Method to send alert
    public void envoyerAlerte() {
        System.out.println("==========================================");
        System.out.println("🚨 SYSTÈME D'ALERTE - " + (estCritique() ? "ALERTE CRITIQUE" : "ALERTE") + " 🚨");
        System.out.println("ID Alerte : " + id);
        System.out.println("Type : " + type);
        System.out.println("Message : " + message);
        System.out.println("Statut : Envoyée aux systèmes concernés");
        System.out.println("==========================================");
    }

    // Method to generate a notification from this alert
    public Notification genererNotification(String date) {
        return new Notification(this, date);
    }

    // Method to display alert details
    public void afficherDetails() {
        System.out.println("========== ALERTE ==========");
        System.out.println("ID: " + id);
        System.out.println("Type: " + type);
        System.out.println("Message: " + message);
        System.out.println("Critique: " + (estCritique() ? "Oui" : "Non"));
        System.out.println("============================");
    }

    @Override
    public String toString() {
        return "Alerte{id=" + id + ", type='" + type + "', message='" + message + "'}";
    }

    private String normalize(String value, String fallback) {
        if (value == null || value.isBlank()) {
            return fallback;
        }
        String trimmed = value.trim();
        return trimmed.isEmpty() ? fallback : trimmed;
    }
}