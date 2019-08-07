package com.simpleApp.repository;

import com.simpleApp.model.Servers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServerRepository extends JpaRepository<Servers, Long> {
    List<Servers> findAll();

    Servers findAllById(Long id);
}
