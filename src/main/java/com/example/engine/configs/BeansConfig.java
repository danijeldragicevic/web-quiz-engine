package com.example.engine.configs;

import com.example.engine.mappers.impl.ModelMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeansConfig {
    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public ModelMapperImpl getModelMapper() {
        return new ModelMapperImpl();
    }
    
}
