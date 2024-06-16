package com.deiz0n.springsecurity.controllers;

import com.deiz0n.springsecurity.domain.exceptions.UserExistingException;
import com.deiz0n.springsecurity.domain.utils.Error;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.time.Instant;

@ControllerAdvice
public class HandleController {

    @ExceptionHandler({UserExistingException.class})
    public ResponseEntity<Error> handleUserExistingException(UserExistingException e, HttpServletRequest request) {
        var error = new Error(
                Instant.now(),
                "Resource existing",
                HttpStatus.BAD_REQUEST,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler({InternalAuthenticationServiceException.class, BadCredentialsException.class})
    public ResponseEntity<Error> handleFailedAuthentication(HttpServletRequest request) {
        var error = new Error(
                Instant.now(),
                "Error in authentication",
                HttpStatus.UNAUTHORIZED,
                "Email or password incorrect",
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<Error> handleAccessDaniedException(HttpServletRequest request) {
        var error = new Error(
                Instant.now(),
                "Access danied",
                HttpStatus.UNAUTHORIZED,
                "The user don't have permission for this action",
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler({InsufficientAuthenticationException.class})
    public ResponseEntity<Error> handleInsufficientAuthException(HttpServletRequest request) {
        var error = new Error(
                Instant.now(),
                "Token invalid",
                HttpStatus.UNAUTHORIZED,
                "Token is expired, invalid or null",
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

}
