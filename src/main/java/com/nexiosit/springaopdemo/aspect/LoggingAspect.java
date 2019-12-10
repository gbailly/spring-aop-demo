package com.nexiosit.springaopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.nexiosit.springaopdemo.model.UserResponse;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(com..UserResponse com.nexiosit.springaopdemo.controller.UsersController.getUser(int))")
    public void logBefore() {
        LOGGER.info("About to call method UsersController.getUser");
    }

    @AfterReturning(value = "execution(* com.nexiosit.springaopdemo.controller.*Controller.*(..))", returning = "user")
    public void logAfterReturning(final JoinPoint joinPoint, final UserResponse user) {
        LOGGER.info(String.format(
                "Returned from method %s.%s with %s",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                user));
    }
}
