package com.stan.spring.database.repository;

import com.stan.spring.bpp.InjectBean;
import com.stan.spring.database.pool.ConnectionPool;

public class CompanyRepository {

    @InjectBean
    private  ConnectionPool connectionPool;

}
