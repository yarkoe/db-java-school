package real_spring.db_exception;

public class DbException extends RuntimeException {
    public DbException(String message) {
        super(message);
    }
}
