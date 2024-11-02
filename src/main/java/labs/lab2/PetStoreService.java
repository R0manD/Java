package labs.lab2;

import labs.lab1.Animal;
import labs.lab1.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Сервіс для роботи з колекціями тварин і продуктів.
 */
public class PetStoreService {

    /**
     * Метод для отримання списку тварин, відсортованих за віком.
     *
     * @param animals Список тварин.
     * @return Відсортований список тварин.
     */
    public List<Animal> getSortedAnimalsByAge(List<Animal> animals) {
        return animals.stream()
                .sorted() // Використовуємо Comparable для сортування
                .collect(Collectors.toList());
    }

    /**
     * Метод для отримання списку продуктів, відсортованих за ціною.
     *
     * @param products Список продуктів.
     * @return Відсортований список продуктів.
     */
    public List<Product> getSortedProductsByPrice(List<Product> products) {
        return products.stream()
                .sorted() // Використовуємо Comparable для сортування
                .collect(Collectors.toList());
    }

    /**
     * Метод для групування тварин за видом.
     *
     * @param animals Список тварин.
     * @return Карта, де ключ - вид тварини, а значення - список тварин цього виду.
     */
    public Map<String, List<Animal>> groupAnimalsBySpecies(List<Animal> animals) {
        return animals.stream()
                .collect(Collectors.groupingBy(Animal::getSpecies)); // Групуємо за видом
    }

    /**
     * Метод для оновлення інформації про тварину за її ID.
     *
     * @param animals Список тварин.
     * @param id      ID тварини, яку потрібно оновити.
     * @param newAnimal Тварина з новими даними.
     * @return true, якщо оновлення успішне; false в іншому випадку.
     */
    public boolean updateAnimalById(List<Animal> animals, int id, Animal newAnimal) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getId() == id) {
                animals.set(i, newAnimal);
                return true; // Оновлено успішно
            }
        }
        return false; // Тварина з таким ID не знайдена
    }

    /**
     * Метод для оновлення інформації про продукт за його ID.
     *
     * @param products Список продуктів.
     * @param id      ID продукту, який потрібно оновити.
     * @param newProduct Продукт з новими даними.
     * @return true, якщо оновлення успішне; false в іншому випадку.
     */
    public boolean updateProductById(List<Product> products, int id, Product newProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, newProduct);
                return true; // Оновлено успішно
            }
        }
        return false; // Продукт з таким ID не знайдено
    }

    /**
     * Метод для очищення списків тварин і продуктів.
     *
     * @param animals Список тварин.
     * @param products Список продуктів.
     */
    public void clearCollections(List<Animal> animals, List<Product> products) {
        animals.clear();  // Очищення списку тварин
        products.clear(); // Очищення списку продуктів
    }
}