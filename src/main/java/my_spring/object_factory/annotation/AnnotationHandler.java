package my_spring.object_factory.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public interface AnnotationHandler {
    void handle(Object declaringObject, Field field);
}
