package my_spring.object_factory.annotation.field.handlers;

import lombok.SneakyThrows;
import my_spring.object_factory.ObjectFactory;
import my_spring.object_factory.annotation.field.InjectByType;

import java.lang.reflect.Field;

public class InjectAnnotationHandler implements FieldAnnotationHandler {
    @SneakyThrows
    @Override
    public void handle(Object declaredObject) {
        for (Field field : declaredObject.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                Object o = ObjectFactory.getInstance().createObject(field.getType());
                field.setAccessible(true);
                field.set(declaredObject, o);
            }
        }
    }
}
