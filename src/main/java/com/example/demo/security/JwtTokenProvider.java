package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {
    
    public String createToken(String username, String role) {
        return "jwt-token-" + username;
    }
    
    public boolean validateToken(String token) {
        return token != null && token.startsWith("jwt-token-");
    }
    
    public String getUsername(String token) {
        return token.replace("jwt-token-", "");
    }
}