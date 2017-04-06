package edu.chdtu.dao;

import edu.chdtu.model.entity.RearrangeRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Metr_yumora on 29.03.2017.
 */
@Repository
@Transactional
public interface RearrangeRequestDao extends GenericDao<RearrangeRequest, Integer> {

    public void accept(RearrangeRequest rearrangeRequest);

    public void reject(RearrangeRequest rearrangeRequest);
}
