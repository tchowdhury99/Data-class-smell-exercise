package uncc.datasmells;

public class Product {

    String id;
    String name;
    double price;

    public Product(String id, String name, double price) {
        Validation.requireNonBlank(id, "product id");
        Validation.requireNonBlank(name, "product name");
        Validation.requireNonNegative(price, "product price");

        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Behavior: exactly matches print format in OrderService today :contentReference[oaicite:6]{index=6}
    public String receiptLine() {
        return "- " + name + " $" + price;
    }

    public boolean isFree() {
        return price == 0.0;
    }

    public String getId() { return id; }
    public void setId(String id) {
        Validation.requireNonBlank(id, "product id");
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        Validation.requireNonBlank(name, "product name");
        this.name = name;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        Validation.requireNonNegative(price, "product price");
        this.price = price;
    }
}