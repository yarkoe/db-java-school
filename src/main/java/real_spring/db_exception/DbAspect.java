package real_spring.db_exception;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class DbAspect {
    @Value("#{'${mails}'.split(',')}")
    private List<String> mails;

    Cache<RuntimeException, Object> cache = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.SECONDS).build();

    @SneakyThrows
    @Around("execution(* real_spring.db_exception..*.*(..))")
    public Object handleDbException(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (DbException dbException) {
            if (cache.getIfPresent(dbException) == null) {
                mails.forEach(mail -> System.out.println("Sending to mail: " + mail));
                cache.put(dbException, true);
            }

            throw dbException;
        }
    }
}
