package real_spring.never_use_switch;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "real_spring.never_use_switch")
public class MessageConfig {
    @Bean
    public Faker dataFaker() {
        return new Faker();
    }
}
