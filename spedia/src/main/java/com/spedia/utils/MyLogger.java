/*
 * MyLogger.java
 *
 * Created on October 13, 2007, 6:05 PM
 *
 * Wrapper over Apache Commons Logger. To Avoid dependency
 */

package com.spedia.utils;

/**
 *
 * @author Ram Awasthi
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyLogger {
    private Log log;
    
    public MyLogger(Class<?> clazz) {
        log = LogFactory.getLog(clazz);
    }
    
    public void info(Object o) {
        log.info(o);
    }
    
    public void debug(Object o) {
        log.debug(o);
    }
    
    public void trace(Object o) {
        log.trace(o);
    }
    
    public void warn(Object o) {
        log.warn(o);
    }
    
    public void error(Object o) {
        log.error(o);
    }
    
    public void fatal(Object o) {
        log.fatal(o);
    }
    
    public void info(Object o,Throwable throwable) {
        log.info(o,throwable);
    }
    
    public void debug(Object o,Throwable throwable) {
        log.debug(o,throwable);
    }
    
    public void trace(Object o,Throwable throwable) {
        log.trace(o,throwable);
    }
    
    public void warn(Object o,Throwable throwable) {
        log.warn(o,throwable);
    }
    
    public void error(Object o,Throwable throwable) {
        log.error(o,throwable);
    }
    
    public void fatal(Object o,Throwable throwable) {
        log.fatal(o,throwable);
    }
}
