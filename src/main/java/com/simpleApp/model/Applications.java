package com.simpleApp.model;

import javax.persistence.*;

@Entity
@Table(name = "application_table")
public class Applications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
