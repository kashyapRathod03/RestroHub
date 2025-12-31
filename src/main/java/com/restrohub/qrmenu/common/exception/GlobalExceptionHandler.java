//com/restrohub/qrmenu/common/exception/GlobalExceptionHandler.java
package com.restrohub.qrmenu.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

 @ExceptionHandler(ResourceNotFoundException.class)
 public ResponseEntity<ErrorResponse> handleResourceNotFound(
         ResourceNotFoundException ex) {
//     log.error("Resource not found: {}", ex.getMessage());
     
     ErrorResponse error = new ErrorResponse(
             HttpStatus.NOT_FOUND.value(),
             ex.getMessage(),
             LocalDateTime.now()
     );
     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
 }

 @ExceptionHandler(IllegalStateException.class)
 public ResponseEntity<ErrorResponse> handleIllegalState(
         IllegalStateException ex) {
//     log.error("Invalid state: {}", ex.getMessage());
     
     ErrorResponse error = new ErrorResponse(
             HttpStatus.BAD_REQUEST.value(),
             ex.getMessage(),
             LocalDateTime.now()
     );
     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
 }

 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<Map<String, Object>> handleValidationErrors(
         MethodArgumentNotValidException ex) {
     Map<String, String> errors = new HashMap<>();
     ex.getBindingResult().getAllErrors().forEach(error -> {
         String fieldName = ((FieldError) error).getField();
         String message = error.getDefaultMessage();
         errors.put(fieldName, message);
     });

     Map<String, Object> response = new HashMap<>();
     response.put("status", HttpStatus.BAD_REQUEST.value());
     response.put("errors", errors);
     response.put("timestamp", LocalDateTime.now());

     return ResponseEntity.badRequest().body(response);
 }

 public record ErrorResponse(int status, String message, LocalDateTime timestamp) {}
}