package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.model.Specialist;
import edu.chdtu.timemanagement.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Service
@Repository
@Transactional
public interface SpecialistService extends GenericService<Specialist, Integer> {

    Specialist getByUser(User user);

}
