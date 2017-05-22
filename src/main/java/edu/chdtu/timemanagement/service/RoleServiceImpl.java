package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.dao.GenericDao;
import edu.chdtu.timemanagement.dao.RoleDao;
import edu.chdtu.timemanagement.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 22.05.2017.
 */
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Integer> implements RoleService {

    private RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(@Qualifier("roleDaoImpl") GenericDao<Role, Integer> genericDao) {
        super(genericDao);
        this.roleDao = (RoleDao) genericDao;
    }

}
