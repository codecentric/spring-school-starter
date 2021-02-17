package inc.monster.app.user.client;

import static java.util.Arrays.asList;

import inc.monster.app.user.client.config.UserClientProperties;
import inc.monster.app.user.client.domain.User;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class UserClient {

    private final RestTemplate restTemplate;

    private final UserClientProperties properties;

    @Autowired
    public UserClient(RestTemplateBuilder restTemplateBuilder, UserClientProperties properties) {
        restTemplate = restTemplateBuilder.build();
        this.properties = properties;
    }

    public List<User> getAllUsers() {
        URI uri = uri(null);
        try {
            ResponseEntity<User[]> response = restTemplate.getForEntity(uri, User[].class);
            return asList(response.getBody());
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all users using " + uri, e);
        }
    }

    public User getUser(long id) {
        URI uri = uri(id);
        try {
            ResponseEntity<User> response = restTemplate.getForEntity(uri, User.class);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get single user using " + uri, e);
        }
    }

    private URI uri(Long id) {
        UriComponentsBuilder builder =
                UriComponentsBuilder.newInstance()
                        .scheme(properties.getScheme())
                        .host(properties.getHost())
                        .port(properties.getPort())
                        .pathSegment(properties.getPath());

        Optional.ofNullable(id).ifPresent(theId -> builder.pathSegment(theId.toString()));

        return builder.build().toUri();
    }
}
