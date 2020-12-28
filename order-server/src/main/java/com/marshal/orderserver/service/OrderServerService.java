package com.marshal.orderserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServerService {
    @Autowired
    RestTemplate restTemplate;

    public String getUder(int id) {
        String url = "http://user-server/user/{id}";
        String info = restTemplate.getForObject(url, String.class, id);
        return info;
    }
}
