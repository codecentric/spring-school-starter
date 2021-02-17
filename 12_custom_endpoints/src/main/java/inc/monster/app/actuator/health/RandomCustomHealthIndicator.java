package inc.monster.app.actuator.health;

import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * http://localhost:8080/actuator/health
 */
@Slf4j
@Component
public class RandomCustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return Health.down().withDetail("ERR-001", "Random failure").build();
        }
        return Health.up().build();
    }

}
