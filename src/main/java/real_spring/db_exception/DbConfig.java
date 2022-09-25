package real_spring.db_exception;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dbexception.properties")
@ComponentScan(basePackages = "real_spring.db_exception")
@EnableAspectJAutoProxy
public class DbConfig {
}
