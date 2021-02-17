package inc.monster.app.user.client;

import static org.assertj.core.api.Assertions.assertThat;

import inc.monster.app.user.client.domain.User;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserClientSystemTest {
    @Autowired
    private UserClient userClient;

    @Test
    public void getUsers() {
        List<User> users = userClient.getAllUsers();
        assertThat(users).hasSize(10);
        assertThat(users.get(0)).isEqualTo(new User(1L, "Leanne Graham", "Bret", "Sincere@april.biz"));
    }

    @Test
    public void getUser() {
        User user = userClient.getUser(1L);
        assertThat(user).isEqualTo(new User(1L, "Leanne Graham", "Bret", "Sincere@april.biz"));
    }
}
