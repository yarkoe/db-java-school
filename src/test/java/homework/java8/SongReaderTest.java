package homework.java8;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SongReaderTest {
    @Test
    void testSongWordsCount() {
        long wordsNumber = SongReader.countWords(Path.of("D:/edu/DB Java School/db-java-school/data/song.txt"));
        System.out.println(wordsNumber);
    }
}