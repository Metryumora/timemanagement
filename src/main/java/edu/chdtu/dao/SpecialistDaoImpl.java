package edu.chdtu.dao;

import edu.chdtu.model.entity.Specialist;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Repository
@Transactional
public class SpecialistDaoImpl extends GenericDaoImpl<Specialist, Integer> implements SpecialistDao {
}
