package inc.monster.app.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import inc.monster.app.user.domain.User;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UsersJsonLoader loader;

    @InjectMocks
    private UserService service;

    private User userOne = new User(111L);
    private User userTwo = new User(222L);

    @Before
    public void setup() {
        Mockito.when(loader.load()).thenReturn(Arrays.asList(userOne, userTwo));
        service.loadUsers();
    }

    @Test
    public void getAllUsers() {
        List<User> users = service.getAllUsers();

        assertThat(users).contains(userOne, userTwo);
        verify(loader).load();
    }

    @Test
    public void getUser() {
        assertThat(service.getUser(111L)).isEqualTo(Optional.of(userOne));
        assertThat(service.getUser(222L)).isEqualTo(Optional.of(userTwo));
        assertThat(service.getUser(112L)).isEqualTo(Optional.empty());
        verify(loader).load();
    }

}
