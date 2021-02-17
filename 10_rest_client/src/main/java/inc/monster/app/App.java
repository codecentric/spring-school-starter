package inc.monster.app;

import inc.monster.app.hello.client.HelloClient;
import inc.monster.app.hello.client.domain.Hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        HelloClient client = context.getBean(HelloClient.class);
        Hello hello = client.getHello();
        System.out.println("hello = " + hello);
    }
}
