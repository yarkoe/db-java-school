package my_spring.object_factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

import my_spring.object_factory.annotation.field.FieldAnnotationsProcessor;
import my_spring.object_factory.annotation.field.FieldAnnotationsProcessorImpl;
import my_spring.object_factory.annotation.proxy.ProxyAnnotationsCreator;
import my_spring.object_factory.annotation.proxy.ProxyAnnotationsCreatorImpl;
import my_spring.object_factory.configuration.ObjectFactoryConfiguration;
import my_spring.object_factory.configuration.ObjectFactoryConfigurationImpl;

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
    private FieldAnnotationsProcessor fieldAnnotationsProcessor = new FieldAnnotationsProcessorImpl();
    @Setter
    private ProxyAnnotationsCreator proxyAnnotationsProcessor = new ProxyAnnotationsCreatorImpl();

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException();
        }

        type = resolveImple(type);
        T declaredObject = type.getDeclaredConstructor().newInstance();
        fieldAnnotationsProcessor.process(declaredObject);
        processInit(declaredObject);
        declaredObject = proxyAnnotationsProcessor.createProxy(declaredObject);

        return declaredObject;
    }

    private <T> Class<T> resolveImple(Class<T> type) {
        if (type.isInterface()) {
            type = objectFactoryConfiguration.getImplementation(type);
        }
        return type;
    }

    @SneakyThrows
    private <T> void processInit(T declaredObject) {
        for (Method method : declaredObject.getClass().getDeclaredMethods()) {
            if (method.getName().startsWith("init")) {
                method.invoke(declaredObject);
            }
        }
    }
}
