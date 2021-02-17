package inc.monster.app.actuator.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * http://localhost:8080/actuator/metrics
 */
@Service
public class MyServiceWithMetrics {

    private final MeterRegistry meterRegistry;

    @Autowired
    public MyServiceWithMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    public void exampleMethod() {
    	meterRegistry.counter("my.service.with.metrics.counter").increment();
    	meterRegistry.gauge("my.service.with.metrics.gauge", new Random().nextDouble());
    }
}
