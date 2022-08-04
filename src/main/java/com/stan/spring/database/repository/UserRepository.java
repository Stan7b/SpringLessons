package com.stan.spring.database.repository;

import com.stan.spring.database.entity.User;
import com.stan.spring.database.pool.ConnectionPool;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u "+
    "where u.firstname like %:firstname% and u.lastname like %:lastname%")
    List<User> findAllBy(String firstname,String lastname);

    @Query(value = "SELECT u.* FROM users u WHERE u.username = :username",nativeQuery = true)
    List<User> findAllByUsername(String name);

}
