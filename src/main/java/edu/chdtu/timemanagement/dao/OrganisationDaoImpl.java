package edu.chdtu.timemanagement.dao;

import edu.chdtu.timemanagement.model.Organisation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Repository
@Transactional
public class OrganisationDaoImpl extends GenericDaoImpl<Organisation, Integer> implements OrganisationDao {
}
