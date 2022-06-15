package com.stan.spring.service;

import com.stan.spring.database.entity.Company;
import com.stan.spring.database.repository.CrudRepository;
import com.stan.spring.dto.CompanyReadDto;
import com.stan.spring.listener.entity.AccessType;
import com.stan.spring.listener.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CrudRepository<Integer, Company> companyRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;

    public CompanyService(CrudRepository<Integer,Company> companyRepository,
                          UserService userService,
                          ApplicationEventPublisher eventPublisher) {
        this.userService = userService;
        this.companyRepository =companyRepository;
        this.eventPublisher = eventPublisher;
    }
     public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id)
                .map(entity -> {
                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.id());
                });
     }


}
