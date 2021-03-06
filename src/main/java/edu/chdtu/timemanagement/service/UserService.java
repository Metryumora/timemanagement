package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by Metr_yumora on 06.12.2016.
 */
@Service
@Repository
public interface UserService extends GenericService<User, Integer> {

    User getByEmail(String login);
}