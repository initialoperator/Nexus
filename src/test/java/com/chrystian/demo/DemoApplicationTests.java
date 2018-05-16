package com.chrystian.demo;

import com.chrystian.entity.UserInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    private WebApplicationContext context;

    @Autowired
    private Filter springSecurityFilterChain;

    MockMvc mvc;

    //

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).addFilters(springSecurityFilterChain).build();
    }

    RequestPostProcessor testUser() {

        return user("user1").password("user1").roles("USER", "ADMIN");
    }

    RequestPostProcessor testAdmin() {

        return user("user2").password("user1").roles("USER", "ADMIN");
    }
    String createUser() throws JsonProcessingException {
        UserInfo user = new UserInfo();
        user.setUsername("user1");
        user.setPassword("user1");
        return new ObjectMapper().writeValueAsString(user);
    }

}
