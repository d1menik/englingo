package com.app.web.security;

import com.app.web.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private boolean active;
    private List<GrantedAuthority> roles;

    public CustomUserDetails(){
    }

    public CustomUserDetails(User user){
       this.username = user.getUsername();
       this.password = user.getPassword();
       this.active = user.isActive();
       this.roles = Arrays.stream(user.getRole().getRoleType().split(",")).map(SimpleGrantedAuthority::new)
               .collect(Collectors.toList());

    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
