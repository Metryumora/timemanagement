package edu.chdtu.timemanagement.dao;

import edu.chdtu.timemanagement.model.Specialist;
import edu.chdtu.timemanagement.model.User;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
public interface SpecialistDao extends GenericDao<Specialist, Integer> {

    Specialist getByUser(User user);
}
