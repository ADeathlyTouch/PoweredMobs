package com.collinriggs.electricmobs.util;

import com.collinriggs.electricmobs.ElectricMobs;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Created by Bread10 at 15:31 on 22/04/2017
public class LogHelper {

    public static final Logger LOGGER = LogManager.getLogger(ElectricMobs.MODID);

    public static void log(Level level, Object message) {
        LOGGER.log(level, ">>> " + message.toString());
    }
    public static void info(Object message) {
        log(Level.INFO, message);
    }
    public static void all(Object message) {
        log(Level.ALL, message);
    }
    public static void warn(Object message) {
        log(Level.WARN, message);
    }
    public static void debug(Object message) {
        log(Level.DEBUG, message);
    }
    public static void error(Object message) {
        log(Level.ERROR, message);
    }
    public static void fatal(Object message) {
        log(Level.FATAL, message);
    }

}