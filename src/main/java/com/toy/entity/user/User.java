package com.toy.entity.user;

import com.toy.Role;
import com.toy.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_seq")
    private Long userSeq;
    private String userId;
    private String userPw;
    private String userNm;
    private String email;

    private Role role;

    private String provider;
    private String providerId;

    public User update(String userNm, String email) {
        this.userNm = userNm;
        this.email = email;
        return this;
    }
}
