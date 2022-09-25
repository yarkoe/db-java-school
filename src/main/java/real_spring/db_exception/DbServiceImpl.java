package real_spring.db_exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbServiceImpl implements DbService {
    @Autowired
    private DbRepository dbRepo;

    @Override
    public void processDbRepo() {
        dbRepo.processDbException();
    }
}
