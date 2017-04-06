package edu.chdtu.service;

import edu.chdtu.dao.GenericDao;
import edu.chdtu.dao.UnregisteredAppointmentDao;
import edu.chdtu.model.entity.UnregisteredAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 30.03.2017.
 */
@Service
public class UnregisteredAppointmentServiceImpl extends GenericServiceImpl<UnregisteredAppointment, Integer> implements UnregisteredAppointmentService {

    UnregisteredAppointmentDao unregisteredAppointmentDao;

    @Autowired
    public UnregisteredAppointmentServiceImpl(@Qualifier("unregisteredAppointmentDaoImpl") GenericDao<UnregisteredAppointment, Integer> genericDao) {
        super(genericDao);
        this.unregisteredAppointmentDao = (UnregisteredAppointmentDao) genericDao;
    }
}
