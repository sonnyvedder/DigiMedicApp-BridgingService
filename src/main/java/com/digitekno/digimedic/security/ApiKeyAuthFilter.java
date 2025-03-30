package com.digitekno.digimedic.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import com.digitekno.digimedic.config.ApiKeyConfig;
import java.io.IOException;
import java.util.Collections;

@Component
public class ApiKeyAuthFilter extends OncePerRequestFilter {

    @Autowired
    private ApiKeyConfig apiKeyConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String clientId = request.getHeader("X-Client-Id");
        String secretKey = request.getHeader("X-Secret-Key");

        if (isValidApiKey(clientId, secretKey)) {
            UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(clientId, null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private boolean isValidApiKey(String clientId, String secretKey) {
        return clientId != null && secretKey != null &&
               clientId.equals(apiKeyConfig.getClientId()) &&
               secretKey.equals(apiKeyConfig.getSecretKey());
    }
}