package edu.chdtu.timemanagement.dao;

import edu.chdtu.timemanagement.model.RearrangeRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Metr_yumora on 29.03.2017.
 */
@Repository
@Transactional
public interface RearrangeRequestDao extends GenericDao<RearrangeRequest, Integer> {

    void accept(RearrangeRequest rearrangeRequest);

    void reject(RearrangeRequest rearrangeRequest);
}
