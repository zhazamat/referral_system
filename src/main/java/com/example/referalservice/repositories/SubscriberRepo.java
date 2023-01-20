package com.example.referalservice.repositories;

import com.example.referalservice.entities.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepo extends JpaRepository<Subscriber,Long> {

    Subscriber findByPhone(String phone);
}
