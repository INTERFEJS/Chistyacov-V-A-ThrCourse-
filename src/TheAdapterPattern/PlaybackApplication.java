// 5 ВАРИАНТ. Приложение для воспроизведения аудио и видео файлов разных форматов с использованием "Адаптера".
package TheAdapterPattern;

// Интерфейс медиаплеера
interface MediaPlayer {
    void play(String fileName);
}

// Реализация для воспроизведения аудио
class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing audio file: " + fileName);
    }
}

// Интерфейс для сторонних видеоплееров
interface VideoPlayer {
    void playVideo(String fileName);
}

// Сторонние реализации видеоплееров
class MP4Player implements VideoPlayer {
    @Override
    public void playVideo(String fileName) {
        System.out.println("Playing MP4 video file: " + fileName);
    }
}

class MKVPlayer implements VideoPlayer {
    @Override
    public void playVideo(String fileName) {
        System.out.println("Playing MKV video file: " + fileName);
    }
}

// Адаптер для видеоплееров, реализующий интерфейс MediaPlayer
class VideoPlayerAdapter implements MediaPlayer {
    private VideoPlayer videoPlayer;

    public VideoPlayerAdapter(VideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    @Override
    public void play(String fileName) {
        videoPlayer.playVideo(fileName);
    }
}

// Пример использования
public class PlaybackApplication {
    public static void main(String[] args) {
        // Создание аудиоплеера
        MediaPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("song.mp3");

        // Использование адаптера для видеоплееров
        MediaPlayer mp4Adapter = new VideoPlayerAdapter(new MP4Player());
        mp4Adapter.play("movie.mp4");

        MediaPlayer mkvAdapter = new VideoPlayerAdapter(new MKVPlayer());
        mkvAdapter.play("video.mkv");
    }
}