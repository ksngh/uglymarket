package com.uglymarket.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

    //도메인과 DTO 변환을 도와주는 스프링 빈
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    //비밀번호를 암호화하는 스프링 빈
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
