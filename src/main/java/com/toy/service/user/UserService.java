package com.toy.service.user;

import com.toy.dto.user.JoinRequest;
import com.toy.entity.user.User;
import com.toy.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    public User join(JoinRequest joinRequest){
        String userId = joinRequest.getUserId();
        String password = joinRequest.getUserPw();

        String passwordRegex = "^(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        if(userRepository.existsByUserId(userId)){
            throw new RuntimeException("이미 존재하는 아이디입니다!");
        }
        if(!password.matches(passwordRegex)){
            throw new RuntimeException("비밀번호는 최소 8자 이상이어야 하며, 영문 소문자, 숫자, 특수문자를 최소 하나 이상 포함해야 합니다.");
        }

        return userRepository.save(joinRequest.toEntity(passwordEncoder.encode(joinRequest.getUserPw())));
    }

    public User login(JoinRequest request) {
        Optional<User> userOptional = userRepository.findByUserId(request.getUserId());

        if (userOptional.isEmpty()) {
            throw new RuntimeException("아이디가 존재하지 않습니다.");
        }

        User user = userOptional.get();
        String password = user.getUserPw();

        if (!passwordEncoder.matches(request.getUserPw(), password)) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        return user;
    }
}
