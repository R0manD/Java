package labs.lab4;

import labs.lab1.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Builder для створення об'єктів Product з валідацією полів.
 */
public class ProductBuilder {
    public int id;
    public String name;
    public String type;
    public double price;

    private List<String> validationErrors = new ArrayList<>();

    public ProductBuilder setId(int id) {
        if (id <= 0) {
            validationErrors.add("Invalid ID: " + id + ". ID must be greater than 0.");
        }
        this.id = id;
        return this;
    }

    public ProductBuilder setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            validationErrors.add("Invalid Name: '" + name + "'. Name cannot be null or empty.");
        }
        this.name = name;
        return this;
    }

    public ProductBuilder setType(String type) {
        if (type == null || type.trim().isEmpty()) {
            validationErrors.add("Invalid Type: '" + type + "'. Type cannot be null or empty.");
        }
        this.type = type;
        return this;
    }

    public ProductBuilder setPrice(double price) {
        if (price < 0) { // Ціна не може бути негативною
            validationErrors.add("Invalid Price: " + price + ". Price must be non-negative.");
        }
        this.price = price;
        return this;
    }

    public Product build() {
        if (!validationErrors.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationErrors));
        }

        return new Product(this);
    }
}
