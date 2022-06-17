package com.stan.spring.config;

import com.stan.spring.config.condition.JpaCondition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {

//    @Bean
//    @ConfigurationProperties(prefix = "db")
//    public DatabaseProperties databaseProperties(){
//        return new DatabaseProperties();
//    }

    @PostConstruct
    void init(){
        System.out.println("Jpa conf. is enabled");
    }


}
