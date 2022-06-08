package com.stan.spring;

import com.stan.spring.database.pool.ConnectionPool;
import com.stan.spring.database.repository.CompanyRepository;
import com.stan.spring.database.repository.UserRepository;
import com.stan.spring.ioc.Container;
import com.stan.spring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");
        var connectionPool = context.getBean("p2",ConnectionPool.class);
        System.out.println(connectionPool);
    }
}
