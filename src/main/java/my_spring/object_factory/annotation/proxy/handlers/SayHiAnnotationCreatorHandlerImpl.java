package my_spring.object_factory.annotation.proxy.handlers;

import lombok.SneakyThrows;
import my_spring.object_factory.annotation.proxy.SayHi;
import my_spring.object_factory.annotation.proxy.creator.ProxyCreator;

import java.lang.reflect.Method;
import java.util.Set;

public class SayHiAnnotationCreatorHandlerImpl implements ProxyAnnotationCreatorHandler {
    private final ProxyCreator proxyCreator = new ProxyCreator();

    @Override
    public <T> T create(Class<T> type, T obj) {
        return proxyCreator.createProxy(type, obj, SayHi.class, this::handleSayHi);
    }

    @SneakyThrows
    private <T> T handleSayHi(T obj, Method method, Object[] args) {
        System.out.println("SAY HI");
        Object retVal = method.invoke(obj, args);
        System.out.println("SAY GOODBYE");

        return (T) retVal;

    }
}
