package com.project.stock_management.exception;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * T. BOUDAA
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = LogManager.getLogger(ExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error"); 
        modelAndView.addObject("errorMessage", "An error occurred see the log file for more details.");
        logger.error("An error caused by : ",ex);
        ex.printStackTrace();
        return modelAndView;
    }
}