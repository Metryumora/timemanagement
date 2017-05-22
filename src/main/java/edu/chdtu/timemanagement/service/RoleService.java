package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Metr_yumora on 22.05.2017.
 */
@Service
@Repository
@Transactional
public interface RoleService extends GenericService<Role, Integer> {
}
