package inc.monster.app.hello.client;

import static org.assertj.core.api.Assertions.assertThat;

import inc.monster.app.hello.client.domain.Hello;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloClientSystemTest {

    @Autowired
    private HelloClient client;

    @Test
    @SneakyThrows
    public void getHello() {
        Hello hello = client.getHello();

        assertThat(hello).isEqualTo(new Hello("Hello World!"));
    }
}
