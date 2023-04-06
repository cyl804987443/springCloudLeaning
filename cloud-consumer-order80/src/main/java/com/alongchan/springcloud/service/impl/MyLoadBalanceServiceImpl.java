package com.alongchan.springcloud.service.impl;

import com.alongchan.springcloud.service.MyLoadBalanceService;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author alongchan
 */
@Component
public class MyLoadBalanceServiceImpl implements MyLoadBalanceService {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    private final int getIndex(){
        int current;
        int next;
        do{
            current= atomicInteger.get();
            next= current == Integer.MAX_VALUE ?0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("次数next:"+next);
        return next;
    };

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstanceList) {
        if(serviceInstanceList==null||serviceInstanceList.size()==0){
            return null;
        }
        return serviceInstanceList.get(getIndex()%serviceInstanceList.size());
    }
}
