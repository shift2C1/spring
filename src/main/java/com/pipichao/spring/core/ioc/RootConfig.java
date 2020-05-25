package com.pipichao.spring.core.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {
    @Bean
    public String string (){
        return "hahahh";
    }
}
