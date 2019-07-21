package com.simpleApp.repository;

import com.simpleApp.model.Servers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Servers, Long> {
}
