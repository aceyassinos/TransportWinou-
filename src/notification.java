public class Notification {
    private final int id;
    private final String contenu;
    private final String date;

    public Notification(int id, String contenu, String date) {
        this.id = id;
        this.contenu = normalize(contenu, "Contenu indisponible");
        this.date = normalize(date, "Date inconnue");
    }

    public Notification(Alerte alerte, String date) {
        if (alerte == null) {
            this.id = 0;
            this.contenu = "Notification générée à partir d'une alerte invalide.";
        } else {
            this.id = alerte.getId();
            this.contenu = "Alerte " + alerte.getType() + " : " + alerte.getMessage();
        }
        this.date = normalize(date, "Date inconnue");
    }

    public int getId() {
        return id;
    }

    public String getContenu() {
        return contenu;
    }

    public String getDate() {
        return date;
    }

    public void envoyer() {
        System.out.println("[NOTIFICATION] status=envoyée | id=" + id + " | date=" + date);
        System.out.println(">> Contenu : " + contenu);
        System.out.println(">> Le message a été transmis à l'utilisateur.");
    }

    public void afficher() {
        System.out.println("----------------------------------");
        System.out.println("NOTIFICATION #" + id);
        System.out.println("Date : " + date);
        System.out.println("Message :");
        System.out.println(contenu);
        System.out.println("----------------------------------");
    }

    @Override
    public String toString() {
        return "Notification{id=" + id + ", date='" + date + "', contenu='" + contenu + "'}";
    }

    private String normalize(String value, String fallback) {
        if (value == null || value.isBlank()) {
            return fallback;
        }
        String trimmed = value.trim();
        return trimmed.isEmpty() ? fallback : trimmed;
    }
}
