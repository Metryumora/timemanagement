package edu.chdtu.timemanagement.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Metr_yumora on 21.05.2017.
 */
@Service
@Repository
@Transactional
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
