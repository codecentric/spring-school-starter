package inc.monster.app.user.controller;

import inc.monster.app.user.domain.User;
import inc.monster.app.user.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable final Long id) {
        return userService.getUser(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // add @RequestMapping with path and HTTP method
    public ResponseEntity<Void> postUser(@RequestBody User user) {
        return null;
    }

    // add @RequestMapping with path and HTTP method
    public ResponseEntity<Void> deleteUser(@PathVariable final Long id) {
        return null;
    }

    // add @RequestMapping with path and HTTP method
    public ResponseEntity<User> putUser(@PathVariable("id") long id, @RequestBody User user) {
        // we do not want to implement 'update' user operation!
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
