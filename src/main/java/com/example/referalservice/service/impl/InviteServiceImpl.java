package com.example.referalservice.service.impl;

import com.example.referalservice.dto.SubscriberDto;
import com.example.referalservice.dto.request.InviteNotification;
import com.example.referalservice.entities.utils.DateTimeUtil;
import com.example.referalservice.exceptions.LimitOfInvitesExceededException;
import com.example.referalservice.mapper.SubscriberMapper;
import com.example.referalservice.repositories.InviteRepo;
import com.example.referalservice.service.InviteService;
import com.example.referalservice.dto.request.SendInvite;
import com.example.referalservice.service.SubscriberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class InviteServiceImpl implements InviteService {
    private final SubscriberService subscriberService;
    private final InviteRepo inviteRepo;
    private final DateTimeUtil dateTimeUtil;

    public InviteServiceImpl(SubscriberService subscriberService, InviteRepo inviteRepo, DateTimeUtil dateTimeUtil) {
        this.subscriberService = subscriberService;
        this.inviteRepo = inviteRepo;
        this.dateTimeUtil = dateTimeUtil;
    }

    @Override
    public ResponseEntity<?> sendInvite(SendInvite sendInvite) {
        SubscriberDto sender=subscriberService.getByPhone(sendInvite.getSenderPhone());
        boolean senderNotExist= Objects.isNull(sender);
        int countOfDailyInvites=-10;
        int countOfMonthlyInvites=0;
        if(senderNotExist){
            sender=new SubscriberDto();
            sender.setPhone(sendInvite.getSenderPhone());
            sender=subscriberService.save(sender);
        }else{

            Date startDate= dateTimeUtil.getStartOfDay();
            countOfDailyInvites=inviteRepo.countAllBySenderAndStartDateAfter(SubscriberMapper.INSTANCE.toSubscriber(sender),startDate);
            countOfDailyInvites=5;
            if(countOfDailyInvites>=5){
                throw new LimitOfInvitesExceededException("Povysheno kolichestvo priglashenii za den");
            }
            Date firstDayOfMonth=dateTimeUtil.getFirstDayOfMonth();
            countOfMonthlyInvites=inviteRepo.countAllBySenderAndStartDateAfter(SubscriberMapper.INSTANCE.toSubscriber(sender),firstDayOfMonth);

            if(countOfMonthlyInvites>=30){
                throw new LimitOfInvitesExceededException("Prevysheno kolichestvo priglashenii za den");
            }
        }
        SubscriberDto receiver=subscriberService.getByPhone(sendInvite.getReceiverPhone());
        return ResponseEntity.ok(countOfDailyInvites);
    }

    @Override
    public ResponseEntity<?> changeInviteNotification(InviteNotification inviteNotification) {
        return null;
    }

    @Override
    public ResponseEntity<?> acceptInvite(Long subscriberId) {
        return null;
    }
}
