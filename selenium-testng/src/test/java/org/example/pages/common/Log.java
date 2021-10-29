package org.example.pages.common;

import lombok.extern.slf4j.Slf4j;
import org.testng.Reporter;

@Slf4j
public class Log {

    public static void info(String message) {
        log.info("["+Thread.currentThread().getId()+"] " + message);
        Reporter.log("["+Thread.currentThread().getName()+"] " + message);
    }

}
