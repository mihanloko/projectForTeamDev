package com.simpleApp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
