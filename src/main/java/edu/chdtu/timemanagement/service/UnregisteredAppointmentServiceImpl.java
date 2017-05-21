package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.dao.GenericDao;
import edu.chdtu.timemanagement.dao.UnregisteredAppointmentDao;
import edu.chdtu.timemanagement.model.UnregisteredAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 30.03.2017.
 */
@Service
public class UnregisteredAppointmentServiceImpl extends GenericServiceImpl<UnregisteredAppointment, Integer> implements UnregisteredAppointmentService {

    private UnregisteredAppointmentDao unregisteredAppointmentDao;

    @Autowired
    public UnregisteredAppointmentServiceImpl(@Qualifier("unregisteredAppointmentDaoImpl") GenericDao<UnregisteredAppointment, Integer> genericDao) {
        super(genericDao);
        this.unregisteredAppointmentDao = (UnregisteredAppointmentDao) genericDao;
    }
}
