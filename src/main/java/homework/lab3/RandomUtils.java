package homework.lab3;

import java.util.List;
import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();

    public static int generateIntBetweenBorders(int left, int right) {
        return left + random.nextInt(right - left + 1);
    }

    public static <T> T getRandomElement(List<T> list) {
        int i = RandomUtils.generateIntBetweenBorders(0, list.size() - 1);
        return list.get(i);
    }
}
