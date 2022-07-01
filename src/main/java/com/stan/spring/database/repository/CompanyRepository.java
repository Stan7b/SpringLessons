package com.stan.spring.database.repository;

import com.stan.spring.bpp.Auditing;
import com.stan.spring.bpp.Transaction;
import com.stan.spring.database.entity.Company;
import com.stan.spring.database.pool.ConnectionPool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.Repository;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public interface CompanyRepository extends Repository<Company,Integer> {

   Optional<Company> findById(Integer id);

    void delete(Company entity);

}
