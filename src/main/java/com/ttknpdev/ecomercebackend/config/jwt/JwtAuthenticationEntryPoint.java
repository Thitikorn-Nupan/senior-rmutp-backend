package com.ttknpdev.ecomercebackend.config.jwt;

import com.ttknpdev.ecomercebackend.log.Logback;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;


public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private Logback logback;

    public JwtAuthenticationEntryPoint() {
        this.logback = new Logback(JwtAuthenticationEntryPoint.class);
    }

    /**
        request - that resulted in an AuthenticationException
        response - so that the user agent can begin authentication
        authException - that caused the invocation
    */
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        logback.log.warn("Unauthorized request: {} {} ({})",
                request.getMethod(),
                request.getRequestURI(),
                authException.getMessage());
        // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "unauthorized in this secure API"); // ** no response message on browser
        // ** this way below is better
        response.getWriter().append("Token was expired or User didn't exist"); // *** Note it's not just auth token expired it still catch if user no rules that you specify
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
