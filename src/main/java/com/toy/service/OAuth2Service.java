package com.toy.service;

import com.toy.config.OAuthAttributes;
import com.toy.dto.user.JoinRequest;
import com.toy.entity.user.User;
import com.toy.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OAuth2Service implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService oAuth2UserService = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = oAuth2UserService.loadUser(userRequest);

        // 로그인을 수행한 서비스의 이름
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        String userNameAttributeName = userRequest
                .getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName(); // PK가 되는 정보

        // 사용자가 가지고 있는 정보
        Map<String, Object> attributes = oAuth2User.getAttributes();

        JoinRequest join = OAuthAttributes.extract(registrationId, attributes);
        join.setProvider(registrationId);

        updateOrSaveUser(join);

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("USER")),
                attributes,
                userNameAttributeName);
    }

    public User updateOrSaveUser(JoinRequest join) {
        User user = userRepository
                .findUserByEmailAndProvider(join.getEmail(), join.getProvider())
                .map(value -> value.update(join.getUserNm(), join.getEmail()))
                .orElse(join.toEntity());

        return userRepository.save(user);
    }

}