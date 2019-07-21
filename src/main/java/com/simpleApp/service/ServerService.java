package com.simpleApp.service;

import com.simpleApp.model.Servers;
import java.util.List;

public interface ServerService {
    Servers getById(Long id);

    void save(Servers servers);

    void delete(Long id);

    List<Servers> getAll();
}
