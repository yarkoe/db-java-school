package homework.java8;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class SongReader {
    @SneakyThrows
    public static long countWords(Path songPath) {
        return Files.lines(songPath)
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .count();
    }
}
