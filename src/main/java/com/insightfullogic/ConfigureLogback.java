package com.insightfullogic;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class ConfigureLogback {

    private static boolean configured = false;

    public static void configureLogging(URL configFile) throws JoranException {
        if (configured) return;
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        try {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(context);
            context.reset();
            configurator.doConfigure(configFile);
            configured = true;

        } catch (Throwable t) {
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(context);
    }
}
