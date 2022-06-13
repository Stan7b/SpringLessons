package com.stan.spring.database.repository;

import com.stan.spring.bpp.Auditing;
import com.stan.spring.bpp.InjectBean;
import com.stan.spring.bpp.Transaction;
import com.stan.spring.database.entity.Company;
import com.stan.spring.database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company>  {

    @InjectBean
    private  ConnectionPool connectionPool;

    @PostConstruct
    private void init(){
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method");
        return Optional.of(new Company(id));
    }

    @Override
    public void detele(Company entity) {
        System.out.println("delete");

    }
}
