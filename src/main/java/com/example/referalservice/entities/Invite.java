package com.example.referalservice.entities;

import com.example.referalservice.entities.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="invites")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Invite {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "invite-seq")
    @SequenceGenerator(name="invite-seq",sequenceName = "inviteSequence")
    Long id;

    @ManyToOne
    @JoinColumn(name="sender_id")
    Subscriber sender;

    @ManyToOne
    @JoinColumn(name="receiver_id")
    Subscriber receiver;

    @Enumerated(value = EnumType.ORDINAL)
    Status status;

    @CreationTimestamp
    Date startDate;

    Date endDate;

}
