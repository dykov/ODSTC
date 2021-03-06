package com.netcracker.tc.server.spring;

import com.netcracker.tc.server.util.mail.MailManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by anla1215 on 8/21/2017.
 */
@Repository
public class Scheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(Scheduler.class);

    //@Autowired
    //MailManager mailManager;

    public Scheduler() {
    }

    @Transactional
    public void process()
    {
        System.err.println("Scheduler out");
        LOGGER.debug("Scheduler dev");
        //mailManager.processNextMail();
    }

}
