package com.stan.spring.config;


import com.stan.spring.database.pool.ConnectionPool;
import com.stan.spring.database.repository.CrudRepository;
import com.stan.spring.database.repository.UserRepository;
import com.stan.spring.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
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

        @Bean("pool2")
        @Scope(BeanDefinition.SCOPE_PROTOTYPE)
        public ConnectionPool pool2(@Value("${db.username")String name){
                return new ConnectionPool("test-name",20);
        }

        @Bean
        public UserRepository userRepository2(ConnectionPool pool2){
                return new UserRepository(pool2);
        }



}
