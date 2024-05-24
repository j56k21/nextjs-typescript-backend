package com.rest.api.controller;

import com.rest.api.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@Slf4j
public class TestController {
    private final TestService service;


    @GetMapping("/push/public/key")
    public Map<String, String> getPushPublicKey(){
        Map<String, String> rtnMap = new HashMap<>();
        rtnMap.put("publicKey", service.getPushPublicKey());
        return rtnMap;
    }

    @PostMapping("/push")
    public void pushApi(){
        service.pushApi();
    }

}
