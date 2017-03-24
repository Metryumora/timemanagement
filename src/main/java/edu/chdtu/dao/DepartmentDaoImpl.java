package edu.chdtu.dao;

import edu.chdtu.model.entity.Department;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Repository
@Transactional
public class DepartmentDaoImpl extends GenericDaoImpl<Department, Integer> implements DepartmentDao {
}
