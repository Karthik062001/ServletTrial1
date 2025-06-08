package com.learn.log4j;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jTest {

	
	private static final Logger logger= LogManager.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		process();
	}
	public static void process()
	{
		logger.warn("This is a warning message.");
        logger.debug("This is a debug message.");
        logger.trace("This is a trace message.");
        logger.fatal("This is a fatal message.");
        logger.info("Application finished.");
        logger.error("An error occurred: ");
	}
}
