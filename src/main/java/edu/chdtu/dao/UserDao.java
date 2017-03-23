package edu.chdtu.dao;

import edu.chdtu.model.entity.User;

/**
 * Created by Metr_yumora on 06.12.2016.
 */

public interface UserDao extends GenericDao<User, Integer> {

    public User getByLogin(String login);

    public Integer register(User entity);

}
