package com.ttknpdev.ecomercebackend.entities.receive_login_and_register;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
    This class is required for storing
    the username and password , we receive from the client.
*/
@AllArgsConstructor
@Getter
public class SignIn {
    private String username;
    private String password;
}
