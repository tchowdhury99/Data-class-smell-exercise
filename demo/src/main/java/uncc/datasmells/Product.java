package uncc.datasmells;

public class Product {

    String id;
    String name;
    double price;

    public Product(String id, String name, double price) {
        Validation.notBlank(id, "product id");
        Validation.notBlank(name, "product name");
        Validation.nonNegative(price, "product price");
        this.id = id;
        this.name = name;
        this.price = price;
    }

  
    public String receiptLine() {
        return "- " + name + " $" + price;
    }

    public double unitPrice() {
        return price;
    }

    public boolean isFree() {
        return price == 0.0;
    }

    public void renameTo(String newName) {
        Validation.notBlank(newName, "product name");
        this.name = newName;
    }

    public void changePriceTo(double newPrice) {
        Validation.nonNegative(newPrice, "product price");
        this.price = newPrice;
    }

    public boolean matchesId(String otherId) {
        return id != null && id.equals(otherId);
    }
}