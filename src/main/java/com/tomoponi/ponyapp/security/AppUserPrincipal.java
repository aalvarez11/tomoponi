package com.tomoponi.ponyapp.security;

import com.tomoponi.ponyapp.model.AuthGroup;
import com.tomoponi.ponyapp.model.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppUserPrincipal implements UserDetails {
    User user;
    List<AuthGroup> authGroup;

    public AppUserPrincipal(User user, List<AuthGroup> authGroup) {
        this.user = user;
        this.authGroup = authGroup;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // first check if the auth list is empty
        if (authGroup == null ) { return Collections.emptyList(); }
        // otherwise, make a set for only unique elements
        Set<SimpleGrantedAuthority> authoritySet = new HashSet<>();
        // loop through auth list and add to the set
        authGroup.forEach(auth -> authoritySet.add(new SimpleGrantedAuthority(auth.getAuAuthGroup())));
        return authoritySet;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
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
        return true;
    }
}
