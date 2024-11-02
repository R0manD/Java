package labs.lab3;


import labs.lab1.Employee;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Серіалізатор для формату YAML.
 */
public class YamlSerializer implements Serializer<Employee> {
    private final Yaml yaml = new Yaml();

    @Override
    public void serialize(Employee employee, Path filePath) throws IOException {
        String yamlString = yaml.dump(employee);
        Files.write(filePath, yamlString.getBytes());
    }

    @Override
    public Employee deserialize(Path filePath) throws IOException {
        return yaml.loadAs(Files.newInputStream(filePath), Employee.class);
    }
}