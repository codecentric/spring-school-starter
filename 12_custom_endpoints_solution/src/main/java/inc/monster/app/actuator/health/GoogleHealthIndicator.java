package inc.monster.app.actuator.health;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * http://localhost:8080/actuator/health
 */
@Slf4j
@Component("google")
public class GoogleHealthIndicator implements HealthIndicator {


    @Override
    public Health health() {

        final String url = "https://www.google.de";
        try {

            final URLConnection connection = new URL(url).openConnection();

            connection.connect();

            log.info("Service " + url + " available, yeah!");

        } catch (final MalformedURLException e) {
            log.error("Bad URL: " + url, e);
            return Health.down(e).withDetail("Bad URL: " + url, e.getMessage()).build();
        } catch (final IOException e) {
            log.error("Service " + url + " unavailable, oh no!", e);
            return Health.down(e).withDetail("Service " + url + " unavailable, oh no!", e.getMessage()).build();
        }
        return Health.up().withDetail(url, "up").build();
    }

}
