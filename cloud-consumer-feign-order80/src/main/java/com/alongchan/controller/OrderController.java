package com.alongchan.controller;

import com.alongchan.entities.Payment;
import com.alongchan.response.CommonResult;
import com.alongchan.sevice.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author alongchan
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private FeignService feignService;

    @GetMapping("/consumer/payment/getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        CommonResult<Payment> paymentById = feignService.getPaymentById(id);
        return paymentById;
    }
}
