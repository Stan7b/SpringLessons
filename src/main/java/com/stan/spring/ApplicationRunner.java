package com.stan.spring;

import com.stan.spring.config.ApplicationConfiguration;
import com.stan.spring.database.pool.ConnectionPool;
import com.stan.spring.database.repository.CompanyRepository;
import com.stan.spring.database.repository.CrudRepository;
import com.stan.spring.database.repository.UserRepository;
import com.stan.spring.ioc.Container;
import com.stan.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {

            var connectionPool = context.getBean("pool1", ConnectionPool.class);
            System.out.println(connectionPool);

            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}
