package com.example.fileupload.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleException(Exception ex){

        
//        System.out.println("["+ ex.getClass().getSimpleName() +"]");
        
        switch (ex.getClass().getSimpleName()){
  
            case "SQLException":  return ResponseEntity.status(204).body(ex.getMessage()); 
            case "NullPointerException": return ResponseEntity.status(302).body(ex.getMessage());

            case "IllegalArgumentException": return ResponseEntity.status(406)
                                             .body(ex.getMessage());
            
            
            case "IllegalStateException": return ResponseEntity.status(422)
                    							.body(ex.getMessage());
            
            case "MethodArgumentTypeMismatchException":  System.out.println("inside Switch: MethodArgumentTypeMismatchException");
            										return ResponseEntity.status(422)
															.body(ex.getMessage());	
            
            default: return ResponseEntity.status(502).body(ex.getMessage());
        }

    }
}