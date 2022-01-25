package com.coderhouse.ClientAop.interceptor;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAroundClient {

    Logger logger = LogManager.getLogger(AspectAroundClient.class);


    @Pointcut("execution(* com.coderhouse.ClientAop.service.ClientService.*(..))" +
            "&& !execution(* com.coderhouse.ClientAop.service.ClientService.deleteClient(..))")
    public void allMinusDelete() {}

    @Around("allMinusDelete()")
    public Object logMethodTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        Object methodReturn = pjp.proceed();
        long end = System.nanoTime();
        logger.info("Method '" + pjp.getSignature().getName() + "' executed with " + TimeUnit.NANOSECONDS.toMillis(end - start) + "ms");
        return methodReturn;
    }
}
