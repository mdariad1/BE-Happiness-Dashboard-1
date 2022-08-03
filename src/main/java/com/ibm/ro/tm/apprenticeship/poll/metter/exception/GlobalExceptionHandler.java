package com.ibm.ro.tm.apprenticeship.poll.metter.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponseDTO> handleConflict(CustomException exception){

        ExceptionResponseDTO responseDto = new ExceptionResponseDTO(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }
}
