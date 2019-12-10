package com.nexiosit.springaopdemo.log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class ListAppender extends AppenderBase<ILoggingEvent> {

    public static final List<ILoggingEvent> events = new ArrayList<>();

    private final static List<String> ALLOWED_LOGGERS = Arrays.asList(
            "com.nexiosit.springaopdemo.controller.UsersController",
            "com.nexiosit.springaopdemo.aspect.LoggingAspect");

    @Override
    protected void append(ILoggingEvent e) {
        if (ALLOWED_LOGGERS.contains(e.getLoggerName())) {
            events.add(e);
        }
    }
}
