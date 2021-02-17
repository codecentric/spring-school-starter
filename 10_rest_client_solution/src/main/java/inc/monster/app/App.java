package inc.monster.app;

import inc.monster.app.hello.client.HelloClient;
import inc.monster.app.hello.client.domain.Hello;
import inc.monster.app.user.client.UserClient;
import inc.monster.app.user.client.domain.User;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

        HelloClient helloClient = context.getBean(HelloClient.class);
        Hello hello = helloClient.getHello();
        System.out.println("hello = " + hello);

        UserClient userClient = context.getBean(UserClient.class);
        List<User> allUsers = userClient.getAllUsers();
        System.out.println("allUsers = " + allUsers);
        User firstUser = userClient.getUser(allUsers.get(0).getId());
        System.out.println("firstUser = " + firstUser);
    }
}
