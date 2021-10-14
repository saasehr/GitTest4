package com.hospini.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResouceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResouceNotFoundException ex) {
        ExceptionResponse exresp = new ExceptionResponse();

        exresp.setErrorCode("NOT_FOUND");
        exresp.setErrorMessage(ex.getMessage());
        exresp.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(exresp, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> resourceAlreadyExists(ResourceAlreadyExistsException ex) {
        ExceptionResponse exresp = new ExceptionResponse();

        exresp.setErrorCode("CONFLICT");
        exresp.setErrorMessage(ex.getMessage());
        exresp.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(exresp, HttpStatus.CONFLICT);

    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<ExceptionResponse> unauthorizedException(UnauthorizedAccessException ex) {
        ExceptionResponse exresp = new ExceptionResponse();

        exresp.setErrorCode("UNAUTHORIZD");
        exresp.setErrorMessage(ex.getMessage());
        exresp.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(exresp, HttpStatus.UNAUTHORIZED);

    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> customException(CustomException ex) {
        ExceptionResponse exresp = new ExceptionResponse();

        exresp.setErrorCode("BAD_REQUEST");
        exresp.setErrorMessage(ex.getMessage());
        exresp.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(exresp, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ColumnValueNullException.class)
    public ResponseEntity<ExceptionResponse> coumnValueException(ColumnValueNullException ex) {
        ExceptionResponse exresp = new ExceptionResponse();

        exresp.setErrorCode("BAD_REQUEST");
        exresp.setErrorMessage(ex.getMessage());
        exresp.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(exresp, HttpStatus.BAD_REQUEST);

    }


    
    @ExceptionHandler(UserNameNotFoundException.class)
    public ResponseEntity<ExceptionResponse> userNameNotFoundException(UserNameNotFoundException ex) {
        ExceptionResponse exresp = new ExceptionResponse();

        exresp.setErrorCode("BAD_REQUEST");
        exresp.setErrorMessage(ex.getMessage());
        exresp.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(exresp, HttpStatus.BAD_REQUEST);

    }

}
