package com.stan.spring.service;

import com.stan.spring.database.entity.Company;
import com.stan.spring.database.repository.CrudRepository;
import com.stan.spring.dto.CompanyReadDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CrudRepository<Integer, Company> companyRepository;
    private final UserService userService;

    public CompanyService(CrudRepository<Integer,Company> companyRepository,
                          UserService userService) {
        this.userService = userService;
        this.companyRepository =companyRepository;
    }
     public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id)
                .map(entity -> new CompanyReadDto(entity.id()))
     }


}
