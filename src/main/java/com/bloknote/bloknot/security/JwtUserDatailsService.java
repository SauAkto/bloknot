package com.bloknote.bloknot.security;

import com.bloknote.bloknot.model.User;
import com.bloknote.bloknot.security.jwt.JwtUser;
import com.bloknote.bloknot.security.jwt.JwtUserFactory;
import com.bloknote.bloknot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDatailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDatailsService(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User with username: "+ username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);
        return jwtUser;
    }
}
