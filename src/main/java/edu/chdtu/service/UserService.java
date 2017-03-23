package edu.chdtu.service;

import edu.chdtu.model.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Metr_yumora on 06.12.2016.
 */
@Service
@Repository
@Transactional
public interface UserService extends GenericService<User, Integer> {

    public User getByLogin(String login);

    public Integer register(User entity);
}