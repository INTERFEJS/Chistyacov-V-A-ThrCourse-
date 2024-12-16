// 5 ВАРИАНТ. Система управления настройками приложения с использованием паттерна "Прототип".
package ThePrototypePattern;


// Интерфейс для прототипа
interface Prototype {
    Prototype clone();
}

// Класс для управления настройками приложения
class AppSettings implements Prototype {
    private String theme;
    private int fontSize;
    private boolean notificationsEnabled;

    public AppSettings(String theme, int fontSize, boolean notificationsEnabled) {
        this.theme = theme;
        this.fontSize = fontSize;
        this.notificationsEnabled = notificationsEnabled;
    }

    // Переопределение метода клонирования
    @Override
    public Prototype clone() {
        return new AppSettings(this.theme, this.fontSize, this.notificationsEnabled);
    }

    public void displaySettings() {
        System.out.println("Theme: " + theme);
        System.out.println("Font Size: " + fontSize);
        System.out.println("Notifications Enabled: " + notificationsEnabled);
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public void setNotificationsEnabled(boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }
}

// Главный класс для демонстрации паттерна "Прототип"
public class ApplicationSetupSys {
    public static void main(String[] args) {
        // Создание исходных настроек приложения
        AppSettings defaultSettings = new AppSettings("Light", 12, true);
        System.out.println("Исходные настройки приложения:");
        defaultSettings.displaySettings();

        // Клонирование настроек для пользователя 1
        AppSettings user1Settings = (AppSettings) defaultSettings.clone();
        user1Settings.setTheme("Dark");
        user1Settings.setFontSize(14);

        System.out.println("\nНастройки пользователя 1:");
        user1Settings.displaySettings();

        // Клонирование настроек для пользователя 2
        AppSettings user2Settings = (AppSettings) defaultSettings.clone();
        user2Settings.setNotificationsEnabled(false);

        System.out.println("\nНастройки пользователя 2:");
        user2Settings.displaySettings();
    }
}