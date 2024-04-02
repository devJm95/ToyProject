package com.toy.controller;

import com.toy.config.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @PostMapping("/gettoken")
    public ResponseEntity<String> getToken() {
        String token = JwtTokenProvider.generateToken("test");
        return ResponseEntity.ok(token);
    }
}
