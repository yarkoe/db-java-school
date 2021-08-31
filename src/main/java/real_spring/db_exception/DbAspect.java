package real_spring.db_exception;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class DbAspect {
    @Value("#{'${mails}'.split(',')}")
    private List<String> mails;

    @SneakyThrows
    @Around("execution(* real_spring.db_exception..*.process*(..))")
    public Object handleDbException(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (DbException dbException) {
            mails.forEach(mail -> System.out.println("Sending to mail: " + mail));

            throw dbException;
        }
    }
}
