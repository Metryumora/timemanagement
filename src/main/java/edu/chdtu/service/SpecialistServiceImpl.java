package edu.chdtu.service;

import edu.chdtu.dao.GenericDao;
import edu.chdtu.dao.SpecialistDao;
import edu.chdtu.model.entity.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 23.03.2017.
 */

@Service
public class SpecialistServiceImpl extends GenericServiceImpl<Specialist, Integer> implements SpecialistService {

    SpecialistDao specialistDao;

    @Autowired
    public SpecialistServiceImpl(@Qualifier("specialistDaoImpl") GenericDao<Specialist, Integer> genericDao) {
        super(genericDao);
        this.specialistDao = (SpecialistDao) genericDao;
    }

}
