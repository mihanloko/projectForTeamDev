package com.simpleApp.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "server_table")
public class Servers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_server")
    private String nameServer;

    @Column(name = "id_application")
    private BigDecimal idApplication;

    @Column(name = "description")
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

    @Override
    public String toString() {
        return "Servers [nameServer=" + nameServer + ", idApplication=" + idApplication + ", description=" + description + "]";
    }
}
