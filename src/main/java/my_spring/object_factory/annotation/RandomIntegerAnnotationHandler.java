package my_spring.object_factory.annotation;

import homework.lab3.RandomUtils;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class RandomIntegerAnnotationHandler implements AnnotationHandler {
    @SneakyThrows
    @Override
    public void handle(Object declaringObject, Field field) {
        RandomInteger randomIntegerAnnotation = field.getAnnotation(RandomInteger.class);
        if (randomIntegerAnnotation == null) {
            throw new IllegalArgumentException();
        }

        int min = randomIntegerAnnotation.min();
        int max = randomIntegerAnnotation.max();
        field.setAccessible(true);
        field.set(declaringObject, RandomUtils.generateIntBetweenBorders(min, max));
    }
}
