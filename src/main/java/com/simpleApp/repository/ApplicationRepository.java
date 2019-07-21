package com.simpleApp.repository;

import com.simpleApp.model.Applications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Applications, Long> {
}
