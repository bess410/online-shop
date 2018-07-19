package com.epam.andrei_sterkhov.online_shop.dto;

import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
public class User{
    private static AtomicLong count = new AtomicLong();
    private long id = count.incrementAndGet();
    private String userName;
    private String surname;
    private String login;
    private String pass;
}
