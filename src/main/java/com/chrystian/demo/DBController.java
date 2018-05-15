package com.chrystian.demo;

import com.chrystian.entity.UserInfo;
import com.chrystian.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DBController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/save")
    public String save(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserInfo u1 = new UserInfo();
        UserInfo u2 = new UserInfo();
        UserInfo u3 = new UserInfo();
        UserInfo u4 = new UserInfo();
        u1.setUsername("user1");
        u1.setPassword(encoder.encode("user1"));
        u2.setUsername("user2");
        u2.setPassword(encoder.encode("user2"));
        u3.setUsername("user3");
        u3.setPassword(encoder.encode("user3"));
        u4.setUsername("user4");
        u4.setPassword("user4");
        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);
        userRepository.save(u4);

        return "Success";
    }

    @RequestMapping("/list")
    public List<UserInfo> listAllUsers(){
        List<UserInfo> users = this.userRepository.findAll();
        return users;
    }
}
