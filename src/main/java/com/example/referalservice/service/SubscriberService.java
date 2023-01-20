package com.example.referalservice.service;

import com.example.referalservice.dto.SubscriberDto;
import org.springframework.stereotype.Service;

@Service
public interface SubscriberService {
    SubscriberDto getByPhone(String phone);

    SubscriberDto save(SubscriberDto sender);
}
