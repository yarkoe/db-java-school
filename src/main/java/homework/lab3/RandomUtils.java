package homework.lab3;

import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();

    public static int generateIntBetweenBorders(int left, int right) {
        return left + random.nextInt(right + 1);
    }
}
