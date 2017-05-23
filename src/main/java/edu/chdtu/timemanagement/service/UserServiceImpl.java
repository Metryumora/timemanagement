package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.dao.GenericDao;
import edu.chdtu.timemanagement.dao.RoleDao;
import edu.chdtu.timemanagement.dao.UserDao;
import edu.chdtu.timemanagement.model.Role;
import edu.chdtu.timemanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Metr_yumora on 06.12.2016.
 */

@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(@Qualifier("userDaoImpl") GenericDao<User, Integer> genericDao) {
        super(genericDao);
        this.userDao = (UserDao) genericDao;
    }

    @Transactional(readOnly = true)
    public User getByEmail(String login) {
        try {
            return userDao.getByEmail(login);
        } catch (UsernameNotFoundException e) {

        }
        return null;
    }


    @Override
    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role defaultRole = roleDao.find(1);
        user.getRoles().add(defaultRole);
        super.add(user);
    }
}
