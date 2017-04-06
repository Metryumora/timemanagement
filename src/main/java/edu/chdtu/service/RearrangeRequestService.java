package edu.chdtu.service;

import edu.chdtu.model.entity.RearrangeRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Metr_yumora on 29.03.2017.
 */
@Service
@Repository
@Transactional
public interface RearrangeRequestService extends GenericService<RearrangeRequest, Integer> {

    public void accept(RearrangeRequest rearrangeRequest);

    public void reject(RearrangeRequest rearrangeRequest);

}
