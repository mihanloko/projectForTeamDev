package com.simpleApp.service;

import com.simpleApp.model.Servers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simpleApp.repository.ServerRepository;

import java.util.List;

@Service
public class ServerServiceImp implements ServerService  {

    private static Logger logger = LoggerFactory.getLogger(ServerServiceImp.class);

    @Autowired
    ServerRepository serverRepository;
    @Override
    public Servers getById(Long id) {
        logger.info("IN ServersServiceImpl getById {}", id);
        return serverRepository.findOne(id);
    }

    @Override
    public void save(Servers servers) {
        logger.info("IN ServersServiceImpl save {}", servers);
        serverRepository.save(servers);
    }

    @Override
    public void delete(Long id) {
        logger.info("IN ServersServiceImpl delete {}", id);
        serverRepository.delete(id);
    }

    @Override
    public List<Servers> getAll() {
        logger.info("IN ServersServiceImpl getAll");
        return serverRepository.findAll();
    }
}
