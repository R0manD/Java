package labs.lab3;

import com.fasterxml.jackson.databind.ObjectMapper;
import labs.lab1.Employee;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Серіалізатор для формату JSON.
 */
public class JsonSerializer implements Serializer<Employee> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void serialize(Employee employee, Path filePath) throws IOException {
        objectMapper.writeValue(filePath.toFile(), employee);
    }

    @Override
    public Employee deserialize(Path filePath) throws IOException {
        return objectMapper.readValue(filePath.toFile(), Employee.class);
    }
}
