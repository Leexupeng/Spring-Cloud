package com.example.lee.helloservice.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Lee
 * @CreateDate: 2019-03-15
 */
@RestController
@RequestMapping
@Log4j2
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("hello")
    public String index() {
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            log.info("!"+service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for(ServiceInstance serviceInstance : instances){
                log.info(serviceInstance);
                log.info(String.format("/hello/hello, host:%s, service_id:%s", serviceInstance.getHost(),
                        serviceInstance.getServiceId()));
            }

        }
        return "hello";
    }

}
