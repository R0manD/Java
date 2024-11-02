package labs.lab1;




import labs.lab1.Animal;
import labs.lab1.Employee;
import labs.lab1.Order;
import labs.lab1.Product;
import labs.lab4.AnimalBuilder;
import labs.lab4.EmployeeBuilder;
import labs.lab4.OrderBuilder;
import labs.lab4.ProductBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Testing Animal:");
        try {
            Animal animal1 = new AnimalBuilder()
                    .setId(1)
                    .setName("Buddy")
                    .setSpecies("Dog")
                    .setAge(3)
                    .build();


            Animal animal2 = new AnimalBuilder()
                    .setId(1)
                    .setName("Miki")
                    .setSpecies("Cat")
                    .setAge(5)
                    .build();

            System.out.println("Animal1 - equals(Animal2)" + animal1.equals(animal2));

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("\nTesting Product:");
        try {
            Product product1 = new ProductBuilder()
                    .setId(1)
                    .setName("Dog Food")
                    .setType("Food")
                    .setPrice(25.99)
                    .build();
            System.out.println("Hash code" + product1.hashCode());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("\nTesting Employee:");
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
            System.out.println("hashCode - order1" + order1.hashCode());
            System.out.println("Equals: " + order1.equals(order1));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
