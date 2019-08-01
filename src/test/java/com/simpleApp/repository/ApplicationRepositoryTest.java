package com.simpleApp.repository;

import com.simpleApp.model.Applications;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationRepositoryTest {

    private static final String NAME_APPLICATION = "Application 1";
    private static final String PREV_APPLICATION = "Application 15";
    private static final String NEXT_APPLICATION = "Application 11";

    @Autowired
    private ApplicationRepository applicationRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void applicationsTest() {
        // Given information table Application
        Applications applications = applicationRepository.findAll().get(1);

        // Save information table
//        applicationRepository.save(applications);

        // Compare
        Assert.assertNotNull(applications.getId());
        //Applications newApplications = applicationRepository.findOne(applications.getId());
        Applications newApplications = applicationRepository.findById(applications.getId()).orElse(null);
        Assert.assertEquals((Long) 2L, newApplications.getId());
        Assert.assertEquals(NAME_APPLICATION, newApplications.getNameApplication());
        Assert.assertEquals(PREV_APPLICATION, newApplications.getPreviousApplication());
        Assert.assertEquals(NEXT_APPLICATION, newApplications.getNextApplication());
    }
}
