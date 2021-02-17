package inc.monster.app.user.service;

import com.google.common.collect.ImmutableList;
import inc.monster.app.user.domain.User;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersService {

    private final Map<Long, User> users;

    @Autowired
    public UsersService(UsersJsonLoader loader) {
        this.users = loader.load().stream().collect(Collectors.toMap(User::getId, u -> u));
    }

    public List<User> getAllUsers() {
        return ImmutableList.copyOf(users.values());
    }

    public Optional<User> getUser(final Long id) {
        return Optional.ofNullable(users.get(id));
    }

    public void saveOrUpdateUser(final User user) {
        users.put(user.getId(), user);
    }

    public void deleteUser(final Long id) {
        users.remove(id);
    }
}
