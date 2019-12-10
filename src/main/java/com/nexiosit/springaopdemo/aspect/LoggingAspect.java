package com.nexiosit.springaopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(com..UserResponse com.nexiosit.springaopdemo.controller.UsersController.getUser(int))")
    public void logBefore() {
        LOGGER.info("About to call method UsersController.getUser");
    }
}
