package com.simpleApp.model;

import java.math.BigDecimal;

public class ServersForm {
    private Long id;
    private String nameServer;
    private BigDecimal idApplication;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(BigDecimal idApplication) {
        this.idApplication = idApplication;
    }

    public String getNameServer() {
        return nameServer;
    }

    public void setNameServer(String nameServer) {
        this.nameServer = nameServer;
    }

}
