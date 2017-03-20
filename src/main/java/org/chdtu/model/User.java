package org.chdtu.model;

import org.chdtu.security.PasswordStorage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by Metr_yumora on 20.03.2017.
 */
@Entity
public class User {

    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String email;

    @Column
    private String hash;

    @Column
    private String fullName;

    public User(String email, String password, String fullName) {
        this.email = email;
        this.fullName = fullName;
        try {
            this.hash = PasswordStorage.createHash(password);
        } catch (PasswordStorage.CannotPerformOperationException e) {
            e.printStackTrace();
        }
    }

    public Boolean verifyPassword(char[] password) {
        try {
            return org.chdtu.security.PasswordStorage.verifyPassword(password, this.getHash());
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
}
