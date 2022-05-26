package edu.mum.cs544.bank.aspect;

import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JMSLogAdvice {
    @Autowired
    ILogger logger;

    @After("execution(* edu.mum.cs544.bank.jms.JMSSender.sendJMSMessage(String))")
    public void logJMSMessageSent(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String text = (String) args[0];
        logger.log("JMS Message Sent: " + text);
    }
}
