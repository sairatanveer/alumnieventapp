package com.saira.alumnieventapp.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler {
    @ExceptionHandler

    public final ResponseEntity<?> handleWalletException extends ResponseEntityExceptionHandler( EventException ex, WebRequest request)
    {
        EventExceptionResponse response=new EventExceptionResponse(ex.getMessage());
        return new ResponseEntity<EventExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
}
