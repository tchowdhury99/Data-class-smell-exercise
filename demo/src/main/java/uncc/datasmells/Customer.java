package uncc.datasmells;

public class Customer {

    String id;
    String name;
    String email;

    public Customer(String id, String name, String email) {
        Validation.notBlank(id, "customer id");
        Validation.notBlank(name, "customer name");
        Validation.notBlank(email, "customer email");
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Behavior-rich (no getters/setters needed)
    public String displayName() {
        return name;
    }

    public String contactLabel() {
        return name + " <" + email + ">";
    }

    public boolean canBeContacted() {
        return email != null && !email.trim().isEmpty();
    }

    public void renameTo(String newName) {
        Validation.notBlank(newName, "customer name");
        this.name = newName;
    }

    public void changeEmailTo(String newEmail) {
        Validation.notBlank(newEmail, "customer email");
        this.email = newEmail;
    }

    public boolean matchesId(String otherId) {
        return id != null && id.equals(otherId);
    }
}