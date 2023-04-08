package com.alongchan.sevice;

import com.alongchan.entities.Payment;
import com.alongchan.response.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author alongchan
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface FeignService {

    @GetMapping("/payment/getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

}
