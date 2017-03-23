package edu.chdtu.service;

import edu.chdtu.dao.GenericDao;
import edu.chdtu.dao.UserDao;

import edu.chdtu.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 06.12.2016.
 */

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {


    UserDao userDao;

    @Autowired
    public UserServiceImpl(@Qualifier("userDaoImpl") GenericDao<User, Integer> genericDao) {
        super(genericDao);
        this.userDao = (UserDao) genericDao;
    }

    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }

    public Integer register(User entity) {
        return userDao.register(entity);
    }

}
