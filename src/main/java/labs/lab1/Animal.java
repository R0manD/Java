package labs.lab1;

import labs.lab4.AnimalBuilder;

import java.util.Objects;

/**
 * Клас, що представляє тварину в зоомагазині.
 */
public class  Animal implements Comparable<Animal>{
    private final int id;
    private final String name;
    private final String species;
    private final int age;

    public Animal(AnimalBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.species = builder.species;
        this.age = builder.age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return id == animal.id &&
                age == animal.age &&
                name.equals(animal.name) &&
                species.equals(animal.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, species, age);
    }

    @Override
    public int compareTo(Animal other) {
        return Integer.compare(this.age, other.age); // Порівнюємо за віком
    }
}