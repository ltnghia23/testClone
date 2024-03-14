package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.javaweb.DTO.ErrorResponseDTO;
import com.javaweb.customException.FieldRequiredException;

@ControllerAdvice
public class ControllerAdvisor {
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex, WebRequest request) {
		ErrorResponseDTO err = new ErrorResponseDTO();
		err.setError("how to?");
		List<String> detail = new ArrayList();
		detail.add("cannot divide any number for 0");
		err.setDetail(detail);
		return new ResponseEntity<Object>(err, HttpStatus.ACCEPTED);
	}
	
	@ExceptionHandler(FieldRequiredException.class)
	public ResponseEntity<Object> handleFieldRequiredException(FieldRequiredException ex, WebRequest request){
		ErrorResponseDTO err = new ErrorResponseDTO();
		err.setError(ex.getMessage());
		List<String> list = new ArrayList<String>();
		list.add("thieu data roi!!");
		err.setDetail(list);
		return new ResponseEntity<Object>(err, HttpStatus.BAD_REQUEST);
	}

}
