package edu.chdtu.timemanagement.dao;

import edu.chdtu.timemanagement.model.Appointment;
import edu.chdtu.timemanagement.model.Specialist;
import edu.chdtu.timemanagement.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final DateFormat yearOnlyDateFormat = new SimpleDateFormat("yyyy");
    private final DateFormat monthOnlyDateFormat = new SimpleDateFormat("MM");
    private final DateFormat dayOnlyDateFormat = new SimpleDateFormat("dd");


    @Override
    public List<Appointment> get(Date date, Specialist specialist) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Appointment> query = cb.createQuery(Appointment.class);
        Root<Appointment> appointment = query.from(Appointment.class);
        query.select(appointment)
                .where(cb.and(cb.equal(appointment.get("specialist").get("id"), specialist.getId()),
                        cb.equal(cb.function("year", Integer.class, appointment.get("dateAndTime")), yearOnlyDateFormat.format(date)),
                        cb.equal(cb.function("month", Integer.class, appointment.get("dateAndTime")), monthOnlyDateFormat.format(date)),
                        cb.equal(cb.function("day", Integer.class, appointment.get("dateAndTime")), dayOnlyDateFormat.format(date))))
                .orderBy(cb.asc(appointment.get("dateAndTime")));
        TypedQuery<Appointment> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }


    @Override
    public List<Appointment> get(Date date, User user) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Appointment> query = cb.createQuery(Appointment.class);
        Root<Appointment> appointment = query.from(Appointment.class);
        query.select(appointment)
                .where(cb.and(cb.equal(appointment.get("client").get("id"), user.getId()),
                        cb.equal(cb.function("year", Integer.class, appointment.get("dateAndTime")), yearOnlyDateFormat.format(date)),
                        cb.equal(cb.function("month", Integer.class, appointment.get("dateAndTime")), monthOnlyDateFormat.format(date)),
                        cb.equal(cb.function("day", Integer.class, appointment.get("dateAndTime")), dayOnlyDateFormat.format(date))))
                .orderBy(cb.asc(appointment.get("dateAndTime")));
        TypedQuery<Appointment> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
