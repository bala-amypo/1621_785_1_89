package com.example.demo.security;
import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
@Component
public class JwtUtil {
    public String createToken(Long userId, String email, String role) {
        return "FAKE_TOKEN_" + email;
    }

    public String generateToken(UserDetails userDetails, User user) {
        return createToken(
                user.getId(),
                userDetails.getUsername(),
                user.getRole()
        );
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("FAKE_TOKEN_");
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return validateToken(token)
                && getEmail(token).equals(userDetails.getUsername());
    }

    public String getEmail(String token) {
        return token.replace("FAKE_TOKEN_", "");
    }

    public String getRole(String token) {
        return "USER";
    }
}
