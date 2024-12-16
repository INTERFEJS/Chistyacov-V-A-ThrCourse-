// 5 ВАРИАНТ. "Кэш данных" для временного хранения данных с использованием паттерна "Одиночка".

package TheLonerPattern;


// Класс для реализации паттерна "Одиночка"
import java.util.HashMap;
import java.util.Map;

class DataCache {
    // Единственный экземпляр класса
    private static DataCache instance;

    // Хранилище данных
    private final Map<String, String> cache;

    // Приватный конструктор
    private DataCache() {
        cache = new HashMap<>();
    }

    // Метод для получения экземпляра класса
    public static synchronized DataCache getInstance() {
        if (instance == null) {
            instance = new DataCache();
        }
        return instance;
    }

    // Метод для добавления данных в кэш
    public void putData(String key, String value) {
        cache.put(key, value);
    }

    // Метод для получения данных из кэша
    public String getData(String key) {
        return cache.get(key);
    }

    // Метод для проверки наличия данных в кэше
    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }
}

// Демонстрация работы паттерна "Одиночка"
public class DataCacheSys {
    public static void main(String[] args) {
        // Получаем экземпляр кэша
        DataCache cache = DataCache.getInstance();

        // Проверяем, есть ли данные в кэше
        String key = "user:1234";
        if (!cache.containsKey(key)) {
            System.out.println("Fetching data from database...");
            cache.putData(key, "User data for ID 1234");
        }

        // Получаем данные из кэша
        System.out.println("Data from cache: " + cache.getData(key));

        // Получаем тот же экземпляр кэша в другой части программы
        DataCache anotherCacheInstance = DataCache.getInstance();
        System.out.println("Data from another instance: " + anotherCacheInstance.getData(key));

        // Убеждаемся, что оба экземпляра идентичны
        System.out.println("Are both instances the same? " + (cache == anotherCacheInstance));
    }
}

