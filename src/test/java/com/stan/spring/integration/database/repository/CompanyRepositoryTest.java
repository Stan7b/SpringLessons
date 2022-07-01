package com.stan.spring.integration.database.repository;

import com.stan.spring.database.entity.Company;
import com.stan.spring.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
@Transactional
@Commit
class CompanyRepositoryTest {

    private final EntityManager entityManager;



    @Test
    void findById() {
        var company = entityManager.find(Company.class, 1);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);
    }

    @Test
    void save(){
        var company = Company.builder()
                .name("Apple")
                .locales(Map.of(
                        "ua","Apple опис",
                        "en","Apple description"
                ))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());



    }

}