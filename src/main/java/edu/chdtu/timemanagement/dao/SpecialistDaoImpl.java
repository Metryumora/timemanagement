package edu.chdtu.timemanagement.dao;

import edu.chdtu.timemanagement.model.Specialist;
import edu.chdtu.timemanagement.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

/**
 * Created by Metr_yumora on 23.03.2017.
 */

@Repository
@Transactional
public class SpecialistDaoImpl extends GenericDaoImpl<Specialist, Integer> implements SpecialistDao {

    @Override
    public Specialist getByUser(User user) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Specialist> query = cb.createQuery(Specialist.class);
        Root<Specialist> specialist = query.from(Specialist.class);
        query.select(specialist).where(cb.equal(specialist.<User>get("user").<Integer>get("id"), user.getId()));
        TypedQuery<Specialist> typedQuery = entityManager.createQuery(query);
        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return null;
    }
}
