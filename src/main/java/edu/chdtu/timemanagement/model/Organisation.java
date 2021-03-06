package edu.chdtu.timemanagement.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Metr_yumora on 20.03.2017.
 */
@Entity
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column
    private String name;

    @NotEmpty
    @Column
    private String address;

    @ManyToOne(targetEntity = User.class)
    private User admin;

    @OneToMany(targetEntity = Department.class)
    @JoinColumn(name = "organisation_id")
    private Set<Department> departments = new HashSet<>();

    public Organisation() {
    }

    public Organisation(String name, String address, User admin) {
        this.name = name;
        this.address = address;
        this.admin = admin;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}
