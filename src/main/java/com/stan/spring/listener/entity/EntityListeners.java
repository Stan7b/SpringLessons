package com.stan.spring.listener.entity;


import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class EntityListeners {

    @EventListener(condition = "#root.args[0].accessType.name()=='DELETE'")
    @Order(10)
    public void acceptEntity(EntityEvent entityEvent){
        System.out.println("Entity: "+entityEvent);
    }

}
