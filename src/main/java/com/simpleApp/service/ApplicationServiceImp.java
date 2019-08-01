package com.simpleApp.service;

import com.simpleApp.convert.ApplicationFromToApplication;
import com.simpleApp.model.Applications;
import com.simpleApp.model.ApplicationsForm;
import com.simpleApp.repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ApplicationServiceImp implements ApplicationService {

    private static Logger logger = LoggerFactory.getLogger(ApplicationServiceImp.class);
    private ApplicationRepository applicationRepository;
    private ApplicationFromToApplication applicationFromToApplication;

    @Autowired
    public ApplicationServiceImp(ApplicationRepository applicationRepository, ApplicationFromToApplication applicationFromToApplication) {
        this.applicationRepository = applicationRepository;
        this.applicationFromToApplication = applicationFromToApplication;
    }

    @Override
    public Applications getById(Long id) {
        logger.info("IN ApplicationServiceImp getById {}", id);
        //return applicationRepository.findOne(id);
        return applicationRepository.findById(id).orElse(null);
    }

    @Override
    public Applications saveOrUpdate(Applications applications) {
        logger.info("IN ApplicationServiceImp save {}", applications);
        applicationRepository.save(applications);
        return applications;
    }

    @Override
    public Applications saveOrUpdateApplicationForm(ApplicationsForm applicationsForm) {
        Applications savedApplications = saveOrUpdate(applicationFromToApplication.convert(applicationsForm));
        logger.info("Saved applications id = ???"); // ToDo
        return savedApplications;
    }

    @Override
    public void delete(Long id) {
        logger.info("IN ApplicationServiceImp delete {}", id);
        //applicationRepository.delete(id);
        applicationRepository.deleteById(id);
    }

    @Override
    public List<Applications> getAll() {
        //logger.info("IN ApplicationServiceImp getAll");
        //return applicationRepository.findAll();
        List<Applications> applications = new ArrayList<>();
        applicationRepository.findAll().forEach(applications::add);
        return applications;
    }
}
