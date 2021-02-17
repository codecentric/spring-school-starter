package inc.monster.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SomeComponentTest {

    @Autowired
    private SomeComponent someComponent;

    @Test
    public void test() {
        assertThat(someComponent.getFirstProperty()).isEqualTo("Hello World!");
    }
}
