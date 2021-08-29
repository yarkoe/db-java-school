package real_spring.never_use_switch;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);

        DataProducer dataProducer = context.getBean(DataProducer.class);
        Message message = dataProducer.generateMessage();

        MessageDistributor messageDistributor = context.getBean(MessageDistributor.class);
        messageDistributor.distribute(message);

        context.close();
    }
}
