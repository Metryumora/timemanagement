package edu.chdtu.dao;

import edu.chdtu.model.entity.Appointment;
import edu.chdtu.model.entity.Specialist;
import edu.chdtu.model.entity.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Metr_yumora on 23.03.2017.
 */


public interface AppointmentDao extends GenericDao<Appointment,Integer> {

    public List<Appointment> get(Date date, Specialist specialist);

    public List<Appointment> get(Date date, User user);

}
