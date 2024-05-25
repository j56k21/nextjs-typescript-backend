package com.rest.api.service;

import com.rest.api.application.MessageEndpoint;
import lombok.RequiredArgsConstructor;
import nl.martijndwars.webpush.Subscription;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PushService {

    private final MessageEndpoint messageEndpoint;

    public void pushApi() {
//        messageEndpoint.subscribe();
    }

    public String getPushPublicKey() {
        return messageEndpoint.getPublicKey();
    }

    public void subscribe(Subscription subscribe) {
        messageEndpoint.subscribe(subscribe);
    }
    public void unsubscribe(String subscribe) {
        messageEndpoint.unsubscribe(subscribe);
    }

    public void sendNotifications(Map<String, String> paramMap){
        messageEndpoint.sendNotifications(paramMap);
    }

}
