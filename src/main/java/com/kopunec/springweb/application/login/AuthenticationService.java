package com.kopunec.springweb.application.login;


import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        return username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin");
    }
}
