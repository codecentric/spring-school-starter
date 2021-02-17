package inc.monster.app.user.service;

import inc.monster.app.user.domain.User;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final UsersJsonLoader loader;
    private Map<Long, User> users;

    @Autowired
    public UserService(UsersJsonLoader loader) {
        this.loader = loader;
    }

    @PostConstruct
    public void loadUsers() {
        users = loader.load().stream().collect(Collectors.toMap(User::getId, u -> u));
    }

    public List<User> getAllUsers() {
        return users.values().stream()
                .sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toList());
    }

    public Optional<User> getUser(Long id) {
        return Optional.ofNullable(users.get(id));
    }
}
