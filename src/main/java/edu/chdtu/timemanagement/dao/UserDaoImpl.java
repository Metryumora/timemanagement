package edu.chdtu.timemanagement.dao;


import edu.chdtu.timemanagement.model.User;
import edu.chdtu.timemanagement.service.SecurityServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;



/**
 * Created by Metr_yumora on 06.12.2016.
 */

@Repository
@Transactional
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    @Transactional(noRollbackFor = Exception.class)
    public User getByEmail(String login) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);
        query.select(user).where(cb.like(user.get("email"), login));
        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            logger.debug(String.format("Could not find user with email %s", login));
            throw new UsernameNotFoundException(String.format("Could not find user with email %s", login));
        }
    }
}
