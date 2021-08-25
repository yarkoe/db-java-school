package my_spring.object_factory;

import lombok.SneakyThrows;
import my_spring.object_factory.annotation.AnnotationsProcessor;
import my_spring.object_factory.annotation.AnnotationsProcessorImpl;
import my_spring.object_factory.configuration.ObjectFactoryConfiguration;
import my_spring.object_factory.configuration.ObjectFactoryConfigurationImpl;

import java.lang.reflect.Field;

public class ObjectFactory {
    private final static ObjectFactory instance = new ObjectFactory();

    public static ObjectFactory getInstance() {
        return instance;
    }

    private final ObjectFactoryConfiguration objectFactoryConfiguration = new ObjectFactoryConfigurationImpl();
    private final AnnotationsProcessor annotationsProcessor = new AnnotationsProcessorImpl();

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
            type = objectFactoryConfiguration.getImplementation(type);
        }

        T declaredObject = type.getDeclaredConstructor().newInstance();

        for (Field field : type.getDeclaredFields()) {
            annotationsProcessor.processField(declaredObject, field);
        }

        return declaredObject;
    }
}
