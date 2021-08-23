package homework.java8;

import java.util.List;
import java.util.function.Consumer;

public class ListUtils {
    public static <T> void forEachWithDelay(List<T> list, int delay, Consumer<T> runner) {
        for (T item : list) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            runner.accept(item);
        }
    }
}
