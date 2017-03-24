package edu.chdtu.service;

import edu.chdtu.dao.DailyTimetableDao;
import edu.chdtu.dao.GenericDao;
import edu.chdtu.model.entity.DailyTimetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Service
public class DailyTimetableServiceImpl extends GenericServiceImpl<DailyTimetable, Integer> implements DailyTimetableService {

    DailyTimetableDao dailyTimetableDao;

    @Autowired
    public DailyTimetableServiceImpl(@Qualifier("dailyTimetableDaoImpl") GenericDao<DailyTimetable, Integer> genericDao) {
        super(genericDao);
        this.dailyTimetableDao = (DailyTimetableDao) genericDao;
    }


}
