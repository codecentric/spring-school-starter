package inc.monster.app.user.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import inc.monster.app.user.domain.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Component
public class UsersJsonLoader {
    private final ObjectMapper mapper;

    @Autowired
    public UsersJsonLoader(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @SneakyThrows
    public List<User> load() {
        final Resource resource = new ClassPathResource("users.json");
        final InputStream inputStream = resource.getInputStream();

        final User[] users = mapper.readValue(inputStream, User[].class);

        return Arrays.asList(users);
    }
}
