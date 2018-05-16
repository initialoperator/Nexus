package com.chrystian.demo;

import com.chrystian.configuration.WebSecurityConfiguration;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = { WebSecurityConfiguration.class, MVCConfiguration.class })
public class ControllerTest extends DemoApplicationTests {

    @Test
    public void givenNotAuth_whenAddFoo_thenUnauthorized() throws Exception {
        mvc.perform(post("/auth/foos").contentType(MediaType.APPLICATION_JSON).content(createUser())).andExpect(status().isUnauthorized());
    }

    @Test
    public void givenAuth_whenAddFoo_thenCreated() throws Exception {
        mvc.perform(post("/auth/foos").contentType(MediaType.APPLICATION_JSON).content(createUser()).with(testUser())).andExpect(status().isCreated());
    }

}
