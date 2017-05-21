package edu.chdtu.timemanagement.dao;

import edu.chdtu.timemanagement.model.DailyTimetable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Repository
@Transactional
public class DailyTimetableDaoImpl extends GenericDaoImpl<DailyTimetable, Integer> implements DailyTimetableDao {
}
