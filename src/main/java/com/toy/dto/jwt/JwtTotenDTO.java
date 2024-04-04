package com.toy.dto.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class JwtTotenDTO {
    private String grantType;
    private String accessToken;
    private String refreshToken;
}
