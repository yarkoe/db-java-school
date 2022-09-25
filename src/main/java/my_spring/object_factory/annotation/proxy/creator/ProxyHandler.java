package my_spring.object_factory.annotation.proxy.creator;

import java.lang.reflect.Method;
import java.util.Set;

public interface ProxyHandler {
    <T> T handle(T obj, Method method, Object[] args);
}
