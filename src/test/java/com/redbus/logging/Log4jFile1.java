package com.redbus.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jFile1 {

	public static Logger logger = LogManager.getLogger(Log4jFile1.class);


	public static void logger(String log) {

		logger.info(log);
	}
}




