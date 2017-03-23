package edu.chdtu.dao;


import edu.chdtu.model.entity.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


/**
 * Created by Metr_yumora on 06.12.2016.
 */

@Repository
@Transactional
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

    public User getByLogin(String login) {
        return (User) currentSession().createCriteria(User.class).add(Restrictions.like("login", login)).uniqueResult();
    }

    @Override
    public Integer register(User entity) {
        super.add(entity);
        Integer newUserId = ((User) currentSession().createCriteria(User.class)
                .add(Restrictions.eq("email", entity.getEmail()))
                .uniqueResult())
                .getId();
        return newUserId;
    }
}
