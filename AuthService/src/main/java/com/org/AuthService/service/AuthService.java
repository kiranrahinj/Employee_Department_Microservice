package com.org.AuthService.service;

import com.org.AuthService.Entity.AuthRequest;
import com.org.AuthService.Entity.User;
import com.org.AuthService.repository.UserRepository;
import com.org.AuthService.security.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String generateToken(AuthRequest authRequest) {
        Authentication authenticate= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authenticate.isAuthenticated()){
            return jwtUtils.generateToken(authRequest.getUsername());
        }
        else{
            throw new RuntimeException("Invalid username or password");
        }
    }

    public void validateToken(String token) {
        jwtUtils.validateToken(token);
    }
}
