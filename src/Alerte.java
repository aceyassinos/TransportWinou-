// fonctionnalité alertes - Aziz
public class Alerte {
    private int id;
    private String type;
    private String message;

    public Alerte(int id, String type, String message) {
        this.id = id;
        this.type = type;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public void envoyerAlerte() {
        System.out.println("Alerte [" + type + "] : " + message + " (id=" + id + ")");
    }
}
