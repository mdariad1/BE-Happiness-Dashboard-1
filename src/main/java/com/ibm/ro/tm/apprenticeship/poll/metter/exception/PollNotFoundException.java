package com.ibm.ro.tm.apprenticeship.poll.metter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NO_CONTENT)
public class PollNotFoundException extends RuntimeException{
    public PollNotFoundException(String message) {
        super(message);
    }
}
