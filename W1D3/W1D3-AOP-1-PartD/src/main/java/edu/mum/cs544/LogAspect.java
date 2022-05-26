package edu.mum.cs544;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Date;
import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {

    private static Logger logger = Logger.getLogger(LogAspect.class.getName());

    @After("execution(* edu.mum.cs544.EmailSender.sendEmail(String, String))")
    public void logAfter(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String email = (String)args[0];
        String message = (String) args[1];
        logger.info(new Date() + " method-name=" + joinPoint.getSignature().getName()
        + " address= " + email + "\n" + "message= " + message);
    }


    @Around("execution(* edu.mum.cs544.CustomerDAO.*(..))")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch(); sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        System.out.println("Time to execute save = " + totaltime + "ms");
        return retVal;
    }

}
