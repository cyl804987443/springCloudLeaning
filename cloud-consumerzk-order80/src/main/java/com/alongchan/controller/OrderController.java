package com.alongchan.controller;


import com.alongchan.entities.Payment;
import com.alongchan.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.management.ObjectName;

/**
 *
 * @author alongchan
 */
@RestController
@Slf4j
public class OrderController {

//    private static  final String PAYMENT_URL="http://localhost:8001";

      private static  final String INVOKE_URL="http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    private String paymentInfo(){
        String object = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return object;
    }

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(INVOKE_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getById/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(INVOKE_URL+"/payment/getPayment/"+id,CommonResult.class);
    }
}
