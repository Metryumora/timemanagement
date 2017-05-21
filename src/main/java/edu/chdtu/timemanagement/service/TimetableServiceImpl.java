package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.dao.GenericDao;
import edu.chdtu.timemanagement.dao.TimetableDao;
import edu.chdtu.timemanagement.model.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Service
public class TimetableServiceImpl extends GenericServiceImpl<Timetable, Integer> implements TimetableService {

    private TimetableDao timetableDao;

    @Autowired
    public TimetableServiceImpl(@Qualifier("timetableDaoImpl") GenericDao<Timetable, Integer> genericDao) {
        super(genericDao);
        this.timetableDao = (TimetableDao) genericDao;
    }

}
