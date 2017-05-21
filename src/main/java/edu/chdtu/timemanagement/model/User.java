package edu.chdtu.timemanagement.model;

import edu.chdtu.timemanagement.security.PasswordStorage;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private String passwordHash;

    @Column
    @NotEmpty
    private String fullName;

    @Column
    @NotEmpty
    private String phone;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String email, String password, String fullName, String phone) {
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        try {
            this.passwordHash = PasswordStorage.createHash(password);
        } catch (PasswordStorage.CannotPerformOperationException e) {
            e.printStackTrace();
        }
    }

    public User(String email, String password, String fullName, String phone, Set<Role> roles) {
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        try {
            this.passwordHash = PasswordStorage.createHash(password);
        } catch (PasswordStorage.CannotPerformOperationException e) {
            e.printStackTrace();
        }
        this.roles.addAll(roles);
    }

    public Boolean verifyPassword(char[] password) {
        try {
            return PasswordStorage.verifyPassword(password, this.getPasswordHash());
        } catch (PasswordStorage.CannotPerformOperationException | PasswordStorage.InvalidHashException e) {

            e.printStackTrace();
        }
        return false;
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
