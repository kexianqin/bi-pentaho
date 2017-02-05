package com.yoyohr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public abstract class AbstractAssertions {

    static final String ERROR_MESSAGE_FOR_ASSERTION = "{} assertion : {}\n";
    protected static final Logger logger = LoggerFactory.getLogger("[ERROR MESSAGE]");
    protected static final Logger log = LoggerFactory.getLogger("\n");

    /**
     * log error message if one wants to see it "live".
     */
    protected static void logAssertionErrorMessage(String assertionContext, AssertionError e) {
        logger.info(ERROR_MESSAGE_FOR_ASSERTION, assertionContext, e.getMessage());
    }

}
