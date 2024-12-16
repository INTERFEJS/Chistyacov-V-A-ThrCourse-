// 5 ВАРИАНТ. Система управления видеопотоком с использованием паттерна "Мост"
package TheBridgePattern;

// Интерфейс для реализации устройств
interface Device {
    void playVideo(String video);
}

// Конкретные устройства
class TV implements Device {
    @Override
    public void playVideo(String video) {
        System.out.println("Playing video on TV: " + video);
    }
}

class Monitor implements Device {
    @Override
    public void playVideo(String video) {
        System.out.println("Playing video on Monitor: " + video);
    }
}

class Projector implements Device {
    @Override
    public void playVideo(String video) {
        System.out.println("Playing video on Projector: " + video);
    }
}

// Абстракция видеопотока
abstract class VideoStream {
    protected Device device;

    public VideoStream(Device device) {
        this.device = device;
    }

    public abstract void stream(String video);
}

// Конкретные виды видеопотоков
class LiveStream extends VideoStream {
    public LiveStream(Device device) {
        super(device);
    }

    @Override
    public void stream(String video) {
        System.out.println("Starting live stream...");
        device.playVideo(video);
    }
}

class RecordedStream extends VideoStream {
    public RecordedStream(Device device) {
        super(device);
    }

    @Override
    public void stream(String video) {
        System.out.println("Playing recorded video...");
        device.playVideo(video);
    }
}

// Демонстрация работы паттерна "Мост"
public class VideoStreamManagement {
    public static void main(String[] args) {
        // Создание устройств
        Device tv = new TV();
        Device monitor = new Monitor();
        Device projector = new Projector();

        // Создание и использование видеопотоков с разными устройствами
        VideoStream liveOnTV = new LiveStream(tv);
        liveOnTV.stream("Live Football Match");

        VideoStream recordedOnMonitor = new RecordedStream(monitor);
        recordedOnMonitor.stream("Documentary Film");

        VideoStream liveOnProjector = new LiveStream(projector);
        liveOnProjector.stream("Corporate Presentation");
    }
}
