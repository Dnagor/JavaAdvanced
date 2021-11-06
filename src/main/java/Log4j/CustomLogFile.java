package Log4j;

import com.mysql.cj.log.Log;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class CustomLogFile {
   private static final Logger LOG = Logger.getLogger(CustomLogFile.class);

    public static void main(String[] args) {
        logWithBasicConfigurator();
        logWithDomConfigurator();
    }

    public static void logWithBasicConfigurator(){
        BasicConfigurator.configure();
        LOG.info("Info Message");
        LOG.debug("Debug Logger message");
        LOG.trace("Trace Message");
        LOG.error("Error Message");
        LOG.warn("Warn Message");
        LOG.fatal("Fatal Message");
    }

    public static void logWithDomConfigurator(){
        DOMConfigurator.configure("loggerConfig.xml");
        LOG.info("Info Message");
        LOG.debug("Debug Logger message");
        LOG.trace("Trace Message");
        LOG.error("Error Message");
        LOG.warn("Warn Message");
        LOG.fatal("Fatal Message");
    }
}
