package labs.lab4;

import labs.lab1.Animal;
import labs.lab1.Order;
import labs.lab1.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Builder для створення об'єктів Order з валідацією полів.
 */
public class OrderBuilder {
    public int id;
    public List<Animal> animalList;     // Список тварин в замовленні
    public List<Product> productList;     // Список продуктів в замовленні
    public int employeeId;                 // Ідентифікатор працівника
    public String orderDate;               // Дата замовлення

    private List<String> validationErrors = new ArrayList<>();

    public OrderBuilder setId(int id) {
        if (id <= 0) {
            validationErrors.add("Invalid ID: " + id + ". ID must be greater than 0.");
        }
        this.id = id;
        return this;
    }

    public OrderBuilder setAnimalList(List<Animal> animalList) {
        this.animalList = animalList; // Може бути null або порожнім списком
        return this;
    }

    public OrderBuilder setProductList(List<Product> productList) {
        this.productList = productList; // Може бути null або порожнім списком
        return this;
    }

    public OrderBuilder setEmployeeId(int employeeId) {
        if (employeeId <= 0) {
            validationErrors.add("Invalid Employee ID: " + employeeId + ". Employee ID must be greater than 0.");
        }
        this.employeeId = employeeId;
        return this;
    }

    public OrderBuilder setOrderDate(String orderDate) {
        if (orderDate == null || !orderDate.matches("\\d{4}-\\d{2}-\\d{2}")) { // Формат дати YYYY-MM-DD
            validationErrors.add("Invalid Order Date: '" + orderDate + "'. Order Date must be in the format YYYY-MM-DD.");
        }
        this.orderDate = orderDate;
        return this;
    }

    public Order build() {
        if (!validationErrors.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationErrors));
        }

        return new Order(this);
    }
}