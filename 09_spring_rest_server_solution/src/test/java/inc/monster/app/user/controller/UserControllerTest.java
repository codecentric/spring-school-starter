package inc.monster.app.user.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import inc.monster.app.user.domain.User;
import inc.monster.app.user.service.UserService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    private User userOne = new User(111L);
    private User userTwo = new User(222L);

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private UserService usersService;

    @Test
    public void getUsers() throws Exception {
        when(usersService.getAllUsers()).thenReturn(Arrays.asList(userOne, userTwo));

        String json = mvc
                .perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        List<User> users = Arrays.asList(mapper.readValue(json, User[].class));

        assertThat(users).contains(userOne, userTwo);

        verify(usersService).getAllUsers();
    }

    @Test
    public void getUser() throws Exception {
        when(usersService.getUser(111L)).thenReturn(Optional.of(userOne));

        String json = mvc
                .perform(MockMvcRequestBuilders.get("/users/111").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        User user = mapper.readValue(json, User.class);

        assertThat(user).isEqualTo(userOne);

        verify(usersService).getUser(111L);
    }
}
