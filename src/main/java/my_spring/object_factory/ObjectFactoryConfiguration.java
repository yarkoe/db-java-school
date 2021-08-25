package my_spring.object_factory;

import my_spring.robot.*;

import java.util.HashMap;
import java.util.Map;

public class ObjectFactoryConfiguration {
    private final Map<Class<?>, Class<?>> interface2Implementation  = new HashMap<>();

    public ObjectFactoryConfiguration() {
        interface2Implementation.put(Cleaner.class, CleanerImpl.class);
        interface2Implementation.put(Speaker.class, ConsoleSpeaker.class);
        interface2Implementation.put(IRobot.class, IRobot.class);
    }

    public <T> Class<T> getInstance(Class<T> type) {
        return (Class<T>) interface2Implementation.get(type);
    }
}
