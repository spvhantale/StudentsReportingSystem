package com.swapnil.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyError> getStudentException(StudentException excep,WebRequest req){
		
		MyError myError=new MyError(excep.getMessage(), LocalDateTime.now(), req.getDescription(false));
			
		return new ResponseEntity<MyError>(myError,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(SemesterException.class)
	public ResponseEntity<MyError> getSemesterException(SemesterException excep,WebRequest req){
		
		MyError myError=new MyError(excep.getMessage(), LocalDateTime.now(), req.getDescription(false));
			
		return new ResponseEntity<MyError>(myError,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> getException(Exception excep,WebRequest req){
		
		MyError myError=new MyError(excep.getMessage(), LocalDateTime.now(), req.getDescription(false));
			
		return new ResponseEntity<MyError>(myError,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyError> getNoHandlerException(NoHandlerFoundException excep,WebRequest req){
		
		MyError myError=new MyError(excep.getMessage(), LocalDateTime.now(), req.getDescription(false));
			
		return new ResponseEntity<MyError>(myError,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> getMethodException(MethodArgumentNotValidException excep){
		
		MyError myError=new MyError(excep.getBindingResult().getFieldError().getDefaultMessage(), LocalDateTime.now(),"NotValidInformation");
			
		return new ResponseEntity<MyError>(myError,HttpStatus.BAD_REQUEST);
	}
	
}
