package com.bloknote.bloknot.security.jwt;

import com.bloknote.bloknot.model.Role;
import com.bloknote.bloknot.model.Status;
import com.bloknote.bloknot.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    public JwtUserFactory(){
    }

    public static JwtUser create(User user){
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getEmail(),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles())),
                user.getStatus().equals(Status.ACTIVE),
                user.getUpdated()
        );
    }
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRole){
        return userRole.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
