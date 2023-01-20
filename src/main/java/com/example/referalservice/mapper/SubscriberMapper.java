package com.example.referalservice.mapper;

import com.example.referalservice.dto.SubscriberDto;
import com.example.referalservice.entities.Subscriber;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubscriberMapper {
    SubscriberMapper INSTANCE= Mappers.getMapper(SubscriberMapper.class);

   default Subscriber toSubscriber(SubscriberDto subscriberDto){

       Subscriber subscriber=new Subscriber();
       subscriber.setActive(subscriberDto.getActive());
       subscriber.setCreatedDate(subscriberDto.getCreatedDate());
       subscriber.setEditDate(subscriberDto.getEditDate());
       subscriber.setId(subscriberDto.getId());
       subscriber.setPhone(subscriberDto.getPhone());
       return subscriber;
   }
   default SubscriberDto toSubscriberDto(Subscriber subscriber){
       SubscriberDto subscriberDto=new SubscriberDto();
       subscriberDto.setActive(subscriber.getActive());
       subscriberDto.setCreatedDate(subscriber.getCreatedDate());
       subscriberDto.setEditDate(subscriber.getEditDate());
       subscriberDto.setId(subscriber.getId());
       subscriberDto.setPhone(subscriber.getPhone());
       return subscriberDto;
   }
}
