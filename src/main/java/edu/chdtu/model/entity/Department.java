package edu.chdtu.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Metr_yumora on 22.03.2017.
 */
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotEmpty
    private String name;

    @ManyToOne(targetEntity = Organisation.class)
    private Organisation organisation;

    @OneToMany(targetEntity = Specialist.class)
    @JoinColumn(name = "department_id")
    private Set<Specialist> specialists = new HashSet<>();

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

    public Set<Specialist> getSpecialists() {
        return specialists;
    }

    public void setSpecialists(Set<Specialist> specialists) {
        this.specialists = specialists;
    }

    public Department() {
    }

    public Department(String name, Organisation organisation) {
        this.name = name;
        this.organisation = organisation;
    }
}
