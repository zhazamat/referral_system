package com.example.referalservice.repositories;

import com.example.referalservice.entities.Invite;
import com.example.referalservice.entities.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface InviteRepo extends JpaRepository<Invite,Long> {

    int countAllBySenderAndStartDateAfter(Subscriber toSubscriber, Date startDate);
}
