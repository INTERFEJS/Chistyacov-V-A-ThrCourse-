// 5 ВАРИАНТ. Управление домашними животными с использованием фабричного метода

package FactoryMethod;

// Интерфейс для всех домашних животных
interface Pet {
    void makeSound();
}

// Конкретные классы домашних животных
class Dog implements Pet {
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

class Cat implements Pet {
    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }
}

class Parrot implements Pet {
    @Override
    public void makeSound() {
        System.out.println("Squawk! Squawk!");
    }
}

// Фабрика для создания домашних животных
abstract class PetFactory {
    public abstract Pet createPet();
}

// Конкретные фабрики для каждого типа животного
class DogFactory extends PetFactory {
    @Override
    public Pet createPet() {
        return new Dog();
    }
}

class CatFactory extends PetFactory {
    @Override
    public Pet createPet() {
        return new Cat();
    }
}

class ParrotFactory extends PetFactory {
    @Override
    public Pet createPet() {
        return new Parrot();
    }
}

// Класс для демонстрации работы
public class PetsManagement {
    public static void main(String[] args) {
        // Создание фабрик
        PetFactory dogFactory = new DogFactory();
        PetFactory catFactory = new CatFactory();
        PetFactory parrotFactory = new ParrotFactory();

        // Создание питомцев через фабрики
        Pet dog = dogFactory.createPet();
        Pet cat = catFactory.createPet();
        Pet parrot = parrotFactory.createPet();

        // Вызов методов питомцев
        dog.makeSound();
        cat.makeSound();
        parrot.makeSound();
    }
}
