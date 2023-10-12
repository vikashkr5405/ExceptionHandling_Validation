package com.vikash.ExceptionHandling_Validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleException(MethodArgumentNotValidException mx)
    {
        Map<String,String> m=new HashMap<>();

        mx.getBindingResult().getAllErrors().forEach((error)->{
          String fieldName=((FieldError)error).getField();
          String message=error.getDefaultMessage();
          m.put(fieldName,message);
        });
        return new ResponseEntity<>(m,HttpStatus.BAD_REQUEST);

    }
}
