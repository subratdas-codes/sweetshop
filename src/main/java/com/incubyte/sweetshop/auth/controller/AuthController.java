package com.incubyte.sweetshop.auth.controller;

import com.incubyte.sweetshop.auth.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> req) {
        authService.register(req.get("username"), req.get("password"));
        return "User registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> req) {
        return authService.login(req.get("username"), req.get("password"));
    }
}
