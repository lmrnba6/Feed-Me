package com.journaldev.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	private Log logger = LogFactory.getLog(ExceptionController.class);

	@ExceptionHandler( value = Exception.class )
	public String handelException(Model model, HttpServletRequest request, Exception ex) {
		
		/*logger.error("resquest" + request.getRequestURL() + "Throw an exaption", ex);*/
		model.addAttribute("ex", ex.getMessage());
		return "error";
	}

	

}
