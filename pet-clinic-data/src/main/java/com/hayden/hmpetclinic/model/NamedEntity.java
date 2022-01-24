package com.hayden.hmpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class NamedEntity extends BaseEntity{

    @Column(name = "name")
    private String Name;
}
