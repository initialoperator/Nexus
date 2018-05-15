package com.chrystian.service;

import com.chrystian.entity.UserInfo;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserInfoDetails implements UserDetails {
    private UserInfo user;
    public UserInfoDetails(UserInfo user){
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getPrivileges().forEach(p ->{authorities.add(new SimpleGrantedAuthority(p));});
        return authorities;
    }


    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        //simply returns true
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
//        simply returns true;
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
//        simply returns true;
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

