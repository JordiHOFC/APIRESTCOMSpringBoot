package br.com.nutrition.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class HandlerInterceptError {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError methodNotValid(MethodArgumentNotValidException e){
        List<FieldError> errors=e.getFieldErrors();
        List<ErrosResponse> allErrors=new ArrayList<>();
        allErrors.addAll(errors.stream().map(ErrosResponse::new).collect(Collectors.toList()));
        allErrors.addAll(e.getGlobalErrors().stream().map(er->new ErrosResponse(er.getObjectName(),er.getDefaultMessage().toString())).collect(Collectors.toList()));
        return new ApiError(allErrors);

    }
}
