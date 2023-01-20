package com.example.referalservice.controllers;

import com.example.referalservice.dto.request.InviteNotification;
import com.example.referalservice.service.InviteService;
import com.example.referalservice.dto.request.SendInvite;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/invite")
public class InviteController {
    private final InviteService inviteService;

    public InviteController(InviteService inviteService) {
        this.inviteService = inviteService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendInvite(@RequestBody SendInvite sendInvite){
    return  inviteService.sendInvite(sendInvite);
    }

    @PutMapping("/notification")
    public ResponseEntity<?>changeNotificationEnable(@RequestBody InviteNotification inviteNotification){
        return inviteService.changeInviteNotification(inviteNotification);

    }
    @GetMapping("/accept")
    public ResponseEntity<?> acceptInvite(@RequestParam Long subscriberId){
        return  inviteService.acceptInvite(subscriberId);
    }
}
