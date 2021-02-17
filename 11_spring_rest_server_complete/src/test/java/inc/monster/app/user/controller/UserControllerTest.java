package inc.monster.app.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import inc.monster.app.user.domain.User;
import inc.monster.app.user.service.UserService;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    private User userOne = new User();
    private User userTwo = new User();
    private User userThree = new User();

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private UserService usersService;

    @Before
    public void setup() {
        userOne.setId(111L);
        userTwo.setId(222L);
        userThree.setId(333L);
    }

    @Test
    public void getUsers() throws Exception {
        Mockito.when(usersService.getAllUsers()).thenReturn(Arrays.asList(userOne, userTwo));

        final String json = this.mvc
                .perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        final List<User> users = Arrays.asList(mapper.readValue(json, User[].class));

        MatcherAssert.assertThat(users, Matchers.contains(userOne, userTwo));

        Mockito.verify(usersService).getAllUsers();
    }

    @Test
    public void getUser() throws Exception {
        Mockito.when(usersService.getUser(111L)).thenReturn(Optional.of(userOne));

        final String json = this.mvc
                .perform(MockMvcRequestBuilders.get("/users/111").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        final User user = mapper.readValue(json, User.class);

        MatcherAssert.assertThat(user, Matchers.is(userOne));

        Mockito.verify(usersService).getUser(111L);
    }
}
