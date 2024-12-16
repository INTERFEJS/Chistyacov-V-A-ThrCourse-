// 5 ВАРИАНТ. Система управления настройками игры с использованием паттерна "Снимок".
package TheSnapshotPattern;

import java.util.*;

// Класс, представляющий настройки игры
class GameSettings {
    private int soundLevel;
    private int brightness;
    private String difficulty;

    public GameSettings(int soundLevel, int brightness, String difficulty) {
        this.soundLevel = soundLevel;
        this.brightness = brightness;
        this.difficulty = difficulty;
    }

    public int getSoundLevel() {
        return soundLevel;
    }

    public void setSoundLevel(int soundLevel) {
        this.soundLevel = soundLevel;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    // Создание снимка текущих настроек
    public SettingsMemento saveSettings() {
        return new SettingsMemento(soundLevel, brightness, difficulty);
    }

    // Восстановление настроек из снимка
    public void restoreSettings(SettingsMemento memento) {
        this.soundLevel = memento.getSoundLevel();
        this.brightness = memento.getBrightness();
        this.difficulty = memento.getDifficulty();
    }

    @Override
    public String toString() {
        return "GameSettings{" +
                "soundLevel=" + soundLevel +
                ", brightness=" + brightness +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }

    // Снимок настроек
    static class SettingsMemento {
        private final int soundLevel;
        private final int brightness;
        private final String difficulty;

        public SettingsMemento(int soundLevel, int brightness, String difficulty) {
            this.soundLevel = soundLevel;
            this.brightness = brightness;
            this.difficulty = difficulty;
        }

        public int getSoundLevel() {
            return soundLevel;
        }

        public int getBrightness() {
            return brightness;
        }

        public String getDifficulty() {
            return difficulty;
        }
    }
}

// Класс для управления снимками
class SettingsManager {
    private final Stack<GameSettings.SettingsMemento> history = new Stack<>();

    public void save(GameSettings settings) {
        history.push(settings.saveSettings());
    }

    public void undo(GameSettings settings) {
        if (!history.isEmpty()) {
            settings.restoreSettings(history.pop());
        } else {
            System.out.println("No previous settings to restore!");
        }
    }
}

// Демонстрация работы паттерна "Снимок"
public class SettingsManagementSys {
    public static void main(String[] args) {
        GameSettings settings = new GameSettings(50, 70, "Normal");
        SettingsManager manager = new SettingsManager();

        System.out.println("Initial Settings: " + settings);

        // Сохраняем текущие настройки
        manager.save(settings);

        // Изменяем настройки
        settings.setSoundLevel(30);
        settings.setBrightness(40);
        settings.setDifficulty("Hard");
        System.out.println("Modified Settings: " + settings);

        // Сохраняем измененные настройки
        manager.save(settings);

        // Ещё раз изменяем настройки
        settings.setSoundLevel(10);
        settings.setBrightness(20);
        settings.setDifficulty("Extreme");
        System.out.println("Further Modified Settings: " + settings);

        // Восстанавливаем последние сохранённые настройки
        manager.undo(settings);
        System.out.println("Restored Settings: " + settings);

        // Восстанавливаем изначальные настройки
        manager.undo(settings);
        System.out.println("Restored Initial Settings: " + settings);
    }
}

