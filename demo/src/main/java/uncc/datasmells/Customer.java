package uncc.datasmells;

public class Customer {

    String id;
    String name;
    String email;

    public Customer(String id, String name, String email) {
        Validation.requireNonBlank(id, "customer id");
        Validation.requireNonBlank(name, "customer name");
        Validation.requireNonBlank(email, "customer email");

        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Behavior
    public String displayName() {
        // Doesn’t affect existing output (Main prints only getName)
        return name;
    }

    public boolean hasEmail() {
        return email != null && !email.trim().isEmpty();
    }

    // Accessors (kept so Main and existing code still compile)
    public String getId() { return id; }
    public void setId(String id) {
        Validation.requireNonBlank(id, "customer id");
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        Validation.requireNonBlank(name, "customer name");
        this.name = name;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        Validation.requireNonBlank(email, "customer email");
        this.email = email;
    }
}