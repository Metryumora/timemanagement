package edu.chdtu.dao;

import edu.chdtu.model.entity.Appointment;
import edu.chdtu.model.entity.Specialist;
import edu.chdtu.model.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Repository
@Transactional
public class AppointmentDaoImpl extends GenericDaoImpl<Appointment, Integer> implements AppointmentDao {

    private DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<Appointment> get(Date date, Specialist specialist) {
        TypedQuery<Appointment> query = entityManager.createQuery("FROM edu.chdtu.model.entity.Appointment a " +
                        "where a.specialist.id = " + specialist.getId() +
                        "and date(a.dateAndTime) = '" + dateFormat.format(date) + "' order by a.dateAndTime ASC",
                Appointment.class);
        return query.getResultList();
    }

    @Override
    public List<Appointment> get(Date date, User user) {
        TypedQuery<Appointment> query = entityManager.createQuery("FROM edu.chdtu.model.entity.Appointment a " +
                        "where a.client.id = " + user.getId() +
                        "and date(a.dateAndTime) = '" + dateFormat.format(date) + "'",
                Appointment.class);
        return query.getResultList();
    }
}
