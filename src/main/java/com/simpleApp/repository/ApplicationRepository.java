package com.simpleApp.repository;

import com.simpleApp.model.Applications;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Applications, Long> {
    List<Applications> findAll();

    Applications findAllById(Long id);
}
