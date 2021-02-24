package inc.monster.app.user.service;

import inc.monster.app.repository.entities.UserEntity;
import inc.monster.app.repository.entities.UserRepository;
import inc.monster.app.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return mapUserEntityToUser(userEntities);
    }

    public User getUser(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.map(this::mapUserEntityToUser).orElse(null);
    }

    public User createUser(User user) {
        UserEntity userEntity = mapUserToUserEntity(user);
        UserEntity savedEntity = userRepository.save(userEntity);
        return mapUserEntityToUser(savedEntity);
    }

    // Mapper
    private UserEntity mapUserToUserEntity(User user) {
        return UserEntity.builder()
                .email(user.getEmail())
                .name(user.getName())
                .username(user.getUsername())
                .build();
    }

    private List<User> mapUserEntityToUser(List<UserEntity> userEntities) {
        return userEntities.stream().map(this::mapUserEntityToUser
        ).collect(Collectors.toList());
    }

    private User mapUserEntityToUser(UserEntity userEntity) {
        return User.builder().username(userEntity
                .getUsername())
                .email(userEntity.getEmail())
                .id(userEntity.getId())
                .name(userEntity.getName())
                .build();
    }
}
