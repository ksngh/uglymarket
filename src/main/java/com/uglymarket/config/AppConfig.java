package com.uglymarket.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //도메인과 DTO 변환을 도와주는 스프링 빈
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
