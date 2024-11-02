package labs.lab3;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import labs.lab1.Employee;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Серіалізатор для формату XML.
 */
public class XmlSerializer implements Serializer<Employee> {
    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public void serialize(Employee employee, Path filePath) throws IOException {
        xmlMapper.writeValue(filePath.toFile(), employee);
    }

    @Override
    public Employee deserialize(Path filePath) throws IOException {
        return xmlMapper.readValue(filePath.toFile(), Employee.class);
    }
}