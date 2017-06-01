package edu.chdtu.timemanagement.dao;

import edu.chdtu.timemanagement.model.Organisation;
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
 * Created by Metr_yumora on 23.03.2017.
 */
@Repository
@Transactional
public class OrganisationDaoImpl extends GenericDaoImpl<Organisation, Integer> implements OrganisationDao {

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    @Transactional(noRollbackFor = Exception.class, readOnly = true)
    public Organisation getByName(String name) {
        String fieldName = "name";

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Organisation> query = cb.createQuery(Organisation.class);
        Root<Organisation> organisationRoot = query.from(Organisation.class);
        query.select(organisationRoot).where(cb.equal(organisationRoot.get(fieldName), name));
        TypedQuery<Organisation> typedQuery = entityManager.createQuery(query);
        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            String message = "Could not find " + getDaoType().getSimpleName() + " with " + fieldName + " %s";
            logger.debug(String.format(message, name));
            throw new UsernameNotFoundException(String.format(message, name));
        }
    }
}
