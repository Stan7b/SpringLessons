package com.stan.spring.database.repository;

import java.util.Optional;

public interface CrudRepository<K, E> {
    Optional<E>findById(K id);

    void detele(E entity);
}
