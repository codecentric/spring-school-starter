package inc.monster.app.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import inc.monster.app.user.domain.User;
import inc.monster.app.user.service.UserService;
import lombok.SneakyThrows;
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

    @MockBean
    private UserService userService;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        userOne.setId(111L);
        userTwo.setId(222L);
        userThree.setId(333L);
    }

    @Test
    public void getUsers() throws Exception {
        Mockito.when(userService.getAllUsers()).thenReturn(Arrays.asList(userOne, userTwo));

        final String json = this.mvc
                .perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        final List<User> users = Arrays.asList(mapper.readValue(json, User[].class));

        MatcherAssert.assertThat(users, Matchers.contains(userOne, userTwo));

        Mockito.verify(userService).getAllUsers();
    }

    @Test
    public void getUser() throws Exception {
        Mockito.when(userService.getUser(111L)).thenReturn(Optional.of(userOne));

        final String json = this.mvc
                .perform(MockMvcRequestBuilders.get("/users/111").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        final User user = mapper.readValue(json, User.class);

        MatcherAssert.assertThat(user, Matchers.is(userOne));

        Mockito.verify(userService).getUser(111L);
    }

    @SneakyThrows
    @Test
    public void postUser() {
        this.mvc.perform(
                MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(userOne)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());

        Mockito.verify(userService).saveOrUpdateUser(userOne);
    }

    @SneakyThrows
    @Test
    public void deleteUser() {
        this.mvc.perform(MockMvcRequestBuilders.delete("/users/333"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(userService).deleteUser(333L);
    }

    @SneakyThrows
    @Test
    public void putUser() {
        this.mvc.perform(
                MockMvcRequestBuilders.put("/users/333")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(userOne)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotImplemented());

        Mockito.verifyNoInteractions(userService);
    }
}
