package inc.monster.app.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class UserJsonTest {

    @Autowired
    private JacksonTester<User> json;

    private User USER = new User(1234, "admin");

    @Test
    public void testSerialize() throws Exception {
        JsonContent<User> asJson = json.write(USER);
        assertThat(asJson).hasJsonPathStringValue("@.username");
        assertThat(asJson).extractingJsonPathStringValue("@.username")
                .isEqualTo("admin");
    }

    @Test
    public void testDeserialize() throws Exception {
        String content = "{\"id\":\"1234\",\"username\":\"admin\"}";
        assertThat(json.parse(content))
                .isEqualTo(new User(1234, "admin"));
        assertThat(json.parseObject(content).getUsername()).isEqualTo("admin");
    }

}
