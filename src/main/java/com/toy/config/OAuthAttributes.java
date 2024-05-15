package com.toy.config;

import com.toy.dto.user.JoinRequest;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

public enum OAuthAttributes {

    GOOGLE("google", (attribute) -> {
        JoinRequest join = new JoinRequest(); // dto
        join.setUserNm((String)attribute.get("name"));
        join.setEmail((String)attribute.get("email"));

        return join;
    });

    // 로그인한 서비스 google
    private final String registrationId;

    // 로그인한 사용자의 정보를 통하여 dto 를 가져온다
    private final Function<Map<String, Object>, JoinRequest> of;

    OAuthAttributes(String registrationId, Function<Map<String, Object>, JoinRequest> of) {
        this.registrationId = registrationId;
        this.of = of;
    }

    public static JoinRequest extract(String registrationId, Map<String, Object> attributes) {
        return Arrays.stream(values())
                .filter(value -> registrationId.equals(value.registrationId))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .of.apply(attributes);
    }
}