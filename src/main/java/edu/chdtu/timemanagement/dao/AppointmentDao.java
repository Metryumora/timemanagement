package edu.chdtu.timemanagement.dao;

import edu.chdtu.timemanagement.model.Appointment;
import edu.chdtu.timemanagement.model.Specialist;
import edu.chdtu.timemanagement.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Metr_yumora on 23.03.2017.
 */


public interface AppointmentDao extends GenericDao<Appointment, Integer> {

    List<Appointment> get(Date date, Specialist specialist);

    List<Appointment> get(Date date, User user);

}
