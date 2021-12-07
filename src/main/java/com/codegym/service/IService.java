package com.codegym.service;


import java.util.Optional;

public interface IService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T smartPhone);

    void remove(Long id);
}
