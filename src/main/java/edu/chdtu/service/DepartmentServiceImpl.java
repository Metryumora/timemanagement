package edu.chdtu.service;

import edu.chdtu.dao.DepartmentDao;
import edu.chdtu.dao.GenericDao;
import edu.chdtu.model.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Service
public class DepartmentServiceImpl extends GenericServiceImpl<Department, Integer> implements DepartmentService {

    DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(@Qualifier("departmentDaoImpl") GenericDao<Department, Integer> genericDao) {
        super(genericDao);
        this.departmentDao = (DepartmentDao) genericDao;
    }
}
