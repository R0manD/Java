package labs.lab4;

import labs.lab1.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Builder для створення об'єктів Animal з валідацією полів.
 */
public class AnimalBuilder {
    public int id;
    public String name;
    public String species;
    public int age;

    private List<String> validationErrors = new ArrayList<>();

    public AnimalBuilder setId(int id) {
        if (id <= 0) {
            validationErrors.add("Invalid ID: " + id + ". ID must be greater than 0.");
        }
        this.id = id;
        return this;
    }

    public AnimalBuilder setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            validationErrors.add("Invalid Name: '" + name + "'. Name cannot be null or empty.");
        }
        this.name = name;
        return this;
    }

    public AnimalBuilder setSpecies(String species) {
        if (species == null || species.trim().isEmpty()) {
            validationErrors.add("Invalid Species: '" + species + "'. Species cannot be null or empty.");
        }
        this.species = species;
        return this;
    }

    public AnimalBuilder setAge(int age) {
        if (age < 0 || age > 20) {
            validationErrors.add("Invalid Age: " + age + ". Age must be between 0 and 100.");
        }
        this.age = age;
        return this;
    }

    public Animal build() {
        if (!validationErrors.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationErrors));
        }

        return new Animal(this);
    }
}