package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.model.Appointment;
import edu.chdtu.timemanagement.model.Specialist;
import edu.chdtu.timemanagement.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Service
@Repository
@Transactional
public interface AppointmentService extends GenericService<Appointment, Integer> {

    List<Appointment> get(Date date, Specialist specialist);

    List<Appointment> get(Date date, User user);

}
