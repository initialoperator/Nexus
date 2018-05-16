package com.chrystian.demo;

import com.chrystian.configuration.WebSecurityConfiguration;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = { WebSecurityConfiguration.class, MVCConfiguration.class })
public class ControllerTest extends DemoApplicationTests {

    @Test
    public void testHitHomeWithoutUser() throws Exception {
        mvc.perform(get("/home").contentType(MediaType.APPLICATION_JSON).content(createUser())).andExpect(status().is3xxRedirection());
    }

    @Test
    public void testHitHomeWithUser() throws Exception {
        mvc.perform(get("/home").contentType(MediaType.APPLICATION_JSON).content(createUser()).with(testUser())).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testHitAuthenticateWithGetMethod() throws Exception{
        mvc.perform(get("/authenticate").contentType(MediaType.APPLICATION_JSON).content(createUser()).with(testUser())).andExpect(status().isMethodNotAllowed());
    }
    @Test
    public void testHitAuthenticateWithPostMethodWithUser() throws Exception{
        mvc.perform(post("/authenticate").contentType(MediaType.APPLICATION_JSON).content(createUser()).with(testUser())).andExpect(status().is2xxSuccessful());
    }
}
