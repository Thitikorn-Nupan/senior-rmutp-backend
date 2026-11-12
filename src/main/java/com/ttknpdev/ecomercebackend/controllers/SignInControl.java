package com.ttknpdev.ecomercebackend.controllers;


import com.ttknpdev.ecomercebackend.config.jwt.JwtTokenUtil;
import com.ttknpdev.ecomercebackend.entities.receive_login_and_register.SignIn;
import com.ttknpdev.ecomercebackend.services.security.JwtUserDetailsService;
import com.ttknpdev.ecomercebackend.services.security.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/manage")
public class SignInControl {

    private static final Logger log = LoggerFactory.getLogger(SignInControl.class);

    @Getter
    @AllArgsConstructor
    class JwtResponse {
        private String token;
        private String username;
        private List<? extends GrantedAuthority> roles;
    }

    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private JwtUserDetailsService userDetailsService;
    private UserService userService;

    @Autowired
    public SignInControl(AuthenticationManager authenticationManager,
                         @Qualifier("tokenUtil") JwtTokenUtil jwtTokenUtil,
                         @Qualifier("detailsService") JwtUserDetailsService userDetailsService,
                         UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    // **
    @PostMapping(value = "/register")
    private ResponseEntity<Boolean> registerUser(@RequestBody SignIn signIn) throws Exception {
        // if found a username return false
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.create(signIn.getUsername(), signIn.getPassword()));
    }


    @PostMapping(value = "/login")
    public ResponseEntity<JwtResponse> createJwtAndAuthenticateUser(@RequestBody SignIn signIn) throws Exception {
        authenticate(signIn.getUsername(), signIn.getPassword()); // if user did not exist will throw exception
        final UserDetails USER_DETAILS = userDetailsService.loadUserByUsername(signIn.getUsername()); // retrieve the user from database
        // log.warn("UserDetails: {}", USER_DETAILS.getAuthorities().stream().toList()); // get roles [ROLE_ADMIN] as list
        List<? extends GrantedAuthority> roles = USER_DETAILS.getAuthorities().stream().toList();
        final String TOKEN = jwtTokenUtil.generateToken(USER_DETAILS);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new JwtResponse(TOKEN, signIn.getUsername(),roles));
    }

    /*
        {
            "jwt": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aGl0aWtvcm4tbkBybXV0cC5hYy50aCIsImV4cCI6MTcyMjcwMzY5OCwiaWF0IjoxNzE5MTAzNjk4fQ.thXyDJ_htmOOWmjKfkr37Dm6ZHmFwXmlyvNMa3WkUP2nMnKiBU8JLFieYLthYgaj5tw1h2L-Q5zvJwLhnwmI2Q",
            "username": "thitikorn-n@rmutp.ac.th"
        }
    */

    private void authenticate(String username, String password) throws Exception {
        try {

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        } catch (DisabledException e) {
            throw new Exception("User disabled", e.getCause());

        } catch (BadCredentialsException e) {
            /* If username and password is not correct it will find this exception */
            throw new Exception("Invalid credentials", e.getCause());

        }
    }


}
