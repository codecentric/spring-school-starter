package inc.monster.app.user.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import inc.monster.app.user.domain.User;
import java.util.List;
import org.junit.Test;

public class UsersJsonLoaderTest {
    private UsersJsonLoader loader = new UsersJsonLoader(new ObjectMapper());

    @Test
    public void load() {
        List<User> users = loader.load();

        assertThat(users).hasSize(10);
    }
}
