package com.simpleApp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "server_table")
@Getter
@Setter
public class Servers extends BaseComponent {
    @Column(name = "name_server")
    private String nameServer;

    @Column(name = "id_application")
    private BigDecimal idApplication;

    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return "Servers [nameServer=" + nameServer + ", idApplication=" + idApplication + ", description=" + description + "]";
    }
}
