package com.toy.controller.user;

import com.toy.dto.user.JoinRequest;
import com.toy.entity.user.User;
import com.toy.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity join(@RequestBody JoinRequest request){
        User user = userService.join(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/sign-in")
    public ResponseEntity login(JoinRequest request){
        User user = userService.login(request);
        return ResponseEntity.ok().build();
    }
}
