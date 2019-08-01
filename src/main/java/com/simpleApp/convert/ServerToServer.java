package com.simpleApp.convert;

import com.simpleApp.model.Servers;
import com.simpleApp.model.ServersForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ServerToServer implements Converter<Servers, ServersForm> {
    @Override
    public ServersForm convert(Servers servers) {
        ServersForm serversForm = new ServersForm();
        serversForm.setId(servers.getId());
        serversForm.setNameServer(servers.getNameServer());
        serversForm.setIdApplication(servers.getIdApplication());
        serversForm.setDescription(servers.getDescription());
        return serversForm;
    }
}
