package inc.monster.app.user.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import inc.monster.app.user.domain.User;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

public class UsersJsonLoaderTest {

    private ObjectMapper mapper = new ObjectMapper();

    private UsersJsonLoader loader = new UsersJsonLoader(mapper);

    @Test
    public void load() {
        final List<User> users = loader.load();

        MatcherAssert.assertThat(users, Matchers.hasSize(10));
    }
}
