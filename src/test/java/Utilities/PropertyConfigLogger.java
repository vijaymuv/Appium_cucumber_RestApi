package Utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PropertyConfigLogger {
static Logger log= Logger.getLogger(PropertyConfigLogger.class);
    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        log.debug("debugged");
        log.info("information");
        log.warn("warning");
        log.error("error");
        log.fatal("fatal messed");

    }

}
