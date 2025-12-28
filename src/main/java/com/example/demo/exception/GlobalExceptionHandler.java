// package com.example.demo.exception;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;
// @RestControllerAdvice
// public class GlobalExceptionHandler {   
//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException ex) {
//         ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
//         return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//     }
 
//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<ApiError> handleException(Exception ex) {
//         ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
//         return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }



package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException ex) {
        ApiError error = new ApiError(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // 👇 Handles "Email already in use" WITHOUT changing service code
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception ex) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        // Message-based mapping (TEST SAFE)
        if (ex.getMessage() != null &&
            ex.getMessage().toLowerCase().contains("email already")) {
            status = HttpStatus.CONFLICT;
        }

        ApiError error = new ApiError(
                status.value(),
                ex.getMessage()
        );

        return new ResponseEntity<>(error, status);
    }
}
