package com.example.referalservice.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.boot.model.relational.Database;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="subscribers")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "invite-seq")
    @SequenceGenerator(name="invite-seq",sequenceName = "inviteSequence")
    Long id;

    String phone;

    Boolean active;

    @CreationTimestamp
    Date createdDate;

    @UpdateTimestamp
    Date editDate;
}
