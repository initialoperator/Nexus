package com.chrystian.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserInfoController {

    @RequestMapping("/login")
    public String getUserLoginPage() {

        return "login";
    }
}
