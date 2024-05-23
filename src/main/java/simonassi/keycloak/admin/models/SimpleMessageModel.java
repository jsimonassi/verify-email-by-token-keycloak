package simonassi.keycloak.admin.models;

public class SimpleMessageModel {
    private String message;
    public SimpleMessageModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
