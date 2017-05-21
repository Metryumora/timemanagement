package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.dao.GenericDao;
import edu.chdtu.timemanagement.dao.RoleDao;
import edu.chdtu.timemanagement.dao.UserDao;
import edu.chdtu.timemanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 06.12.2016.
 */

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {

    private UserDao userDao;


    private RoleDao roleDao;

    @Autowired
    public UserServiceImpl(@Qualifier("userDaoImpl") GenericDao<User, Integer> genericDao) {
        super(genericDao);
        this.userDao = (UserDao) genericDao;
    }

    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }


    @Override
    public void add(User user) {
        user.getRoles().add(roleDao.find(1));
        super.add(user);
    }
}
