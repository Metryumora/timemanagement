package edu.chdtu.model.entity;

import javax.persistence.*;

/**
 * Created by Metr_yumora on 22.03.2017.
 */
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @ManyToOne(targetEntity = Organisation.class)
    private Organisation organisation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Department() {
    }

    public Department(String name, Organisation organisation) {
        this.name = name;
        this.organisation = organisation;
    }
}
