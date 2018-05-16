package com.chrystian.demo;

import com.chrystian.entity.UserInfo;
import com.chrystian.service.UserInfoDetails;
import com.chrystian.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ApplicationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String login(@RequestParam("username") final String username, @RequestParam("password") final String password, final HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authReq =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth = authManager.authenticate(authReq);
        UserDetails user = userInfoService.loadUserByUsername(username);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", sc);
        session.setAttribute("user", user);

        return "redirect:/home";
    }
}
