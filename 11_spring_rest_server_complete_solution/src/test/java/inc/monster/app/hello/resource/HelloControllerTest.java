package inc.monster.app.hello.resource;

import inc.monster.app.hello.controller.HelloController;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.Map;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    private static final Map<String, String> NS =
            Collections.singletonMap("ns", "http://monster.inc/hello");

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello_Accept_JSON() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("Hello World!")));
    }

    @Test
    public void getHello_Accept_XML() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_XML))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_XML))
                .andExpect(MockMvcResultMatchers.xpath(
                        "/ns:hello/message", NS)
                        .string("Hello World!"));
    }
}
