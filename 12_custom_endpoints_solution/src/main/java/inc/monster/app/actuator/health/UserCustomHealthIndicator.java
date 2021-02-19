package inc.monster.app.actuator.health;

import inc.monster.app.user.domain.User;
import inc.monster.app.user.service.UsersService;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * http://localhost:8080/actuator/health
 */
@Slf4j
@Component
public class UserCustomHealthIndicator implements HealthIndicator {

    private final UsersService usersService;

    @Autowired
    public UserCustomHealthIndicator(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public Health health() {
        Health.Builder health = new Health.Builder();

        Optional<User> user = usersService.getUser(10L);
        if (user.isPresent()) {
            health.up();
        } else {
            log.error("user with id 10 not found!");
            health.down();
        }

        return health.build();
    }
}
