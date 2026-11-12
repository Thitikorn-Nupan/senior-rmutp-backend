package com.ttknpdev.ecomercebackend.services.security;


import com.ttknpdev.ecomercebackend.entities.security.User;
import com.ttknpdev.ecomercebackend.log.Logback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

// @Service // I don't need this annotation because I call this class on my configuration beans class
// ** (Meaning I set any things in this class But I will build it / convert it to beans. Do it on my configuration class)
public class JwtUserDetailsService implements UserDetailsService {
    private Logback logback;
    private UserService userService;

    public JwtUserDetailsService() {
        logback = new Logback(JwtUserDetailsService.class);
    }

    @Autowired // I need to use SDI. I think it works after generate constructor
    public void setUserDao(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null; // for storing some roles from database
        User user = userService.read(username); // search by username
        logback.log.warn("user {}",user);
        if (user == null) {
            logback.log.warn("User is not found (username) {} " , username);
            throw new UsernameNotFoundException("User is not found (username : " + username + ")");
        }
        roles = List.of(new SimpleGrantedAuthority(user.getRoles()));
        // it's a same name class (User) you can call it like below
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), //  username
                user.getPassword(), // password
                roles
        ); // roles
    }

}
