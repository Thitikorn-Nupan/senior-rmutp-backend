package com.ttknpdev.ecomercebackend.entities.security;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

// for login
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String username;
    private String password;
    private String roles;
}