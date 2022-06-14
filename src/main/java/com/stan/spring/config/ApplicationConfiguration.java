package com.stan.spring.config;


import com.stan.spring.database.repository.CrudRepository;
import com.stan.spring.web.config.WebConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Import(WebConfiguration.class)
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.stan.spring",
   useDefaultFilters = false,
        includeFilters = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION,value = Component.class),
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = CrudRepository.class),
            @ComponentScan.Filter(type = FilterType.REGEX,pattern = "com\\..+Repository")
        }
)
public class ApplicationConfiguration {




}
