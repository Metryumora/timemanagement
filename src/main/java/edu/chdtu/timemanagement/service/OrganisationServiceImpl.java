package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.dao.GenericDao;
import edu.chdtu.timemanagement.dao.OrganisationDao;
import edu.chdtu.timemanagement.model.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Service
public class OrganisationServiceImpl extends GenericServiceImpl<Organisation, Integer> implements OrganisationService {

    private OrganisationDao organisationDao;

    @Autowired
    public OrganisationServiceImpl(@Qualifier("organisationDaoImpl") GenericDao<Organisation, Integer> genericDao) {
        super(genericDao);
        this.organisationDao = (OrganisationDao) genericDao;
    }

    @Override
    public Organisation getByName(String name) {
        return organisationDao.getByName(name);
    }
}
