// 5 ВАРИАНТ. Система мониторинга здоровья с использованием паттерна "Наблюдатель".

package TheObserverPattern;

import java.util.*;

// Интерфейс наблюдателя
interface Observer {
    void update(String message);
}

// Интерфейс субъекта
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

// Реализация субъекта: система мониторинга здоровья
class HealthMonitoringSystem implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    // Метод для добавления нового результата анализа
    public void addTestResult(String result) {
        System.out.println("New test result available: " + result);
        notifyObservers("New test result: " + result);
    }
}

// Реализация наблюдателя: пациент
class Patient implements Observer {
    private final String name;

    public Patient(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Patient " + name + " received notification: " + message);
    }
}

// Демонстрация работы паттерна "Наблюдатель"
public class HealthMonitoringSys {
    public static void main(String[] args) {
        // Создание системы мониторинга здоровья
        HealthMonitoringSystem healthSystem = new HealthMonitoringSystem();

        // Создание пациентов
        Patient patient1 = new Patient("John Doe");
        Patient patient2 = new Patient("Jane Smith");

        // Подписка пациентов на уведомления
        healthSystem.addObserver(patient1);
        healthSystem.addObserver(patient2);

        // Добавление результатов анализов
        healthSystem.addTestResult("Blood test: Normal");

        // Один из пациентов отписывается
        healthSystem.removeObserver(patient1);

        // Добавление новых результатов
        healthSystem.addTestResult("X-ray: No issues detected");
    }
}
