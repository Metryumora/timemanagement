package edu.chdtu.service;

import edu.chdtu.model.entity.Appointment;
import edu.chdtu.model.entity.Specialist;
import edu.chdtu.model.entity.User;
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

    public List<Appointment> get(Date date, Specialist specialist);

    public List<Appointment> get(Date date, User user);

}
