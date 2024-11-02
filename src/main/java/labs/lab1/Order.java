package labs.lab1;

import labs.lab4.OrderBuilder;

import java.util.List;
import java.util.Objects;

/**
 * Клас, що представляє замовлення в зоомагазині.
 */
public class Order {
    private final int id;                     // Унікальний ідентифікатор замовлення
    private final List<Animal> animalList;    // Список тварин в замовленні
    private final List<Product> productList;   // Список продуктів в замовленні
    private final int employeeId;              // Ідентифікатор працівника, який обробив замовлення
    private final String orderDate;            // Дата замовлення

    public Order(OrderBuilder builder) {
        this.id = builder.id;
        this.animalList = builder.animalList;
        this.productList = builder.productList;
        this.employeeId = builder.employeeId;
        this.orderDate = builder.orderDate;
    }

    public int getId() {
        return id;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", animalList=" + animalList +
                ", productList=" + productList +
                ", employeeId=" + employeeId +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id == order.id &&
                employeeId == order.employeeId &&
                Objects.equals(animalList, order.animalList) &&
                Objects.equals(productList, order.productList) &&
                Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animalList, productList, employeeId, orderDate);
    }
}