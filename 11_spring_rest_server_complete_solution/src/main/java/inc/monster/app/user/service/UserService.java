package inc.monster.app.user.service;

import inc.monster.app.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

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

    public void saveOrUpdateUser(final User user) {
        loadUsers();

        users.put(user.getId(), user);
    }

    public void deleteUser(final Long id) {
        loadUsers();

        users.remove(id);
    }

    void loadUsers() {
        if (users.isEmpty()) {
            users = loader.load().stream().collect(Collectors.toMap(User::getId, u -> u));
        }
    }
}
