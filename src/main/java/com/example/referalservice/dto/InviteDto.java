package com.example.referalservice.dto;

import com.example.referalservice.entities.Subscriber;
import com.example.referalservice.entities.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class InviteDto {
    Long id;
    SubscriberDto sender;
    SubscriberDto receiver;
    Status status;
    Date startDate;
    Date endDate;
}
