package com.ttknpdev.ecomercebackend.config;

import com.ttknpdev.ecomercebackend.config.jwt.JwtAuthenticationEntryPoint;
import com.ttknpdev.ecomercebackend.config.jwt.JwtRequestFilter;
import com.ttknpdev.ecomercebackend.config.jwt.JwtTokenUtil;
import com.ttknpdev.ecomercebackend.services.security.JwtUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ManageBeans {
    @Bean(name = "entryPoint")
    public JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint() {
        return new JwtAuthenticationEntryPoint();
    }
    @Bean(name = "requestFilter")
    public JwtRequestFilter jwtRequestFilter() {
        return new JwtRequestFilter(jwtUserDetailsService(),jwtTokenUtil());
    }
    @Bean(name = "tokenUtil")
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }
    @Bean(name = "detailsService") // use @Bean instead @Service
    public JwtUserDetailsService jwtUserDetailsService() {
        return new JwtUserDetailsService();
    }
    @Bean(name = "bcryptEncoder")
    public PasswordEncoder getBcryptEncoder() {
        return new BCryptPasswordEncoder();
    }
}
