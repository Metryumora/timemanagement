package edu.chdtu.service;

import edu.chdtu.dao.GenericDao;
import edu.chdtu.dao.OrganisationDao;
import edu.chdtu.model.entity.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Service
public class OrganisationServiceImpl extends GenericServiceImpl<Organisation, Integer> implements OrganisationService {

    OrganisationDao organisationDao;

    @Autowired
    public OrganisationServiceImpl(@Qualifier("organisationDaoImpl") GenericDao<Organisation, Integer> genericDao) {
        super(genericDao);
        this.organisationDao = (OrganisationDao) genericDao;
    }

}
