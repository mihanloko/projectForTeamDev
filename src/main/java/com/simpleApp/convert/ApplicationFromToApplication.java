package com.simpleApp.convert;

import com.simpleApp.model.Applications;
import com.simpleApp.model.ApplicationsForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ApplicationFromToApplication implements Converter<ApplicationsForm, Applications> {
    @Override
    public Applications convert(ApplicationsForm applicationsForm) {
        Applications applications = new Applications();
        if (applicationsForm.getId() != null  && !StringUtils.isEmpty(applicationsForm.getId())) {
            applications.setId(new Long(applicationsForm.getId()));
        }
        applications.setNameApplication(applicationsForm.getNameApplication());
        applications.setNextApplication(applicationsForm.getNextApplication());
        applications.setPreviousApplication(applicationsForm.getPreviousApplication());
        return applications;
    }
}
