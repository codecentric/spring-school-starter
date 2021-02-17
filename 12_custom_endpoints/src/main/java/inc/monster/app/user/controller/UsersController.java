package inc.monster.app.user.controller;

import inc.monster.app.actuator.metrics.MyServiceWithMetrics;
import inc.monster.app.user.domain.User;
import inc.monster.app.user.service.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    private final UsersService usersService;

    private final MyServiceWithMetrics myServiceWithMetrics;

    @Autowired
    public UsersController(UsersService usersService,
                           MyServiceWithMetrics myServiceWithMetrics) {
        this.usersService = usersService;
        this.myServiceWithMetrics = myServiceWithMetrics;
    }

    @GetMapping
    public List<User> getUsers() {
        myServiceWithMetrics.exampleMethod();
        return usersService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable final Long id) {
        return usersService.getUser(id).get();
    }

    @PostMapping
    public ResponseEntity<Void> postUser(@RequestBody User user) {
        usersService.saveOrUpdateUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable final Long id) {
        usersService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> put(@PathVariable("id") long id, @RequestBody User user) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
