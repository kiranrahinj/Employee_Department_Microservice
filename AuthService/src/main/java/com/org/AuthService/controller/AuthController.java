package com.org.AuthService.controller;


import com.org.AuthService.Entity.AuthRequest;
import com.org.AuthService.Entity.User;
import com.org.AuthService.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> creteUser(@RequestBody User user) {
        return ResponseEntity.ok(authService.registerUser(user));
    }

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authService.generateToken(authRequest));
    }

    @GetMapping("/validate/{token}")
    public ResponseEntity<?> validateToken(@PathVariable String token) {
        authService.validateToken(token);
        return ResponseEntity.ok("Token is valid");
    }
}
