package real_spring.db_exception;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);

        DbController controller = context.getBean(DbController.class);
        controller.processDbService();
    }
}
