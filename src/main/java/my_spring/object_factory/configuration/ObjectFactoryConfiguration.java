package my_spring.object_factory.configuration;

public interface ObjectFactoryConfiguration {
    <T> Class<T> getImplementation(Class<T> type);
}
