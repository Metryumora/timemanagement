package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.dao.GenericDao;
import edu.chdtu.timemanagement.dao.RearrangeRequestDao;
import edu.chdtu.timemanagement.model.RearrangeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Metr_yumora on 29.03.2017.
 */
@Service
public class RearrangeRequestServiceImpl extends GenericServiceImpl<RearrangeRequest, Integer> implements RearrangeRequestService {

    private RearrangeRequestDao rearrangeRequestDao;

    @Autowired
    public RearrangeRequestServiceImpl(@Qualifier("rearrangeRequestDaoImpl") GenericDao<RearrangeRequest, Integer> genericDao) {
        super(genericDao);
        this.rearrangeRequestDao = (RearrangeRequestDao) genericDao;
    }

    @Transactional
    public void accept(RearrangeRequest rearrangeRequest) {
        rearrangeRequestDao.accept(rearrangeRequest);
    }

    @Transactional
    public void reject(RearrangeRequest rearrangeRequest) {
        rearrangeRequestDao.reject(rearrangeRequest);
    }

}
