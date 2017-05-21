package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.dao.DailyTimetableDao;
import edu.chdtu.timemanagement.dao.GenericDao;
import edu.chdtu.timemanagement.model.DailyTimetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Service
public class DailyTimetableServiceImpl extends GenericServiceImpl<DailyTimetable, Integer> implements DailyTimetableService {

    private DailyTimetableDao dailyTimetableDao;

    @Autowired
    public DailyTimetableServiceImpl(@Qualifier("dailyTimetableDaoImpl") GenericDao<DailyTimetable, Integer> genericDao) {
        super(genericDao);
        this.dailyTimetableDao = (DailyTimetableDao) genericDao;
    }


}
