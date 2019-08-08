package com.simpleApp.repository;

import com.simpleApp.model.Applications;
import com.simpleApp.model.Servers;
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
public class ServerRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ServerRepository serverRepository;
    private ApplicationRepository applicationRepository;

    private Servers servers;
    private Applications applications;

    @Before
    public void setUp() {
        servers = new Servers();
        servers.setNameServer("Serv1");
        servers.setIdApplication(applicationRepository.findAllById(applications.getId()));
        servers.setDescription("Information Information Information");
    }

    @Test
    public void findAll() throws Exception {
        //given
        entityManager.persist(servers);
        entityManager.flush();

        //when
        List<Servers> serversList = serverRepository.findAll();

        //then
        assertThat(serversList.size()).isEqualTo(6);
        //assertThat(serversList.get(1)).isEqualTo(servers);
    }

    @Test
    public void findAllById() throws Exception {
        //given
        entityManager.persist(servers);
        entityManager.flush();

        //when
        Servers allById = serverRepository.findAllById(servers.getId());

        //then
        assertThat(allById.getNameServer()).isEqualTo(servers.getNameServer());
    }

    @Test
    public void deleteById() throws Exception {
        //given
        entityManager.persist(servers);
        entityManager.flush();

        //when
        serverRepository.deleteById(servers.getId());
        List<Servers> serversList = serverRepository.findAll();

        //then
        assertThat(serversList.size()).isEqualTo(5);
    }
}
