package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.dao.GenericDao;
import edu.chdtu.timemanagement.dao.RoleDao;
import edu.chdtu.timemanagement.dao.UserDao;
import edu.chdtu.timemanagement.model.Role;
import edu.chdtu.timemanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 06.12.2016.
 */

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    public UserServiceImpl(@Qualifier("userDaoImpl") GenericDao<User, Integer> genericDao) {
        super(genericDao);
        this.userDao = (UserDao) genericDao;
    }

    public User getByLogin(String login) {
        return userDao.getByEmail(login);
    }


    @Override
    public void add(User user) {
        Role defaultRole = roleDao.find(1);
        user.getRoles().add(defaultRole);
        super.add(user);
    }
}
