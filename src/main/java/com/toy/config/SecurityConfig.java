package com.toy.config;

import com.toy.service.OAuth2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    private final OAuth2Service oAuth2Service;

    // 비밀번호 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // security 를 적용하지 않을 리소스
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                // error endpoint를 열어줘야 함, favicon.ico 추가!
                .requestMatchers("/error", "/favicon.ico");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(withDefaults())
                .authorizeRequests(
                        (auth) -> auth
                            .requestMatchers("/board/**").authenticated()
                            .requestMatchers("/login/**").permitAll()
                            .requestMatchers("/**").permitAll()
//                            .anyRequest().authenticated()
                            .anyRequest().permitAll()
                )
//                .oauth2Login(Customizer.withDefaults())
                .oauth2Login((oauth2) -> oauth2.
                        userInfoEndpoint(userInfo -> userInfo
                                .userService(oAuth2Service))
                        .successHandler(oAuth2SuccessHandler))
//                .logout((logout) -> logout.logoutSuccessUrl("/"))
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin((formLogin) -> formLogin.disable())
                .csrf((csrf) -> csrf.disable())
                .httpBasic((httpBasic) -> httpBasic.disable())
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider)
                        , UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }}