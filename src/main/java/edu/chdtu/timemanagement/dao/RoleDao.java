package edu.chdtu.timemanagement.dao;

import edu.chdtu.timemanagement.model.Role;

/**
 * Created by Metr_yumora on 21.05.2017.
 */
public interface RoleDao extends GenericDao<Role, Integer> {

    Role find(String name);

}
