package my_spring.object_factory;

import homework.lab3.RandomUtils;
import lombok.SneakyThrows;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Field;

public class ObjectFactory {
    private final static ObjectFactory instance = new ObjectFactory();

    public static ObjectFactory getInstance() {
        return instance;
    }

    private final ObjectFactoryConfiguration objectFactoryConfiguration = new ObjectFactoryConfiguration();

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
            type = objectFactoryConfiguration.getInstance(type);
        }

        T t = type.getDeclaredConstructor().newInstance();

        for (Field field : type.getDeclaredFields()) {
            Inject injectAnnotation = field.getAnnotation(Inject.class);
            if (injectAnnotation != null) {
                generateInjectField(t, field);
            }

            RandomInteger randomIntegerAnnotation = field.getAnnotation(RandomInteger.class);
            if (randomIntegerAnnotation != null) {
                generateRandomIntegerField(t, randomIntegerAnnotation, field);
            }
        }

        return t;
    }

    @SneakyThrows
    private <T> void generateInjectField(T t, Field field) {
        Object o = createObject(field.getType());
        field.setAccessible(true);
        field.set(t, o);
    }

    @SneakyThrows
    private <T> void generateRandomIntegerField(T t, RandomInteger randomIntegerAnnotation, Field field) {
        int min = randomIntegerAnnotation.min();
        int max = randomIntegerAnnotation.max();
        int randomInteger = RandomUtils.generateIntBetweenBorders(min, max);
        field.setAccessible(true);
        field.set(t, randomInteger);
    }
}
