package com.project.orderfoodsproject.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {
    private Long id;
    private String username;
    private String email;
    private String password;
}
