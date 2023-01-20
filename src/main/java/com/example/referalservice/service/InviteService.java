package com.example.referalservice.service;

import com.example.referalservice.dto.request.InviteNotification;
import com.example.referalservice.dto.request.SendInvite;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface InviteService {
    ResponseEntity<?> sendInvite(SendInvite sendInvite);

    ResponseEntity<?> changeInviteNotification(InviteNotification inviteNotification);

    ResponseEntity<?> acceptInvite(Long subscriberId);
}
