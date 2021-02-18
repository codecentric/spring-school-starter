package inc.monster.app.hello;

import org.springframework.stereotype.Component;

@Component
public class UserRepo {

    public int count(boolean includeDeleted) {
        return 42;
    }
}
