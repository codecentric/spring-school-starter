package inc.monster.app.actuator.info;

import com.google.common.collect.ImmutableMap;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * http://localhost:8080/actuator/info
 */
@Component
public class CustomInfoContributor implements InfoContributor {

    @Override
    public void contribute(Builder builder) {
        builder.withDetail("example", ImmutableMap.of("key", "value"));
    }
}
