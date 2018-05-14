package com.chrystian.service;

import com.chrystian.entity.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserInfoDetails implements UserDetails {
    private UserInfo user;
    public UserInfoDetails(UserInfo user){
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
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

