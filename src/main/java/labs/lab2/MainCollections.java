package labs.lab2;


import labs.lab1.Animal;
import labs.lab1.Product;
import labs.lab4.AnimalBuilder;
import labs.lab4.ProductBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainCollections {
    public static void main(String[] args) {
        // Створення колекцій тварин
        List<Animal> animals = new ArrayList<>();
        animals.add(new AnimalBuilder().setId(1).setName("Buddy").setSpecies("Dog").setAge(3).build());
        animals.add(new AnimalBuilder().setId(2).setName("Whiskers").setSpecies("Cat").setAge(2).build());
        animals.add(new AnimalBuilder().setId(3).setName("Max").setSpecies("Dog").setAge(5).build());

        // Створення колекцій продуктів
        List<Product> products = new ArrayList<>();
        products.add(new ProductBuilder().setId(1).setName("Dog Food").setType("Food").setPrice(25.99).build());
        products.add(new ProductBuilder().setId(2).setName("Cat Toy").setType("Toy").setPrice(12.50).build());
        products.add(new ProductBuilder().setId(3).setName("Cat Food").setType("Food").setPrice(15.00).build());

        // Використання сервісних методів
        PetStoreService petStoreService = new PetStoreService();

        // Сортування тварин за віком
        System.out.println("Sorted Animals by Age:");
        List<Animal> sortedAnimals = petStoreService.getSortedAnimalsByAge(animals);
        sortedAnimals.forEach(System.out::println);

        // Сортування продуктів за ціною
        System.out.println("\nSorted Products by Price:");
        List<Product> sortedProducts = petStoreService.getSortedProductsByPrice(products);
        sortedProducts.forEach(System.out::println);

        // Групування тварин за видом
        System.out.println("\nGrouped Animals by Species:");
        var groupedAnimals = petStoreService.groupAnimalsBySpecies(animals);
        groupedAnimals.forEach((species, animalList) -> {
            System.out.println(species + ": " + animalList);
        });

        // Оновлення інформації про тварину
        System.out.println("\nUpdating Animal with ID 1:");
        boolean updated = petStoreService.updateAnimalById(animals,
                1,
                new AnimalBuilder().setId(1).setName("Buddy Updated").setSpecies("Dog").setAge(4).build());

        System.out.println(updated ? "Update successful." : "Update failed.");

        // Перевірка оновленого списку тварин
        animals.forEach(System.out::println);

        // Оновлення інформації про продукт
        System.out.println("\nUpdating Product with ID 2:");
        updated = petStoreService.updateProductById(products,
                2,
                new ProductBuilder().setId(2).setName("Cat Toy Updated").setType("Toy").setPrice(15.00).build());

        System.out.println(updated ? "Update successful." : "Update failed.");

        // Перевірка оновленого списку продуктів
        products.forEach(System.out::println);

        // Очищення колекцій
        System.out.println("\nClearing collections...");
        petStoreService.clearCollections(animals, products);

        System.out.println("Animals: " + animals.size() + ", Products: " + products.size());
    }
}