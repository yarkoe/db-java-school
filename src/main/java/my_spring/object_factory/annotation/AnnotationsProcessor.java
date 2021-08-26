package my_spring.object_factory.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface AnnotationsProcessor {
    void process(Object declaredObject);
}
