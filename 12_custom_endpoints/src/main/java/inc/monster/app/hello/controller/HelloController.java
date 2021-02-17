package inc.monster.app.hello.controller;

import inc.monster.app.hello.domain.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    Hello getHello() {
        return new Hello("Hello World!");
    }

}
