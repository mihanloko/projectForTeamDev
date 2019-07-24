package com.simpleApp.convert;

import com.simpleApp.model.Servers;
import com.simpleApp.model.ServersForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ServerFormToServer implements Converter<ServersForm, Servers> {

    @Override
    public Servers convert(ServersForm serversForm) {
        Servers servers = new Servers();
        if (serversForm.getId() != null  && !StringUtils.isEmpty(serversForm.getId())) {
            servers.setId(new Long(serversForm.getId()));
        }
        servers.setDescription(serversForm.getDescription());
        servers.setIdApplication(serversForm.getIdApplication());
        servers.setNameServer(serversForm.getNameServer());
        return servers;
    }
}
