package my_spring.object_factory.annotation.proxy.handlers;

import my_spring.object_factory.annotation.proxy.Benchmark;

import java.lang.reflect.Proxy;

public class BenchmarkAnnotationCreatorHandler implements ProxyAnnotationCreatorHandler {
    @Override
    public <T> T create(T o) {
        Class<T> type = (Class<T>) o.getClass();

        if (type.isAnnotationPresent(Benchmark.class)) {
            return (T) Proxy.newProxyInstance(type.getClassLoader(),
                    type.getInterfaces(),
                    (proxy, method, args) -> {
                        System.out.println("BENCHMARK STARTED FOR METHOD " + method.getName());
                        long start = System.nanoTime();
                        Object retVal = method.invoke(o, args);
                        long end = System.nanoTime();
                        System.out.println(end - start);
                        System.out.println("BENCHMARK ENDED FOR METHOD " + method.getName());

                        return retVal;
                    }
            );
        }

        return o;
    }
}
