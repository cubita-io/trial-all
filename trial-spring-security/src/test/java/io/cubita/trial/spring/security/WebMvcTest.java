package io.cubita.trial.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebMvcTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void test1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello")
                .param("aa", "123")
                .header("bb", "345")
            .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

}
