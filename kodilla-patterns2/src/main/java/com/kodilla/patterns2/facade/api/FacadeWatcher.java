package com.kodilla.patterns2.facade.api;

import com.kodilla.patterns2.facade.Order;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FacadeWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(com.kodilla.patterns2.aop.calculator.Watcher.class);

    @After("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..)) && args(number)")
    public void logEvent(long number) {
        LOGGER.info("Class: " + ", Args: " + ", " + number);
    }

}