package edu.chdtu.service;

import edu.chdtu.dao.AppointmentDao;
import edu.chdtu.dao.GenericDao;
import edu.chdtu.model.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Service
public class AppointmentServiceImpl extends GenericServiceImpl<Appointment, Integer> implements AppointmentService {

    AppointmentDao appointmentDao;

    @Autowired
    public AppointmentServiceImpl(@Qualifier("appointmentDaoImpl") GenericDao<Appointment, Integer> genericDao) {
        super(genericDao);
        this.appointmentDao = (AppointmentDao) genericDao;
    }

}
