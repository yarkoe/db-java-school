package my_spring.object_factory.annotation;

import lombok.SneakyThrows;
import my_spring.object_factory.ObjectFactory;
import my_spring.object_factory.annotation.AnnotationHandler;
import my_spring.object_factory.annotation.Inject;

import java.lang.reflect.Field;

public class InjectAnnotationHandler implements AnnotationHandler {
    @SneakyThrows
    @Override
    public void handle(Object declaringObject, Field field) {
        if (field.getAnnotation(Inject.class) == null) {
            throw new IllegalArgumentException();
        }

        Object o = ObjectFactory.getInstance().createObject(field.getType());
        field.setAccessible(true);
        field.set(declaringObject, o);
    }
}
