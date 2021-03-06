package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.model.Organisation;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Service
@Repository
@Transactional
public interface OrganisationService extends GenericService<Organisation, Integer> {

    Organisation getByName(String name);

}
