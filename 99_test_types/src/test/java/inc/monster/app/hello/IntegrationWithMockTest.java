package inc.monster.app.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationWithMockTest {

    @MockBean
    private UserRepo userRepo;

    @Autowired
    private UserService service;

    @Test
    public void test() throws Exception {
        when(userRepo.count(false)).thenReturn(-1);

        assertThat(service.countActiveUsers()).isEqualTo(-1);
    }
}
