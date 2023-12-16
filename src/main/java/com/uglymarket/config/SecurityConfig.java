package com.uglymarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SecurityConfig {

    //스프링 필터체인 관리 스프링 빈
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //?continue를 제거하기 위한 옵션
        HttpSessionRequestCache httpSessionRequestCache = new HttpSessionRequestCache();
        httpSessionRequestCache.setMatchingRequestParameterName(null);

        //csrt 사용 안 함
        http.csrf(AbstractHttpConfigurer::disable);

        //?continue 제거
        http.requestCache(request -> request
                .requestCache(httpSessionRequestCache));

        //해당 URL에 관련된 요청은 모두 허용
        http.authorizeHttpRequests(request -> request
                .requestMatchers("/image/**", "/member/**", "/item/list", "/item/**")
                .permitAll());

        //그 외의 URL에 관련된 요청은 모두 인증 필요
        http.authorizeHttpRequests(request -> request
                .anyRequest()
                .authenticated());

        //로그인 설정
        http.formLogin(login -> login
                .loginPage("/member/login")
                .loginProcessingUrl("/member/login"));

        //로그아웃 설정
        http.logout(logout -> logout
                .logoutUrl("/member/logout"));

        return http.build();
    }
}
