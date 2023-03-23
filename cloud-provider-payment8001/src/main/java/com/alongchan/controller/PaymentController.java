package com.alongchan.controller;


import com.alongchan.entities.Payment;
import com.alongchan.response.CommonResult;
import com.alongchan.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        if (null != paymentService.getPaymentById(id)) {
            return new CommonResult<>(200, "查询成功", paymentService.getPaymentById(id));
        }
        return new CommonResult<>(500, "查询失败");

    }


    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        if (paymentService.create(payment) > 0) {
            log.info("插入成功");
            return new CommonResult<>(200, "插入数据库成功");
        }
        return CommonResult.error();
    }

}
