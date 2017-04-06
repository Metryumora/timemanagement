package edu.chdtu.dao;

import edu.chdtu.model.entity.RearrangeRequest;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Metr_yumora on 29.03.2017.
 */
@Repository
@Transactional
public class RearrangeRequestDaoImpl extends GenericDaoImpl<RearrangeRequest, Integer> implements RearrangeRequestDao {

    @Override
    public void accept(RearrangeRequest rearrangeRequest) {
        rearrangeRequest.getAppointment().setDateAndTime(rearrangeRequest.getNewTime());
        rearrangeRequest.setStatus(true);
    }

    @Override
    public void reject(RearrangeRequest rearrangeRequest) {
        rearrangeRequest.setStatus(false);
    }
}
