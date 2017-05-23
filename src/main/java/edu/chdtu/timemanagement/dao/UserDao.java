package edu.chdtu.timemanagement.dao;

import edu.chdtu.timemanagement.model.User;

/**
 * Created by Metr_yumora on 06.12.2016.
 */

public interface UserDao extends GenericDao<User, Integer> {

    User getByEmail(String email);

}
