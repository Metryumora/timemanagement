package edu.chdtu.timemanagement.service;

import edu.chdtu.timemanagement.model.RearrangeRequest;
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

    void accept(RearrangeRequest rearrangeRequest);

    void reject(RearrangeRequest rearrangeRequest);

}
