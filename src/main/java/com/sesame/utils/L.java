package com.sesame.utils;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class L {
	private static final Logger logger = LoggerFactory.getLogger(L.class);
	private static final org.apache.logging.log4j.Logger log = LogManager.getLogger();


	public static void i(String msg) {
//		logger.info(msg);
		log.info(msg);
	}

	public static void e(String msg){
//		logger.error(msg);
		log.error(msg);
	}

}
