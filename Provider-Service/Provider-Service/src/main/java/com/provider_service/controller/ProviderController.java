package com.provider_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    private Environment env;

    @GetMapping("/provider")
    public String provideService() {
        String msg="this is provider";
        String port=env.getProperty("server.port");
        return msg+"-port : "+port;
    }
}
