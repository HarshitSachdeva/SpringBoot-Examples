package com.harshit.JWTDemo.controller;

import com.harshit.JWTDemo.model.JwtRequest;
import com.harshit.JWTDemo.model.JwtResponse;
import com.harshit.JWTDemo.service.UserService;
import com.harshit.JWTDemo.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String home() {
        return "Welcome harshit";
    }

    @PostMapping("/authenticate")
    public JwtResponse authentication (@RequestBody JwtRequest request) throws Exception{
        try {
            authenticationManager.authenticate
                    (new UsernamePasswordAuthenticationToken
                            (request.getUserName(), request.getPassword()));
        }
        catch (BadCredentialsException e) {
            throw new Exception("INVALID CREDENTIALS",e);
        }

        final UserDetails userDetails=userService.loadUserByUsername(request.getUserName());
        final String token= jwtUtility.generateToken(userDetails);

        return new JwtResponse(token);
    }
}
