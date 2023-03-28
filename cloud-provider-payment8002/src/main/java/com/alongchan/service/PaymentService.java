package com.alongchan.service;

import com.alongchan.entities.Payment;


/**
 * @author alongchan
 */
public interface PaymentService {
    /**
     * 根据Id获取payment
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);

    /**
     * 创建一个payment
     * @param payment
     * @return
     */
    int create(Payment payment);

}
