package com.example.lee.ribbonconsumer.controller;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Lee
 * @CreateDate: 2019-03-15
 */
@RestController
@RequestMapping
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getHelloService")
    public String helloService(){
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }

}
