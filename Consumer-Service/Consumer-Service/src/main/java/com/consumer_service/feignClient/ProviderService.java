package com.consumer_service.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="PROVIDER-SERVICE")
public interface ProviderService {

    @GetMapping("/provider")
    public String invokeProvideService();
}
