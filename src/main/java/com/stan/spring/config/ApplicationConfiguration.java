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
@Configuration(proxyBeanMethods = true)
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
        @Bean()
        @Scope(BeanDefinition.SCOPE_PROTOTYPE)
        public ConnectionPool pool3(){
                return new ConnectionPool("test-pool",25);
        }

        @Bean
        @Profile("prod|web")
        public UserRepository userRepository3(){
                var userRepository1 = new UserRepository(pool3());
                var userRepository2 = new UserRepository(pool3());
                var userRepository3 = new UserRepository(pool3());
                return new UserRepository(pool3());
        }



}
