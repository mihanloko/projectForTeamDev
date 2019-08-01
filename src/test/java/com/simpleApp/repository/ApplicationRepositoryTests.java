package com.simpleApp.repository;

import com.simpleApp.model.Applications;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class ApplicationRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ApplicationRepository applicationRepository;

    private Applications applications;
    @Before
    public void setUp() {
        applications = new Applications();
        applications.setNameApplication("App12");
        applications.setNextApplication("App24");
        applications.setPreviousApplication("App71");
    }

    @Test
    public void findAll() throws Exception {
        //given
        entityManager.persist(applications);
        entityManager.flush();

        //when
        List<Applications> applicationsList = applicationRepository.findAll();

        //then
        assertThat(applicationsList.size()).isEqualTo(6);
        //assertThat(applicationsList.get(1)).isEqualTo(applications);
    }

    @Test
    public void findAllById() throws Exception {
        //given
        entityManager.persist(applications);
        entityManager.flush();

        //when
        Applications allById = applicationRepository.findAllById(applications.getId());

        //then
        assertThat(allById.getNameApplication()).isEqualTo(applications.getNameApplication());
    }

    @Test
    public void deleteById() throws Exception {
        //given
        entityManager.persist(applications);
        entityManager.flush();

        //when
        applicationRepository.deleteById(applications.getId());
        List<Applications> applicationsList = applicationRepository.findAll();

        //then
        assertThat(applicationsList.size()).isEqualTo(5);
    }
}
