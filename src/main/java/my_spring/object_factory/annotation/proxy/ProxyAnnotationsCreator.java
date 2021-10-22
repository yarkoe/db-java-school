package my_spring.object_factory.annotation.proxy;

public interface ProxyAnnotationsCreator {
    <T> T createProxy(T obj);
}
