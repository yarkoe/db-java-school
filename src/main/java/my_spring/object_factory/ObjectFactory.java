package my_spring.object_factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import my_spring.object_factory.annotation.field.FieldAnnotationsProcessor;
import my_spring.object_factory.annotation.field.FieldAnnotationsProcessorImpl;
import my_spring.object_factory.annotation.proxy.Benchmark;
import my_spring.object_factory.configuration.ObjectFactoryConfiguration;
import my_spring.object_factory.configuration.ObjectFactoryConfigurationImpl;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectFactory {
    private final static ObjectFactory instance = new ObjectFactory();

    public static ObjectFactory getInstance() {
        return instance;
    }

    @Setter
    private ObjectFactoryConfiguration objectFactoryConfiguration = new ObjectFactoryConfigurationImpl();
    @Setter
    private FieldAnnotationsProcessor annotationsProcessor = new FieldAnnotationsProcessorImpl();

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException();
        }

        type = resolveImple(type);
        T declaredObject = type.getDeclaredConstructor().newInstance();
        annotationsProcessor.process(declaredObject);
        processInit(declaredObject);

        if (type.isAnnotationPresent(Benchmark.class)) {
            return (T) Proxy.newProxyInstance(type.getClassLoader(),
                    type.getInterfaces(),
                    (proxy, method, args) -> {
                        System.out.println("BENCHMARK STARTED FOR METHOD " + method.getName());
                        long start = System.nanoTime();
                        Object retVal = method.invoke(declaredObject, args);
                        long end = System.nanoTime();
                        System.out.println(end - start);
                        System.out.println("BENCHMARK ENDED FOR METHOD " + method.getName());

                        return retVal;
                    }
                    );
        }

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
