package inc.monster.app.user.service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import inc.monster.app.user.domain.User;

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
    }

    @Test
    public void getAllUsers() {
        MatcherAssert.assertThat(service.getAllUsers(), Matchers.contains(userOne, userTwo));
        MatcherAssert.assertThat(service.getAllUsers(), Matchers.contains(userOne, userTwo));

        Mockito.verify(loader).load();
    }

    @Test
    public void getUser() {
        MatcherAssert.assertThat(service.getUser(111L), Matchers.is(Optional.of(userOne)));
        MatcherAssert.assertThat(service.getUser(222L), Matchers.is(Optional.of(userTwo)));

        Mockito.verify(loader).load();
    }

    @Test
    public void createUser() {
        final User newUser = new User(999L);

        service.saveOrUpdateUser(newUser);
        service.saveOrUpdateUser(newUser);

        MatcherAssert.assertThat(service.getAllUsers(), Matchers.hasSize(3));
        MatcherAssert.assertThat(service.getUser(999L), Matchers.is(Optional.of(newUser)));

        Mockito.verify(loader).load();
    }

    @Test
    public void updateUser() {
        MatcherAssert.assertThat(service.getUser(111L), Matchers.is(Optional.of(userOne)));

        final User userUpdate = new User(userOne.getId());
        userUpdate.setName("updated name");

        service.saveOrUpdateUser(userUpdate);

        MatcherAssert.assertThat(service.getUser(111L), Matchers.is(Optional.of(userUpdate)));

        Mockito.verify(loader).load();
    }

    @Test
    public void deleteUser() {
        service.deleteUser(111L);

        MatcherAssert.assertThat(service.getUser(111L), Matchers.is(Optional.empty()));

        MatcherAssert
                .assertThat(service.getAllUsers().stream().map(User::getId).collect(Collectors.toList()),
                        Matchers.contains(222L));
    }
}
