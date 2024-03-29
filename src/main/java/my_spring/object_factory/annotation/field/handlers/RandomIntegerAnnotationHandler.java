package my_spring.object_factory.annotation.field.handlers;

import homework.lab3.RandomUtils;
import lombok.SneakyThrows;
import my_spring.object_factory.annotation.field.RandomInteger;

import java.lang.reflect.Field;

public class RandomIntegerAnnotationHandler implements FieldAnnotationHandler {
    @SneakyThrows
    @Override
    public void handle(Object declaredObject) {
        for (Field field : declaredObject.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(RandomInteger.class)) {
                RandomInteger randomIntegerAnnotation = field.getAnnotation(RandomInteger.class);
                int min = randomIntegerAnnotation.min();
                int max = randomIntegerAnnotation.max();
                field.setAccessible(true);
                field.set(declaredObject, RandomUtils.generateIntBetweenBorders(min, max));
            }
        }
    }
}
