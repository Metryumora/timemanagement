package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.dao.DepartmentDao;
import edu.chdtu.timemanagement.dao.GenericDao;
import edu.chdtu.timemanagement.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Service
public class DepartmentServiceImpl extends GenericServiceImpl<Department, Integer> implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(@Qualifier("departmentDaoImpl") GenericDao<Department, Integer> genericDao) {
        super(genericDao);
        this.departmentDao = (DepartmentDao) genericDao;
    }
}
