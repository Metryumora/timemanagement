package edu.chdtu.timemanagement.dao;

import edu.chdtu.timemanagement.model.Organisation;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
public interface OrganisationDao extends GenericDao<Organisation, Integer> {

    Organisation getByName(String name);

}
