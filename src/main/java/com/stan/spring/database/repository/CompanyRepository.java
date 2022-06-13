package com.stan.spring.database.repository;

import com.stan.spring.bpp.Auditing;
import com.stan.spring.bpp.InjectBean;
import com.stan.spring.bpp.Transaction;
import com.stan.spring.database.entity.Company;
import com.stan.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company>  {

//    @Resource(name="pool1")
//    @Qualifier("pool1")
    private  ConnectionPool pool1;
    @Autowired
    private List<ConnectionPool> pools;

    @Value("${db.pool.size}")
    private Integer poolSize;

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

    @Autowired
    public void setPool1(ConnectionPool pool1) {
        this.pool1 = pool1;
    }
}
