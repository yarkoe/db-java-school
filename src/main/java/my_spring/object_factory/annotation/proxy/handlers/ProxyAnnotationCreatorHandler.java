package my_spring.object_factory.annotation.proxy.handlers;

public interface ProxyAnnotationCreatorHandler {
    <T> T create(Class<T> type, T obj);
}
