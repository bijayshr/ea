package edu.mum.cs544.bank.aspect;

import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class DAOLogAdvice {

    @Autowired
    ILogger logger;

    @Before("execution(* edu.mum.cs544.bank.dao.*.*(..))")
    public void logDAOCall(JoinPoint joinPoint){
        logger.log(joinPoint.getSignature().getName() + " is called");
    }

}
