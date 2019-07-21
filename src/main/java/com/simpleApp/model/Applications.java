package com.simpleApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "application_table")
@Getter
@Setter
public class Applications extends BaseComponent {
    @Column(name = "name_application")
    private String nameApplication;

    @Column(name = "previous_Application")
    private String previousApplication;

    @Column(name = "next_Application")
    private String nextApplication;

    @Override
    public String toString() {
        return "Applications [nameApplication=" + nameApplication + ", previousApplication=" + previousApplication + ", nextApplication=" + nextApplication + "]";
    }
}
