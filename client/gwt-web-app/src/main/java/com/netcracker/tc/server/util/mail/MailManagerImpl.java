package com.netcracker.tc.server.util.mail;

import com.netcracker.tc.server.persistence.dao.api.MailQueueDao;
import com.netcracker.tc.server.persistence.model.mail.MailQueue;
import com.netcracker.tc.server.service.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Calendar;

//@Component
public class MailManagerImpl implements MailManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailManagerImpl.class);

    @Autowired
    MailQueueDao mailQueue;
    @Autowired
    UserService userService;
    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void addMailInQueue(Mail mail) {
        MailQueue mq = new MailQueue();
        mq.setReceiverAddress(mail.getReceiverAddresses());
        mq.setAddedWhen(Calendar.getInstance().getTime());
        mq.setMessageSubject(mail.getMessageSubject());
        mq.setMessageBody(mail.getMessageBody());
        mq.setIsSent(false);
        mq.setIsIncorrectMail(false);

        mailQueue.create(mq);
    }

    @Override
    public void processNextMail() {
        LOGGER.debug("processNextMail mail");

        MailQueue mq = mailQueue.getNextMail();
        if (mq != null)
            try {

                String msgSubject = mq.getMessageSubject();
                String msgBody = mq.getMessageBody();

                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(mq.getReceiverAddress());
                message.setSubject(msgSubject);
                message.setText(msgBody);
                message.setFrom("survey1_mail@netcracker.com");
                javaMailSender.send(message);

                mq.setIsSent(true);
                mailQueue.update(mq);
            } catch (Exception e) {
                mq.setIsIncorrectMail(true);
                mailQueue.update(mq);
                LOGGER.debug("mail "+ e.getMessage() + " " + e.toString());
            }
    }

    @Override
    public int processedMails() {
        return mailQueue.getProcessedMails();
    }

    @Override
    public int waitingMails() {
        return mailQueue.getWaitingMails();
    }


}
