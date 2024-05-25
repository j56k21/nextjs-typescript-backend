package com.rest.api.controller;

import com.rest.api.service.PushService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.martijndwars.webpush.Subscription;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/push")
@Slf4j
public class PushController {
    private final PushService service;


    @GetMapping("/public/key")
    public Map<String, String> getPushPublicKey(){
        Map<String, String> rtnMap = new HashMap<>();
        rtnMap.put("publicKey", service.getPushPublicKey());
        return rtnMap;
    }

    @PostMapping("/send")
    public void pushApi(@RequestBody Map<String, String> paramMap){
        service.sendNotifications(paramMap);
    }

    @PostMapping("/subscription")
    public void subscribe(@RequestBody Map<String, Subscription> subscribe){
        service.subscribe(subscribe.get("data"));
    }

    @PostMapping("/unsubscription")
    public void unsubscribe(@RequestBody Map<String, String> subscribe){
        service.unsubscribe(subscribe.get("data"));
    }
}
