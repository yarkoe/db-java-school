package real_spring.db_exception;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);

        DbController controller = context.getBean(DbController.class);
        try {
            controller.processDbService();
        } catch (DbException e) {
            System.out.println("Db exception 1");
        }

        try {
            controller.processDbService();
        } catch (DbException e) {
            System.out.println("Db exception 2");
        }
    }
}
