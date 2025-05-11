package com.telusko.SpringEcom.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidatonAspect {

    private static final Logger LOGGER= LoggerFactory.getLogger(ValidatonAspect.class);


    @Around("execution(* com.telusko.SpringEcom.service.ProductService.getAllProducts(..))")
    public Object validateAndUpdate(ProceedingJoinPoint jp,int postId) throws Throwable {
        if(postId<0)
        {
            LOGGER.info("postid is negative,upate positive");

            postId=-postId;

            LOGGER.info("new value "+postId);
        }

        Object obj=jp.proceed(new Object[]{postId});

        return obj;
    }

}
