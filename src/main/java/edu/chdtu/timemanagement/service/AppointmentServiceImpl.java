package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.dao.AppointmentDao;
import edu.chdtu.timemanagement.dao.GenericDao;
import edu.chdtu.timemanagement.model.Appointment;
import edu.chdtu.timemanagement.model.Specialist;
import edu.chdtu.timemanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Service
public class AppointmentServiceImpl extends GenericServiceImpl<Appointment, Integer> implements AppointmentService {

    private AppointmentDao appointmentDao;

    @Autowired
    public AppointmentServiceImpl(@Qualifier("appointmentDaoImpl") GenericDao<Appointment, Integer> genericDao) {
        super(genericDao);
        this.appointmentDao = (AppointmentDao) genericDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Appointment> get(Date date, Specialist specialist) {
        return appointmentDao.get(date, specialist);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Appointment> get(Date date, User user) {
        return appointmentDao.get(date, user);
    }
}
