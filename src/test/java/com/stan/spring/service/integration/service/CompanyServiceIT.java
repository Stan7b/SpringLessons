package com.stan.spring.service.integration.service;


import com.stan.spring.ApplicationRunner;
import com.stan.spring.config.DatabaseProperties;
import com.stan.spring.database.entity.Company;
import com.stan.spring.dto.CompanyReadDto;
import com.stan.spring.listener.entity.EntityEvent;
import com.stan.spring.service.CompanyService;
import com.stan.spring.service.integration.anotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationRunner.class, initializers = ConfigDataApplicationContextInitializer.class)
@IT
@RequiredArgsConstructor
public class CompanyServiceIT {


    private final CompanyService companyService;
    private final DatabaseProperties databaseProperties;
    private static final Integer COMPANY_ID=1;


    @Test
    void findById(){
        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));


    }

}
