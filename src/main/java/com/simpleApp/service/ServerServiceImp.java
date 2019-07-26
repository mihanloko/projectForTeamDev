package com.simpleApp.service;

import com.simpleApp.convert.ServerFormToServer;
import com.simpleApp.model.Servers;
import com.simpleApp.model.ServersForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simpleApp.repository.ServerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServerServiceImp implements ServerService  {

    private static Logger logger = LoggerFactory.getLogger(ServerServiceImp.class);
    private ServerRepository serverRepository;
    private ServerFormToServer serverFormToServer;

    @Autowired
    public ServerServiceImp(ServerRepository serverRepository, ServerFormToServer serverFormToServer) {
        this.serverRepository = serverRepository;
        this.serverFormToServer = serverFormToServer;
    }

    @Override
    public Servers getById(Long id) {
        logger.info("IN ServersServiceImpl getById {}", id);
        return serverRepository.findOne(id);
    }

    @Override
    public Servers saveOrUpdate(Servers servers) {
        logger.info("IN ServersServiceImpl save {}", servers);
        serverRepository.save(servers);
        return servers;
    }

    @Override
    public Servers saveOrUpdateServersForm(ServersForm serversForm) {
        Servers savedServers = saveOrUpdate(serverFormToServer.convert(serversForm));
        logger.info("Saved servers id = ???"); // ToDo
        return savedServers;
    }

    @Override
    public void delete(Long id) {
        logger.info("IN ServersServiceImpl delete {}", id);
        serverRepository.delete(id);
    }

    @Override
    public List<Servers> getAll() {
        //logger.info("IN ServersServiceImpl getAll");
        //return serverRepository.findAll();
        List<Servers> servers = new ArrayList<>();
        serverRepository.findAll().forEach(servers::add);
        return servers;
    }
}
