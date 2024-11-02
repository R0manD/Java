package labs.lab3;

import java.io.IOException;
import java.nio.file.Path;

public interface Serializer<T> {
    void serialize(T object, Path filePath) throws IOException; // Метод для серіалізації об'єкта у файл
    T deserialize(Path filePath) throws IOException; // Метод для десеріалізації об'єкта з файлу
}
