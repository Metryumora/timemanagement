package edu.chdtu.timemanagement.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Metr_yumora on 20.03.2017.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotEmpty
    private String email;

    @Column
    @NotEmpty
    private String password;

    @Transient
    private String confirmPassword;

    @Column
    @NotEmpty
    private String fullName;

    @Column
    @NotEmpty
    private String phone;

    @OneToMany(targetEntity = Appointment.class)
    @JoinColumn(name = "client_id")
    private Set<Appointment> appointments = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String email, String password, String fullName, String phone) {
        this.email = email;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        this.fullName = fullName;
        this.phone = phone;
    }

    public List<Appointment> getUnexpiredAppointments() {
        Date now = new Date();
        ArrayList<Appointment> result = new ArrayList<>();
        for (Appointment a :
                getAppointments()) {
            if (a.getDateAndTime().after(now)) {
                result.add(a);
            }
        }
        Collections.sort(result);
        return result;
    }


    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
