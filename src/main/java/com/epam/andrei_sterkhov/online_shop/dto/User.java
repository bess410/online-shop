package com.epam.andrei_sterkhov.online_shop.dto;

import com.epam.andrei_sterkhov.online_shop.enums.Role;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class User{
    private String userName;
    private String surname;
    private String login;
    private String pass;
    private Role role = Role.CLIENT;
}
