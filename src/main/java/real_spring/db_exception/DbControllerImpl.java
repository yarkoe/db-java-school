package real_spring.db_exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbControllerImpl implements DbController {
    @Autowired
    private DbService dbService;

    @Override
    public void processDbService() {
        dbService.processDbRepo();
    }
}
