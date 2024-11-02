package labs.lab4;


import labs.lab1.Animal;
import labs.lab1.Employee;
import labs.lab1.Order;
import labs.lab1.Product;

import java.util.ArrayList;
import java.util.List;

public class MainBuilder {
    public static void main(String[] args) {
        // Тестування AnimalBuilder
        System.out.println("Testing AnimalBuilder:");
        try {
            Animal animal1 = new AnimalBuilder()
                    .setId(1)
                    .setName("Buddy")
                    .setSpecies("Dog")
                    .setAge(3)
                    .build();
            System.out.println(animal1);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            Animal animal2 = new AnimalBuilder()
                    .setId(-1) // Невірний ID
                    .setName("") // Невірне ім'я
                    .setSpecies("Cat")
                    .setAge(5)
                    .build();
            System.out.println(animal2);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // Тестування ProductBuilder
        System.out.println("\nTesting ProductBuilder:");
        try {
            Product product1 = new ProductBuilder()
                    .setId(1)
                    .setName("Dog Food")
                    .setType("Food")
                    .setPrice(25.99)
                    .build();
            System.out.println(product1);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            Product product2 = new ProductBuilder()
                    .setId(2)
                    .setName(null) // Невірна назва
                    .setType("Toy")
                    .setPrice(-5.0) // Невірна ціна
                    .build();
            System.out.println(product2);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // Тестування EmployeeBuilder
        System.out.println("\nTesting EmployeeBuilder:");
        try {
            Employee employee1 = new EmployeeBuilder()
                    .setId(1)
                    .setFullname("John Doe")
                    .setPosition("Manager")
                    .setSalary(50000.00)
                    .setHireDate("2020-05-15")
                    .build();
            System.out.println(employee1);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            Employee employee2 = new EmployeeBuilder()
                    .setId(0) // Невірний ID
                    .setFullname("") // Невірне ім'я
                    .setPosition("Sales Associate")
                    .setSalary(-1000.00) // Невірна зарплата
                    .setHireDate("2020-15-05") // Невірний формат дати
                    .build();
            System.out.println(employee2);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // Тестування OrderBuilder
        System.out.println("\nTesting OrderBuilder:");
        try {
            List<Animal> animals = new ArrayList<>();
            Animal animal1 = new AnimalBuilder()
                    .setId(1)
                    .setName("Buddy")
                    .setSpecies("Dog")
                    .setAge(3)
                    .build();
            animals.add(animal1);

            List<Product> products = new ArrayList<>();
            Product product1 = new ProductBuilder()
                    .setId(1)
                    .setName("Dog Food")
                    .setType("Food")
                    .setPrice(25.99)
                    .build();
            products.add(product1);

            Order order1 = new OrderBuilder()
                    .setId(1)
                    .setAnimalList(animals)
                    .setProductList(products)
                    .setEmployeeId(1)
                    .setOrderDate("2023-10-31")
                    .build();
            System.out.println(order1);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            Order order2 = new OrderBuilder()
                    .setId(-5) // Невірний ID
                    .setAnimalList(null) // Може бути null або порожнім списком
                    .setProductList(new ArrayList<>()) // Порожній список продуктів
                    .setEmployeeId(0) // Невірний ID працівника
                    .setOrderDate("31-10-2023") // Невірний формат дати
                    .build();
            System.out.println(order2);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}