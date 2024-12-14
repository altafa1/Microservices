package com.consumer_service.controller;

import com.consumer_service.feignClient.ProviderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private ProviderService providerService;


    @GetMapping("/consumer")
    @CircuitBreaker(name="providerbreaker",fallbackMethod = "providerFallback")
    public String helloWorld() {
       String msg="consumer service";

       String msg2=providerService.invokeProvideService();
       return msg+" - "+msg2;
    }

    public String providerFallback(Exception e){
        System.out.println(e.getMessage());
        return "providerFallback";
    }
}
