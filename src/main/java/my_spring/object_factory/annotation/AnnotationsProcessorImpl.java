package my_spring.object_factory.annotation;

import lombok.SneakyThrows;
import my_spring.object_factory.annotation.handlers.AnnotationHandler;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class AnnotationsProcessorImpl implements AnnotationsProcessor {
    private final Reflections scanner = new Reflections("my_spring.object_factory.annotation.handlers");

    private final List<AnnotationHandler> annotationHandlers = new ArrayList<>();

    @SneakyThrows
    public AnnotationsProcessorImpl() {
        for (var handler : scanner.getSubTypesOf(AnnotationHandler.class) ) {
            annotationHandlers.add(handler.getDeclaredConstructor().newInstance());
        }
    }

    @Override
    public void process(Object declaredObject) {
        for (AnnotationHandler annotationHandler : annotationHandlers) {
            annotationHandler.handle(declaredObject);
        }
    }
}
