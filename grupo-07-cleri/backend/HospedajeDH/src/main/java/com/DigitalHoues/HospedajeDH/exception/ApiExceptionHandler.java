package com.DigitalHoues.HospedajeDH.exception;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.util.MissingFormatArgumentException;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ NotFoundException.class, UsernameNotFoundException.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception){
        log.error(exception.getMessage(), exception);
        return ErrorMessage.builder().statusCode(HttpStatus.NOT_FOUND.value()).exception(exception.getClass()
                .getSimpleName()).message(exception.getMessage()).path(request.getRequestURI()).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequestException.class, DuplicateKeyException.class, MethodArgumentNotValidException.class,
            MissingFormatArgumentException.class, MissingServletRequestParameterException.class,
            MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class})
    @ResponseBody
    public ErrorMessage badRequest(HttpServletRequest request, Exception exception){
        log.error(exception.getMessage(), exception);
        return ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value()).exception(exception.getClass()
                        .getSimpleName()).message(exception.getMessage()).path(request.getRequestURI()).build();
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({ForbiddenException.class, ExpiredJwtException.class})
    public ErrorMessage forbiddenRequest(HttpServletRequest request, Exception exception){
        log.error(exception.getMessage(), exception);
        return ErrorMessage.builder().statusCode(HttpStatus.FORBIDDEN.value()).exception(exception.getClass()
                .getSimpleName()).message(exception.getMessage()).path(request.getRequestURI()).build();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({AccessDeniedException.class})
    public void unauthorized(){
        log.error(HttpStatus.UNAUTHORIZED.toString());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ErrorMessage fatalErrorUnexpectedException(HttpServletRequest request, Exception exception){
        log.error(exception.getMessage(), exception);
        return ErrorMessage.builder().statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).exception(exception.getClass()
                .getSimpleName()).message(exception.getMessage()).path(request.getRequestURI()).build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({DataIntegrityViolationException.class, ObjectOptimisticLockingFailureException.class})
    @ResponseBody
    public ErrorMessage conflictException(HttpServletRequest request, Exception exception){
        log.error(exception.getMessage(), exception);
        return ErrorMessage.builder().statusCode(HttpStatus.CONFLICT.value()).exception(exception.getClass()
                .getSimpleName()).message(exception.getMessage()).path(request.getRequestURI()).build();
    }
/*
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(NotFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }


 */
}
