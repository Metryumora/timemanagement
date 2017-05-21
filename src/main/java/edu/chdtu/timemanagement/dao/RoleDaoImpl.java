package edu.chdtu.timemanagement.dao;

import edu.chdtu.timemanagement.model.Role;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Metr_yumora on 21.05.2017.
 */
@Repository
@Transactional
public class RoleDaoImpl extends GenericDaoImpl<Role, Integer> implements RoleDao{
}
