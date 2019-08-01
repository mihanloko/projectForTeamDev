package com.simpleApp.service;

import com.simpleApp.model.Applications;
import com.simpleApp.model.ApplicationsForm;

import java.util.List;

public interface ApplicationService {
    Applications getById(Long id);

    Applications saveOrUpdate(Applications applications);

    Applications saveOrUpdateApplicationForm(ApplicationsForm applicationsForm);

    void delete(Long id);

    List<Applications> getAll();
}
