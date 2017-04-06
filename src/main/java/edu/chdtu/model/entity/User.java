package edu.chdtu.model.entity;

import edu.chdtu.security.PasswordStorage;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

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
    private String hash;

    @Column
    @NotEmpty
    private String fullName;

    @Column
    @NotEmpty
    private String phone;

    public User() {
    }

    public User(String email, String password, String fullName, String phone) {
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        try {
            this.hash = PasswordStorage.createHash(password);
        } catch (PasswordStorage.CannotPerformOperationException e) {
            e.printStackTrace();
        }
    }

    public Boolean verifyPassword(char[] password) {
        try {
            return PasswordStorage.verifyPassword(password, this.getHash());
        } catch (PasswordStorage.CannotPerformOperationException e) {
            e.printStackTrace();
        } catch (PasswordStorage.InvalidHashException hashE) {
            hashE.printStackTrace();
        }
        return false;
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
