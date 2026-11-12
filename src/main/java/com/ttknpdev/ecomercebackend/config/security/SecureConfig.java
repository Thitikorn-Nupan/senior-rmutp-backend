package com.ttknpdev.ecomercebackend.config.security;


import com.ttknpdev.ecomercebackend.config.jwt.JwtAuthenticationEntryPoint;
import com.ttknpdev.ecomercebackend.config.jwt.JwtRequestFilter;
import com.ttknpdev.ecomercebackend.services.security.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.Customizer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/*
    It's my config
    but, I don't need to specify it
    because I will call it
    pass by @bean -> SecurityConfig class -> SecurityFilterChain method
*/
@Configuration
@EnableWebSecurity
public class SecureConfig {
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private PasswordEncoder passwordEncoder;
    private JwtRequestFilter jwtRequestFilter;
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    public SecureConfig(
            @Qualifier("entryPoint") JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
            @Qualifier("requestFilter") JwtRequestFilter jwtRequestFilter,
            @Qualifier("detailsService") JwtUserDetailsService jwtUserDetailsService,
            @Qualifier("bcryptEncoder") PasswordEncoder passwordEncoder) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtRequestFilter = jwtRequestFilter;
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // configure AuthenticationManager so that it knows from where to load user for matching credentials. Use BCryptPasswordEncoder
        auth
                .userDetailsService(jwtUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config
                .getAuthenticationManager();
    }

    // ** for allowed origin all endpoints
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/api/**") //
                        .allowedOrigins("http://localhost:4200","http://localhost:4242","http://thitikorn-nupan.com:4242","http://203.159.95.172:4242","http://thitikorn-nupan.com") // 4242 port for tesing on docker
                        .allowedMethods("GET", "POST", "PUT", "DELETE"); // optional
            }
        };
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of(
                "http://localhost:4200",
                "http://localhost:4242",
                "http://thitikorn-nupan.com:4242",
                "http://203.159.95.172:4242",
                "http://thitikorn-nupan.com"
        ));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests((authenticate) ->
                                authenticate
                                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                        // it won't authenticate two particular request
                                        /// .requestMatchers(HttpMethod.GET,"/**").permitAll()
                                        .requestMatchers(HttpMethod.POST,"/api/upload-file").permitAll()
                                        .requestMatchers(HttpMethod.GET,"/api/download-file/**").permitAll()
                                        .requestMatchers(HttpMethod.POST,"/api/checkout/create-payment-intent").permitAll()
                                        .requestMatchers(HttpMethod.POST,"/api/checkout/purchase").permitAll()
                                        .requestMatchers(HttpMethod.GET, "/api/district/**").permitAll() // **
                                        .requestMatchers(HttpMethod.GET, "/api/province/**").permitAll() // **
                                        .requestMatchers(HttpMethod.POST, "/api/manage/login/**").permitAll() // ** login and get jwt
                                        .requestMatchers(HttpMethod.POST, "/api/manage/register/**").permitAll() // **
                                        .requestMatchers( HttpMethod.GET,"/api/product/**").permitAll()
                                        .requestMatchers( HttpMethod.GET,"/api/product-category/**").permitAll()
                                        // ***
                                        // it will authenticate this particular request who has Role like below it can access
                                        // use jwt and role is a user can access this
                                        // .requestMatchers(HttpMethod.GET,"/api/order/search/**").hasAnyRole("USER")
                                        .requestMatchers(HttpMethod.GET,"/api/order/search/**").hasAnyRole("USER","ADMIN")
                                        .requestMatchers(HttpMethod.GET,"/api/order/all").hasAnyRole("ADMIN")
                                        .requestMatchers(HttpMethod.GET,"/api/order/only-perfumes").hasAnyRole("ADMIN")
                                        .requestMatchers(HttpMethod.PUT,"/api/order/update-status-purchase").hasAnyRole("ADMIN")
                                        // and all other requests need to be authenticated

                                        // .requestMatchers("/resources/**", "/bootstrap/**", "/static/**", "/css/**", "/js/**").permitAll()
                                        .anyRequest()
                                        .authenticated()
                        // *** we can pass user , password on header
                        // Basic <Base64 encoded username:password> (value) in Authorization key
                        // encode to base64 by www.base64encode.org
                )
                // make sure we use stateless session;
                // session won't be used to
                // store user's state.
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        // httpSecurity.addFilterBefore(jwtRequestFilter , UsernamePasswordAuthenticationFilter.class);

        httpSecurity.csrf().disable();
        httpSecurity.httpBasic();
        httpSecurity.headers().frameOptions().disable();
        /*
           when you need to use console of h2 you just specify  httpSecurity.headers().frameOptions().disable(); it works for case
           ** i try to access it can into login page but h2 page doesn't load
         */
        return httpSecurity.build();
    }
}
