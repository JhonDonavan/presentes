package com.presentes.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class PresenteExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	
	@ExceptionHandler({PresentesExceptionsNotFound.class})
	public ResponseEntity<Object> PresenteNotFoundException(PresentesExceptionsNotFound ex, WebRequest request){
		
		ex.setMessage(messageSource.getMessage("msg.presente.notfound", new Object[] {ex.getId()}, LocaleContextHolder.getLocale()));
		
		return handleExceptionInternal(ex, new ResponseErrorBuild(ex.getMessage(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), 
				ex.toString()) , new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

}
