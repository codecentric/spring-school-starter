package inc.monster.app.hello.controller;

import inc.monster.app.hello.domain.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public Hello getHello() {
        return new Hello("Hello World!");
    }

    @PostMapping
    public Hello getHello(@RequestBody Hello hello) {
        return hello;
    }
}

