package com.vortex.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleException(Exception e, HttpServletRequest request){
        return new ApiError(404, e.getMessage(), request.getServletPath());
    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleEmployeeNotFoundException(EmployeeNotFoundException e, HttpServletRequest request){
        return new ApiError(404, e.getMessage(), request.getServletPath());
    }
    @ExceptionHandler(AverageSalaryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleAverageSalaryException(AverageSalaryException e, HttpServletRequest request){
        return new ApiError(400, e.getMessage(), request.getServletPath());
    }
    @ExceptionHandler(DepartmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleDepartmentNotFoundException (DepartmentNotFoundException e, HttpServletRequest request){
        return new ApiError(404, e.getMessage(), request.getServletPath());
    }

    @ExceptionHandler(JobNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleJobNotFoundException (JobNotFoundException e, HttpServletRequest request){
        return new ApiError(404, e.getMessage(), request.getServletPath());
    }
}
