package labs.lab1;

import labs.lab4.ProductBuilder;

import java.util.Comparator;
import java.util.Objects;

/**
 * Клас, що представляє продукт у зоомагазині.
 */
public class Product implements Comparable<Product> {
    private final int id;          // Унікальний ідентифікатор продукту
    private final String name;     // Назва продукту
    private final String type;     // Тип продукту (їжа, іграшка тощо)
    private final double price;     // Ціна продукту

    public Product(ProductBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.price = builder.price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                name.equals(product.name) &&
                type.equals(product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, price);
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price); // Порівнюємо за ціною
    }
}