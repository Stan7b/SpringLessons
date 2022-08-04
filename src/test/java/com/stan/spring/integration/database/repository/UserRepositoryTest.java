package com.stan.spring.integration.database.repository;

import com.stan.spring.database.entity.User;
import com.stan.spring.database.repository.UserRepository;
import com.stan.spring.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


@IT
@RequiredArgsConstructor
class UserRepositoryTest {
    private final UserRepository userRepository;

    @Test
    void checkQueries(){
        var users = userRepository.findAllBy("a","ov");
        Assertions.assertThat(users).hasSize(3);
        System.out.println(users);
    }



}