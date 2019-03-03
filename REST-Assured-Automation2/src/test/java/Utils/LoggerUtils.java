package Utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtils {
	static Logger logger = Logger.getLogger(LoggerUtils.class);

	public static void debug(String message) {
		PropertyConfigurator.configure("src/test/resources/LoggingResources/log4j.properties");
		logger.debug("Log4j appender configuration is successful !!");
		logger.debug(message);
	}
}
