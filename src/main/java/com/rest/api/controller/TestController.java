package com.rest.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping(value = "/test")
    public List<Map<String, Object>> test(){
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("1", "2");
        map.put("2", "2");
        map.put("3", "2");
        map.put("4", "2");
        map.put("5", "2");
        map.put("6", "2");
        map.put("7", "2");
        map.put("8", "2");
        map.put("9", "2");
        map.put("10", "2");
        map.put("11", "2");
        map.put("12", "2");
        map.put("13", "2");
        map.put("14", "2");
        map.put("15", "2");
        map.put("16", "2");
        map.put("17", "2");
        list.add(map);
        System.out.println("ㅒㅒㅒㅒㅒㅒㅒㅒㅒㅒㅒㅒㅒㅒㅒㅒㅒ");
        return list;
    }

    @GetMapping(value = "/")
    public void test1(){
        System.out.println("11111111111111111111111111111");
        System.out.println("11111111111111111111111111111");
        System.out.println("11111111111111111111111111111");
        System.out.println("11111111111111111111111111111");
        System.out.println("11111111111111111111111111111");
        System.out.println("11111111111111111111111111111");
        System.out.println("11111111111111111111111111111");
    }
}
