package inc.monster.app.actuator.custom;

import java.util.LinkedList;
import java.util.List;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

/**
 * http://localhost:8080/actuator/helloCustomEndpoint
 */
@Component
@Endpoint(id="helloCustomEndpoint")
public class CustomEndpoint {

    @ReadOperation
    public List<String> invoke() {
        final List<String> list = new LinkedList<>();
        list.add("This");
        list.add("is my first");
        list.add("Custom Endpoint");
        return list;
    }
}
