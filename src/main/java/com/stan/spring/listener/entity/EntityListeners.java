package com.stan.spring.listener.entity;


import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityListeners {

    @EventListener
    public void acceptEntity(EntityEvent entityEvent){
        System.out.println("Entity: "+entityEvent);
    }

}
