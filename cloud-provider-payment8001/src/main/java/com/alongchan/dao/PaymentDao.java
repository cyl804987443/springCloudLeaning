package com.alongchan.dao;

import com.alongchan.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author alongchan
 */
@Mapper
public interface PaymentDao {

    /**
     * 根据Id获取payment
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);

    /**
     * 创建一个payment
     * @param payment
     * @return
     */
    int create(Payment payment);
}
