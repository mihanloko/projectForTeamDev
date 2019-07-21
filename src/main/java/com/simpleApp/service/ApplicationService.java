package com.simpleApp.service;

import com.simpleApp.model.Applications;
import java.util.List;

public interface ApplicationService {
    Applications getById(Long id);

    void save(Applications applications);

    void delete(Long id);

    List<Applications> getAll();
}
