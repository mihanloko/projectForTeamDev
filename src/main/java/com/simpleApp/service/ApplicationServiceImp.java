package com.simpleApp.service;

import com.simpleApp.model.Applications;
import com.simpleApp.repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApplicationServiceImp implements ApplicationService {

    private static Logger logger = LoggerFactory.getLogger(ApplicationServiceImp.class);

    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public Applications getById(Long id) {
        logger.info("IN ApplicationServiceImp getById {}", id);
        return applicationRepository.findOne(id);
    }

    @Override
    public void save(Applications applications) {
        logger.info("IN ApplicationServiceImp save {}", applications);
        applicationRepository.save(applications);
    }

    @Override
    public void delete(Long id) {
        logger.info("IN ApplicationServiceImp delete {}", id);
        applicationRepository.delete(id);
    }

    @Override
    public List<Applications> getAll() {
        logger.info("IN ApplicationServiceImp getAll");
        return applicationRepository.findAll();
    }
}
