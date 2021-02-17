package inc.monster.app.hello.controller;

import inc.monster.app.hello.domain.Hello;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping
    Hello getHello() {
        return new Hello("Hello World!");
    }

    @PostMapping
    Hello getHello(@RequestBody final Hello hello) {
        return hello;
    }
}

