package com.alongchan.springcloud.service;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLoadBalanceService {

    ServiceInstance getInstance(List<ServiceInstance> serviceInstanceList);
}
