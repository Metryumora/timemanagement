package edu.chdtu.service;

import edu.chdtu.dao.GenericDao;
import edu.chdtu.dao.TimetableDao;
import edu.chdtu.model.entity.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Service
public class TimetableServiceImpl extends GenericServiceImpl<Timetable, Integer> implements TimetableService {

    TimetableDao timetableDao;

    @Autowired
    public TimetableServiceImpl(@Qualifier("timetableDaoImpl") GenericDao<Timetable, Integer> genericDao) {
        super(genericDao);
        this.timetableDao = (TimetableDao) genericDao;
    }

}
