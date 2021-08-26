package my_spring.object_factory.annotation.field;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import my_spring.object_factory.annotation.field.handlers.FieldAnnotationHandler;
import java.util.List;

public class FieldAnnotationsProcessorImpl implements FieldAnnotationsProcessor {
    private final Reflections scanner = new Reflections("my_spring.object_factory.annotation.field.handlers");

    private final List<FieldAnnotationHandler> annotationHandlers = new ArrayList<>();

    @SneakyThrows
    public FieldAnnotationsProcessorImpl() {
        for (var handler : scanner.getSubTypesOf(FieldAnnotationHandler.class) ) {
            if (!Modifier.isAbstract(handler.getModifiers())) {
                annotationHandlers.add(handler.getDeclaredConstructor().newInstance());
            }
        }
    }

    @Override
    public void process(Object declaredObject) {
        for (FieldAnnotationHandler annotationHandler : annotationHandlers) {
            annotationHandler.handle(declaredObject);
        }
    }
}
