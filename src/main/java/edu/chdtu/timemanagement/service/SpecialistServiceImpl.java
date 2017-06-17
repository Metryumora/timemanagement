package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.dao.GenericDao;
import edu.chdtu.timemanagement.dao.RoleDao;
import edu.chdtu.timemanagement.dao.SpecialistDao;
import edu.chdtu.timemanagement.model.Role;
import edu.chdtu.timemanagement.model.Specialist;
import edu.chdtu.timemanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 23.03.2017.
 */

@Service
public class SpecialistServiceImpl extends GenericServiceImpl<Specialist, Integer> implements SpecialistService {

    private SpecialistDao specialistDao;

    private RoleDao roleDao;

    @Autowired
    public SpecialistServiceImpl(@Qualifier("specialistDaoImpl") GenericDao<Specialist, Integer> genericDao) {
        super(genericDao);
        this.specialistDao = (SpecialistDao) genericDao;
    }

    @Override
    public void add(Specialist entity) {
        super.add(entity);
        entity.getUser().getRoles().add(roleDao.find("ROLE_SPECIALIST"));
    }

    @Override
    public Specialist getByUser(User user) {
        return specialistDao.getByUser(user);
    }
}
