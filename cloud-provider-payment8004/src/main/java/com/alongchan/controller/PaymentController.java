package com.alongchan.controller;


import com.alongchan.entities.Payment;
import com.alongchan.response.CommonResult;
import com.alongchan.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {



    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/zk")
    public String paymentZk() {
        return "springcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID();
    }


}
