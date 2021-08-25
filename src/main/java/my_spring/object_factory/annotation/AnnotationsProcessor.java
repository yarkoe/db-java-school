package my_spring.object_factory.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface AnnotationsProcessor {
    void processField(Object declaringObject, Field field);
    void processMethod(Object declaringObject, Method method);
}
