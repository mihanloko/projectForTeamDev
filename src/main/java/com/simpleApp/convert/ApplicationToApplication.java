package com.simpleApp.convert;

import com.simpleApp.model.Applications;
import com.simpleApp.model.ApplicationsForm;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ApplicationToApplication implements Converter<Applications, ApplicationsForm> {
    @Override
    public ApplicationsForm convert(Applications applications) {
        ApplicationsForm applicationsForm = new ApplicationsForm();
        applicationsForm.setId(applications.getId());
        applicationsForm.setNameApplication(applications.getNameApplication());
        applicationsForm.setNextApplication(applications.getNextApplication());
        applicationsForm.setPreviousApplication(applications.getPreviousApplication());
        return applicationsForm;
    }
}
