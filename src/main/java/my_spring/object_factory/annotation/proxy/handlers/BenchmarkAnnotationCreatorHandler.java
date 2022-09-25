package my_spring.object_factory.annotation.proxy.handlers;

import lombok.SneakyThrows;
import my_spring.object_factory.annotation.proxy.Benchmark;
import my_spring.object_factory.annotation.proxy.creator.ProxyCreator;
import my_spring.object_factory.annotation.proxy.creator.ProxyHandler;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BenchmarkAnnotationCreatorHandler implements ProxyAnnotationCreatorHandler {
    private final ProxyCreator proxyCreator = new ProxyCreator();

    @Override
    public <T> T create(Class<T> type, T obj) {
        return proxyCreator.createProxy(type, obj, Benchmark.class, this::handleBenchmark);
    }

    @SneakyThrows
    private <T> T handleBenchmark(T obj, Method method, Object[] args) {
        System.out.println("BENCHMARK STARTED FOR METHOD " + method.getName());
        long start = System.nanoTime();
        Object retVal = method.invoke(obj, args);
        long end = System.nanoTime();
        System.out.println(end - start);
        System.out.println("BENCHMARK ENDED FOR METHOD " + method.getName());

        return (T) retVal;
    }
}
