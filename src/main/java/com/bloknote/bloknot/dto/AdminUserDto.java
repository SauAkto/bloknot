package com.bloknote.bloknot.dto;

import com.bloknote.bloknot.model.Status;
import com.bloknote.bloknot.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private Long id;
    private String username;
    private String firsName;
    private String lastName;
    private String email;
    private String status;

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setFirstName(firsName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setStatus(Status.valueOf(status));

        return user;
    }

    public static AdminUserDto fromUser(User user){
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setUsername(user.getUsername());
        adminUserDto.setFirsName(user.getFirstName());
        adminUserDto.setLastName(user.getLastName());
        adminUserDto.setEmail(user.getEmail());
        adminUserDto.setStatus(user.getStatus().name());

        return adminUserDto;
    }
}
