package com.example.referalservice.mapper;

import com.example.referalservice.dto.InviteDto;
import com.example.referalservice.entities.Invite;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InviteMapper {
    InviteMapper INSTANCE= Mappers.getMapper(InviteMapper.class);

   default Invite toInvite(InviteDto inviteDto){
       Invite invite=new Invite();
       invite.setId(inviteDto.getId());
       invite.setEndDate(inviteDto.getEndDate());
       invite.setStartDate(inviteDto.getStartDate());
       invite.setStatus(inviteDto.getStatus());
       invite.setReceiver(SubscriberMapper.INSTANCE.toSubscriber(inviteDto.getReceiver()));
       invite.setSender(SubscriberMapper.INSTANCE.toSubscriber(inviteDto.getSender()));
       return invite;
   }
   default InviteDto toInviteDto(Invite invite) {
       InviteDto inviteDto=new InviteDto();
       inviteDto.setId(invite.getId());
       inviteDto.setStatus(invite.getStatus());
       inviteDto.setEndDate(invite.getEndDate());
       inviteDto.setStartDate(invite.getStartDate());
       inviteDto.setReceiver(SubscriberMapper.INSTANCE.toSubscriberDto(invite.getReceiver()));
       inviteDto.setSender(SubscriberMapper.INSTANCE.toSubscriberDto(invite.getSender()));
       return inviteDto;
   }


}
