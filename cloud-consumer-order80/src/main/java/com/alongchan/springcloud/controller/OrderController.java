package com.alongchan.springcloud.controller;


import com.alongchan.entities.Payment;
import com.alongchan.response.CommonResult;
import com.alongchan.springcloud.service.impl.MyLoadBalanceServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author alongchan
 */
@RestController
@Slf4j
public class OrderController {

//    private static  final String PAYMENT_URL="http://localhost:8001";

      private static  final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MyLoadBalanceServiceImpl myLoadBalanceService;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getById/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPayment/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/myLoadbalance")
    public String testMyLoadBalance(){
        List<ServiceInstance> instances= discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances==null||instances.size()==0){
            return "无";
        }
        ServiceInstance instance = myLoadBalanceService.getInstance(instances);
        return restTemplate.getForObject(instance.getUri()+"/payment/getServerPort",String.class);
    };
}
