package inc.monster.app.hello.client;

import inc.monster.app.hello.client.config.HelloClientProperties;
import inc.monster.app.hello.client.domain.Hello;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class HelloClient {

    private final RestTemplate restTemplate;
    private final HelloClientProperties properties;

    public HelloClient(RestTemplateBuilder restTemplateBuilder, HelloClientProperties properties) {
        restTemplate = restTemplateBuilder.build();
        this.properties = properties;
    }

    public Hello getHello() {
        String uri = UriComponentsBuilder.newInstance()
                .scheme(properties.getScheme())
                .host(properties.getHost())
                .port(properties.getPort())
                .pathSegment(properties.getPath())
                .toUriString();
        try {
            ResponseEntity<Hello> response = restTemplate.getForEntity(uri, Hello.class);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Failed to access hello service using " + uri, e);
        }
    }
}
