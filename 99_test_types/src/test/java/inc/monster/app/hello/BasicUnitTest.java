package inc.monster.app.hello;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BasicUnitTest {

    @Mock
    private UserRepo repo;

    @InjectMocks
    private UserService service;

    @Test
    public void test() throws Exception {
        when(repo.count(false)).thenReturn(-1);

        assertThat(service.countActiveUsers()).isEqualTo(-1);
    }
}
