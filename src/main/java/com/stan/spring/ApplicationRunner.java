package com.stan.spring;

import com.stan.spring.database.pool.ConnectionPool;
import com.stan.spring.database.repository.CompanyRepository;
import com.stan.spring.database.repository.UserRepository;
import com.stan.spring.ioc.Container;
import com.stan.spring.service.UserService;

public class ApplicationRunner {
    public static void main(String[] args) {
        var container = new Container();


//        var connectionpool = container.get(ConnectionPool.class);
//        var userRepository = container.get(UserRepository.class);
//        var companyRepository = container.get(CompanyRepository.class);
        var userService = container.get(UserService.class);




//        var connectionpool = new ConnectionPool();
//        var userRepository = new UserRepository(connectionpool);
//        var companyRepository = new CompanyRepository(connectionpool);
//        var userService = new UserService(userRepository, companyRepository);
    }
}
