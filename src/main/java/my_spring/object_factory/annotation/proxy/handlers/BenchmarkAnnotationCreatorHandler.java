package my_spring.object_factory.annotation.proxy.handlers;

import my_spring.object_factory.annotation.proxy.Benchmark;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BenchmarkAnnotationCreatorHandler implements ProxyAnnotationCreatorHandler {
    @Override
    public <T> T create(T o) {
        Class<T> type = (Class<T>) o.getClass();


        Set<String> methodWithBenchmarkAnnotationNames = new HashSet<>();
        if (type.isAnnotationPresent(Benchmark.class)) {
            List<String> methodNames = Arrays.stream(type.getDeclaredMethods())
                    .map(Method::getName).collect(Collectors.toList());
            methodWithBenchmarkAnnotationNames.addAll(methodNames);
        } else {
            for (Method method : type.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Benchmark.class)) {
                    methodWithBenchmarkAnnotationNames.add(method.getName());
                }
            }
        }

        if (!methodWithBenchmarkAnnotationNames.isEmpty()) {
            return (T) Proxy.newProxyInstance(type.getClassLoader(),
                    type.getInterfaces(),
                    (proxy, method, args) -> {
                        if (methodWithBenchmarkAnnotationNames.contains(method.getName())) {
                            System.out.println("BENCHMARK STARTED FOR METHOD " + method.getName());
                            long start = System.nanoTime();
                            Object retVal = method.invoke(o, args);
                            long end = System.nanoTime();
                            System.out.println(end - start);
                            System.out.println("BENCHMARK ENDED FOR METHOD " + method.getName());

                            return retVal;
                        }
                        return method.invoke(o, args);
                    }
            );
        }

        return o;
    }
}
