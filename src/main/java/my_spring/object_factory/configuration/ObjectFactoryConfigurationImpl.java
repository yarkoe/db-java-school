package my_spring.object_factory.configuration;

import my_spring.robot.*;

import java.util.HashMap;
import java.util.Map;

public class ObjectFactoryConfigurationImpl implements ObjectFactoryConfiguration {
    private final Map<Class<?>, Class<?>> interface2Implementation  = new HashMap<>();

    public ObjectFactoryConfigurationImpl() {
        interface2Implementation.put(Cleaner.class, CleanerImpl.class);
        interface2Implementation.put(Speaker.class, SpeakerWithTimeDecorator.class);
        interface2Implementation.put(IRobot.class, IRobot.class);
    }

    @Override
    public <T> Class<T> getImplementation(Class<T> type) {
        return (Class<T>) interface2Implementation.get(type);
    }
}
