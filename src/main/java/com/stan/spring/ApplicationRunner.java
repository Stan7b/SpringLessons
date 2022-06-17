package com.stan.spring;

import com.stan.spring.config.ApplicationConfiguration;
import com.stan.spring.database.pool.ConnectionPool;
import com.stan.spring.database.repository.CompanyRepository;
import com.stan.spring.database.repository.CrudRepository;
import com.stan.spring.database.repository.UserRepository;
import com.stan.spring.ioc.Container;
import com.stan.spring.service.CompanyService;
import com.stan.spring.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class,args);
    }
}
