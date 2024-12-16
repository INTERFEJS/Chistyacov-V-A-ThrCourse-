// 5 ВАРИАНТ. Система управления меню ресторана с использованием паттерна "Компоновщик".

package TheLinkerPattern;

import java.util.*;

// Компонуемый интерфейс для меню
interface MenuComponent {
    void display();
}

// Класс для представления отдельного блюда
class MenuItem implements MenuComponent {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void display() {
        System.out.println("Блюдо: " + name + ", Цена: " + price + " руб.");
    }
}

// Класс для представления категории блюд (вложенное меню)
class MenuCategory implements MenuComponent {
    private String name;
    private List<MenuComponent> menuComponents = new ArrayList<>();

    public MenuCategory(String name) {
        this.name = name;
    }

    public void add(MenuComponent component) {
        menuComponents.add(component);
    }

    public void remove(MenuComponent component) {
        menuComponents.remove(component);
    }

    @Override
    public void display() {
        System.out.println("\nКатегория: " + name);
        for (MenuComponent component : menuComponents) {
            component.display();
        }
    }
}

// Главный класс для демонстрации работы паттерна "Компоновщик"
public class RestaurantManagementSys {
    public static void main(String[] args) {
        // Создание отдельных блюд
        MenuItem pizza = new MenuItem("Пицца", 450);
        MenuItem pasta = new MenuItem("Паста", 350);
        MenuItem salad = new MenuItem("Салат Цезарь", 300);
        MenuItem coffee = new MenuItem("Кофе", 150);
        MenuItem tea = new MenuItem("Чай", 100);

        // Создание категорий меню
        MenuCategory mainDishes = new MenuCategory("Основные блюда");
        MenuCategory drinks = new MenuCategory("Напитки");
        MenuCategory allMenu = new MenuCategory("Полное меню ресторана");

        // Добавление блюд в категории
        mainDishes.add(pizza);
        mainDishes.add(pasta);
        mainDishes.add(salad);

        drinks.add(coffee);
        drinks.add(tea);

        // Компоновка категорий в общее меню
        allMenu.add(mainDishes);
        allMenu.add(drinks);

        // Отображение полного меню
        allMenu.display();
    }
}
