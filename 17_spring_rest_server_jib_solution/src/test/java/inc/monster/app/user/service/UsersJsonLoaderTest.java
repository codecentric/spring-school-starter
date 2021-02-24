package inc.monster.app.user.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import inc.monster.app.user.domain.User;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class UsersJsonLoaderTest {

    private ObjectMapper mapper = new ObjectMapper();

    private UsersJsonLoader loader = new UsersJsonLoader(mapper);

    @Test
    public void load() {
        List<User> users = loader.load();

        MatcherAssert.assertThat(users, Matchers.hasSize(10));
    }
}
