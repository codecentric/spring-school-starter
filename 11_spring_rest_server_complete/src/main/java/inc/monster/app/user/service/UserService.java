package inc.monster.app.user.service;

import inc.monster.app.user.domain.User;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final UsersJsonLoader loader;
    private Map<Long, User> users = new HashMap<>();

    @Autowired
    public UserService(UsersJsonLoader loader) {
        this.loader = loader;
    }

    public List<User> getAllUsers() {
        loadUsers();
        return users.values().stream()
                .sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toList());
    }

    public Optional<User> getUser(final Long id) {
        loadUsers();
        return Optional.ofNullable(users.get(id));
    }

    public void saveUser(final User user) {
        loadUsers();

        // save user ???
    }

    public void deleteUser(final Long id) {
        loadUsers();

        // delete user ???
    }

    void loadUsers() {
        if (users.isEmpty()) {
            users = loader.load().stream().collect(Collectors.toMap(User::getId, u -> u));
        }
    }
}
