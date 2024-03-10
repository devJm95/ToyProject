package com.toy.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"userSeq", "userId", "userPw", "userName", "userEmail", "userTel", "userYn"})
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_seq")
    private Long userSeq;
    //@Column(name=USER_ID)
    private String userId;
    private String userPw;
    private String userName;
    private String userEmail;
    private String userTel;
    private String userYn;
}
