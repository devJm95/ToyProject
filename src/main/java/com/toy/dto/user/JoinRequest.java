package com.toy.dto.user;

import com.toy.Role;
import com.toy.entity.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JoinRequest {

    private String userId;
    private String userPw;
    private String pwChk;
    private String userNm;

    public User toEntity(String encodedPassword) {
        return User.builder()
                .userId(this.userId)
                .userPw(encodedPassword)
                .userNm(this.userNm)
                .role(Role.USER)
                .build();
    }
}
