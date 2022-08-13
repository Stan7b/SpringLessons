package com.stan.spring.database.repository;

import com.stan.spring.database.entity.User;
import com.stan.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserResository {

    List<User> findAllByFilter(UserFilter filter);

}
