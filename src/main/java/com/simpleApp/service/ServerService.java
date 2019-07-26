package com.simpleApp.service;

import com.simpleApp.model.Servers;
import com.simpleApp.model.ServersForm;

import java.util.List;

public interface ServerService {
    Servers getById(Long id);

    Servers saveOrUpdate(Servers servers);

    Servers saveOrUpdateServersForm(ServersForm serversForm);

    void delete(Long id);

    List<Servers> getAll();
}
