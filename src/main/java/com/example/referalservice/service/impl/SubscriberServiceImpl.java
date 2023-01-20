package com.example.referalservice.service.impl;

import com.example.referalservice.dto.SubscriberDto;
import com.example.referalservice.entities.Subscriber;
import com.example.referalservice.mapper.SubscriberMapper;
import com.example.referalservice.repositories.SubscriberRepo;
import com.example.referalservice.service.SubscriberService;
import org.springframework.stereotype.Service;

@Service
public class SubscriberServiceImpl implements SubscriberService {
    private final SubscriberRepo subscriberRepo;

    public SubscriberServiceImpl(SubscriberRepo subscriberRepo) {
        this.subscriberRepo = subscriberRepo;
    }

    @Override
    public SubscriberDto getByPhone(String phone) {
        Subscriber subscriber=subscriberRepo.findByPhone(phone);
        return null;
    }

    @Override
    public SubscriberDto save(SubscriberDto subscriberDto) {
        Subscriber subscriber= SubscriberMapper.INSTANCE.toSubscriber(subscriberDto);
        subscriber= subscriberRepo.save(subscriber);
        return SubscriberMapper.INSTANCE.toSubscriberDto(subscriber);
    }
}
