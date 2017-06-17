package edu.chdtu.timemanagement.dao;

import edu.chdtu.timemanagement.model.Role;
import edu.chdtu.timemanagement.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

/**
 * Created by Metr_yumora on 21.05.2017.
 */
@Repository
@Transactional
public class RoleDaoImpl extends GenericDaoImpl<Role, Integer> implements RoleDao {

    @Override
    public Role find(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> query = cb.createQuery(Role.class);
        Root<Role> role = query.from(Role.class);
        query.select(role).where(cb.equal(role.get("name"), name));
        TypedQuery<Role> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }
}
