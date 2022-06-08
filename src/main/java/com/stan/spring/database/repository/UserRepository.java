package com.stan.spring.database.repository;

import com.stan.spring.database.pool.ConnectionPool;

public class UserRepository {
  private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
