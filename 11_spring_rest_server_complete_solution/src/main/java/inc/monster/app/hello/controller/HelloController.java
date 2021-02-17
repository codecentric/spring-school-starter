package inc.monster.app.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import inc.monster.app.hello.domain.Hello;

@RestController
public class HelloController {

    @GetMapping("/hello")
    Hello getHello() {
        return new Hello("Hello World!");
    }

    @PostMapping
    Hello getHello(@RequestBody final Hello hello) {
        return hello;
    }
}

