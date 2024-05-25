package com.rest.api.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import nl.martijndwars.webpush.Notification;
import nl.martijndwars.webpush.PushService;
import nl.martijndwars.webpush.Subscription;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {

    @Getter
    @Value("${push.public.key}")
    private String publicKey;

    @Value("${push.private.key}")
    private String privateKey;

    private PushService pushService;
    private List<Subscription> subscriptions = new ArrayList<>();


    @PostConstruct
    public void init() throws GeneralSecurityException {
        Security.addProvider(new BouncyCastleProvider());
        pushService = new PushService(publicKey, privateKey);
    }

    public void subscribe(Subscription subscription) {
        this.subscriptions.add(subscription);
    }

    public void unsubscribe(String endpoint) {
        subscriptions = subscriptions.stream().filter(s -> !endpoint.equals(s.endpoint))
                .collect(Collectors.toList());
    }

    public void sendNotification(Subscription subscription, String messageJson) {
        try {
            pushService.send(new Notification(subscription, messageJson));
        } catch (GeneralSecurityException | IOException | JoseException | ExecutionException
                 | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedRate = 15000)
    public void sendNotifications(Map<String, String> paramMap) {
        var json = """
        {
          "title": "%s",
          "body": "%s - %s"
        }
        """;

        subscriptions.forEach(subscription -> {
            sendNotification(subscription, String.format(json
                    , paramMap.get("title")
                    , paramMap.get("message")
                    , LocalTime.now()));
        });
    }
}