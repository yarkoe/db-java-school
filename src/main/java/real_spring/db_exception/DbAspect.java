package real_spring.db_exception;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Aspect
@Component
public class DbAspect {
    @Value("#{'${mails}'.split(',')}")
    private List<String> mails;

    private final Set<RuntimeException> exceptions = new HashSet<>();

    @SneakyThrows
    @Around("execution(* real_spring.db_exception..*.*(..))")
    public Object handleDbException(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (DbException dbException) {
            if (!exceptions.contains(dbException)) {
                mails.forEach(mail -> System.out.println("Sending to mail: " + mail));
                exceptions.add(dbException);
            }

            throw dbException;
        }
    }
}
