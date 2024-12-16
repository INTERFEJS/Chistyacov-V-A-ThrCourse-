// 5 ВАРИАНТ. Система управления автомобилем с использованием паттерна "Фасад".
package TheFacadePattern;


// Класс для управления двигателем
class Engine {
        public void start() {
                System.out.println("Engine started.");
        }

        public void stop() {
                System.out.println("Engine stopped.");
        }
}

// Класс для управления климат-контролем
class ClimateControl {
        public void setTemperature(int temperature) {
                System.out.println("Climate control set to " + temperature + " degrees.");
        }

        public void turnOn() {
                System.out.println("Climate control turned on.");
        }

        public void turnOff() {
                System.out.println("Climate control turned off.");
        }
}

// Класс для управления музыкальной системой
class MusicSystem {
        public void playMusic(String track) {
                System.out.println("Playing music: " + track);
        }

        public void stopMusic() {
                System.out.println("Music stopped.");
        }
}

// Класс Фасад для управления автомобилем
class CarFacade {
        private Engine engine;
        private ClimateControl climateControl;
        private MusicSystem musicSystem;

        public CarFacade() {
                this.engine = new Engine();
                this.climateControl = new ClimateControl();
                this.musicSystem = new MusicSystem();
        }

        public void startCar(int temperature, String track) {
                System.out.println("Starting car...");
                engine.start();
                climateControl.turnOn();
                climateControl.setTemperature(temperature);
                musicSystem.playMusic(track);
                System.out.println("Car is ready to drive!");
        }

        public void stopCar() {
                System.out.println("Stopping car...");
                musicSystem.stopMusic();
                climateControl.turnOff();
                engine.stop();
                System.out.println("Car is turned off.");
        }
}

// Главный класс для демонстрации работы
public class CarControlSystem {
        public static void main(String[] args) {
                CarFacade car = new CarFacade();

                car.startCar(22, "Favorite Song");

                car.stopCar();
        }
}

