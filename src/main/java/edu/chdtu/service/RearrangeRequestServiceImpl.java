package edu.chdtu.service;

import edu.chdtu.dao.GenericDao;
import edu.chdtu.dao.RearrangeRequestDao;
import edu.chdtu.model.entity.RearrangeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Metr_yumora on 29.03.2017.
 */
@Service
public class RearrangeRequestServiceImpl extends GenericServiceImpl<RearrangeRequest, Integer> implements RearrangeRequestService {

    RearrangeRequestDao rearrangeRequestDao;

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
