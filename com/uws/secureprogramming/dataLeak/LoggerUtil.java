package com.uws.secureprogramming.dataLeak;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {

    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    static {
        try {
            // Create a file handler that logs messages to a file called "app.log"
            FileHandler fileHandler = new FileHandler("app.log", true); // true for append mode

            // Create a simple formatter
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

            // Add the handler to the logger
            logger.addHandler(fileHandler);

            // Set the logging level
            logger.setLevel(Level.ALL);

            // Prevent logging to the console
            logger.setUseParentHandlers(false);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error occurred in file handler setup", e);
        }
    }

    // Private constructor to prevent instantiation
    private LoggerUtil() {
    }

    public static void log(Level level, String message) {
        logger.log(level, message);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warning(String message) {
        logger.warning(message);
    }

    public static void severe(String message) {
        logger.severe(message);
    }
}
