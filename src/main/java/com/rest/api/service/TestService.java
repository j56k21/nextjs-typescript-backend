package com.rest.api.service;

import com.rest.api.application.MessageEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final MessageEndpoint messageEndpoint;

    public void pushApi() {
        messageEndpoint.getPublicKey();

    }

    public String getPushPublicKey() {
        return messageEndpoint.getPublicKey();
    }
}
