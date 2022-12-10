package com.huseyinaydin.controller;

import com.huseyinaydin.config.JwtUtils;
import com.huseyinaydin.dao.UserDao;
import com.huseyinaydin.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        System.out.println(authenticationRequest.getEmail() + " --- " + authenticationRequest.getPassword());
        /*authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword())
        );*/
        System.out.println("ğğğğ");
        final UserDetails user = userDao.findByUsername(authenticationRequest.getEmail());
        System.out.println("pppp");
        System.out.println(user + " " + " selam");
        if(user.getUsername() != null){
            System.out.println(user);
            System.out.println("fff ggg yyy");
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
        return ResponseEntity.status(400).body("Error");
    }
}
