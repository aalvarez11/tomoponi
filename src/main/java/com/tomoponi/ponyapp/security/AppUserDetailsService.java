package com.tomoponi.ponyapp.security;

import com.tomoponi.ponyapp.model.AuthGroup;
import com.tomoponi.ponyapp.model.User;
import com.tomoponi.ponyapp.repository.AuthGroupRepository;
import com.tomoponi.ponyapp.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppUserDetailsService implements UserDetailsService {

    final AuthGroupRepository authGroupRepository;
    final UserService userService;

    @Autowired
    public AppUserDetailsService(AuthGroupRepository authGroupRepository, UserService userService) {
        this.authGroupRepository = authGroupRepository;
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userService.findByEmail(email);
        } catch (NoSuchElementException | UsernameNotFoundException e) {
            log.warn("Couldn't find username: " + email);
            e.printStackTrace();
        }
        List<AuthGroup> authGroupList = authGroupRepository.findByAuEmail(email);
        return new AppUserPrincipal(user, authGroupList);
    }
}
