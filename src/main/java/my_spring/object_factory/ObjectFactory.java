package my_spring.object_factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import my_spring.object_factory.annotation.AnnotationsProcessor;
import my_spring.object_factory.annotation.AnnotationsProcessorImpl;
import my_spring.object_factory.configuration.ObjectFactoryConfiguration;
import my_spring.object_factory.configuration.ObjectFactoryConfigurationImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectFactory {
    private final static ObjectFactory instance = new ObjectFactory();

    public static ObjectFactory getInstance() {
        return instance;
    }

    @Setter
    private ObjectFactoryConfiguration objectFactoryConfiguration = new ObjectFactoryConfigurationImpl();
    @Setter
    private AnnotationsProcessor annotationsProcessor = new AnnotationsProcessorImpl();

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
            type = objectFactoryConfiguration.getImplementation(type);
        }

        T declaredObject = type.getDeclaredConstructor().newInstance();

        for (Field field : type.getDeclaredFields()) {
            annotationsProcessor.processField(declaredObject, field);
        }

        for (Method method : type.getDeclaredMethods()) {
            annotationsProcessor.processMethod(declaredObject, method);
        }

        return declaredObject;
    }
}
