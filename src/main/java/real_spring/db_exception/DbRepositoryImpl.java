package real_spring.db_exception;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class DbRepositoryImpl implements DbRepository {
    @Override
    @SneakyThrows
    public void processDbException() {
        throw new DbException("Db exception");
    }
}
