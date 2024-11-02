package labs.lab3;


import labs.lab1.Employee;
import labs.lab4.EmployeeBuilder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainSerialize {
    public static void main(String[] args) {
        // Створення об'єкта Employee
        Employee employee = new EmployeeBuilder()
                .setId(1)
                .setFullname("John Doe")
                .setPosition("Manager")
                .setSalary(50000.00)
                .setHireDate("2020-05-15")
                .build();

        // Шляхи до файлів для серіалізації
        Path jsonFile = Paths.get("employee.json");
        Path xmlFile = Paths.get("employee.xml");
        Path yamlFile = Paths.get("employee.yaml");

        // Тестування JSON серіалізації та десеріалізації
        try {
            JsonSerializer jsonSerializer = new JsonSerializer();
            jsonSerializer.serialize(employee, jsonFile);
            System.out.println("Serialized to JSON:");
            System.out.println(jsonSerializer.deserialize(jsonFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Тестування XML серіалізації та десеріалізації
        try {
            XmlSerializer xmlSerializer = new XmlSerializer();
            xmlSerializer.serialize(employee, xmlFile);
            System.out.println("\nSerialized to XML:");
            System.out.println(xmlSerializer.deserialize(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Тестування YAML серіалізації та десеріалізації
        try {
            YamlSerializer yamlSerializer = new YamlSerializer();
            yamlSerializer.serialize(employee, yamlFile);
            System.out.println("\nSerialized to YAML:");
            System.out.println(yamlSerializer.deserialize(yamlFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
